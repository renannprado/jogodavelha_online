/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package velhacliente;

import javax.swing.JTextField;
import velhacliente.JogodaVelhaOnlineCliente.LogicaInterface;

/**
 *
 * @author carlos
 */
public class Cliente {

    private static JTextField txtStatus = null;
    private static JTextField txtMsg = null;
    private static ThreadListener TL;
    private static String opNickName = null; //nickname do oponente
    private static String status = null; //status SUA_VEZ || AGUARDE

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Cliente.status = status;
    }
    
    public static void applyLogic(String msg)
    {
        TL.getLogicalInterface().applyLogic(msg);
    }
    
    public static void changeTxtMsg(String param) {
        txtMsg.setText(param);
    }

    public static String getOpNickName() {
        return opNickName;
    }

    public static void setOpNickName(String opNickName) {
        Cliente.opNickName = opNickName;
    }
    
    public static void sendPacket(String pkt)
    {
        TL.sendPacket(pkt);
    }

    public static void changeTxtStatus(String param) {
        txtStatus.setText(param);
    }

    public static void setTxtStatus(JTextField txtStatus) {
        Cliente.txtStatus = txtStatus;
    }

    public static ThreadListener getTL() {
        return TL;
    }

    public static boolean configSocket(String IP, int Port, String Name, LogicaInterface li) {

        TL = new ThreadListener(IP, Port, Name, li);

        TL.start();

        return TLisConected();
    }

    public static boolean TLisConected() {
        if (TL == null) {
            return false;
        }
        return TL.isAlive();
    }   
    
//    public static String getMessage(){
//        Socket clientSocket;
//        String mensagem = "";
//
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//        try {
//
//            clientSocket = new Socket(socketIP, socketPort);
//
//            DataOutputStream outToServer =
//                    new DataOutputStream(clientSocket.getOutputStream());
//            
//            
//        }
//        catch(Exception ex){
//            
//        }
//            
//        
//    }
//    public static void main(String[] args) {
//
//        Socket clientSocket;
//        String mensagem = "";
//
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//
//
//        try {
//
//            clientSocket = new Socket(socketIP, socketPort);
//
//            DataOutputStream outToServer =
//                    new DataOutputStream(clientSocket.getOutputStream());
//            
//            
//            
//            
//            while (!mensagem.equals("sair")) {
//                System.out.println("Digite a mensagem a ser enviada:");
//                mensagem = inFromUser.readLine();
//                outToServer.writeBytes(mensagem + '\n');
//
//            }
//
//            clientSocket.close();
//        } catch (Exception ex) {
//            System.out.println("Problemas no envio da mensagem");
//        }
//        System.out.println("Final do programa...");
//    }
}
