/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velhacliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import velhacliente.JogodaVelhaOnlineCliente.LogicaInterface;

/**
 *
 * @author carlos
 */
public class ThreadListener extends Thread {

    private String socketIP;
    private String clientName;
    private int socketPort;
    private Socket clientSocket = null;
    private DataOutputStream outToServer = null;
    private LogicaInterface logicaInterface = null;
    
    public LogicaInterface getLogicalInterface()
    {
        return logicaInterface;
    }
    
    public void sendPacket(String pkt)
    {
        try
        {
            outToServer.writeBytes(pkt);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void run() {

        String msg;

        Cliente.changeTxtStatus("Conectando a " + socketIP);

        try (Socket cSocker = new Socket(socketIP, socketPort)) {
            clientSocket = cSocker;
            outToServer = new DataOutputStream(ThreadListener.this.clientSocket.getOutputStream());            
            
            sendPacket(clientName + "\n");
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            do {
                msg = inFromServer.readLine();
                System.out.println(msg);

                String[] packet;

                if (msg.contains(":")) {
                    packet = msg.split(":");
                } else {
                    packet = new String[1];
                    packet[0] = msg;
                }

                switch (packet[0]) {
                    case "CONEXAO_ACEITA":
                        if (packet[1].equals("AGUARDE")) {
                            Cliente.changeTxtStatus("Conectado ao servidor, aguarde um oponente...");
                        } else if (packet[1].equals("OK")) {
                            Cliente.changeTxtStatus("Conectado ao oponente.");
                            Cliente.applyLogic("CHAT:DESBLOQUEAR");
                            Cliente.applyLogic("GAME:DESBLOQUEAR");
                        }

                        break;
                    case "CHAT": //CHAT:NICK:MSG
                    {
                        if (packet.length > 2) {
                            Cliente.applyLogic("CHAT:MESSAGE:" + packet[1] + ":" + packet[2]);
                        }
                        break;
                    }
                    case "JOGO":
                    {
                        if (packet[1].equals("OPONENTE")) 
                        {
                            Cliente.setOpNickName(packet[2]);
                        } 
                        else if (packet[1].equals("SIMBOLO")) 
                        {
                            Cliente.applyLogic("LABEL:LBLXO:" + packet[2]);
                        }
                        else if (packet[1].equals("FIM"))
                        {
                            Cliente.applyLogic("GAME:FIM:" + packet[2]);
                        }
                        
                        break;
                    }
                    case "JOGADA": //JOGADA:{OK,INVALIDA}:SIMBOLO:I:J (onde e I e J sao linha e coluna respectivamente)
                    {
                        if (packet[1].equals("OK"))
                        {
                            Cliente.applyLogic("JOGADA:" + packet[1] + ":" + packet[2] + ":" + packet[3] + ":" + packet[4]);
                        }
                        else if (packet[1].equals("INVALIDA"))
                        {
                            Cliente.applyLogic("JOGADA:INVALIDA");
                        }
                        
                        break;
                    }
                    case "STATUS":
                    {
                        Cliente.setStatus(packet[1]); 
                        Cliente.applyLogic("STATUS:" + packet[1]);
                        break;
                    }
                }
            } while (!isInterrupted());
            inFromServer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ThreadListener(String ip, int port, String name, LogicaInterface li) {
        socketIP = ip;
        socketPort = port;
        clientName = name;
        logicaInterface = li;
    }
}
