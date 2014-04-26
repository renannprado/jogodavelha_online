/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.jogodavelhaonline.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Renann
 */
public class Game extends Thread 
{
    private Player p1;
    private Player p2;
    private boolean gameOver = false;
    private BufferedReader in1 = null;
    private BufferedReader in2 = null;
    private DataOutputStream out1 = null;
    private DataOutputStream out2 = null;
    private int[][] m = new int[3][3]; //matriz para indicar o estado dos "campos" no jogo
                                            //0 = vazio
                                            //1 = player 1
                                            //2 = player 2
    
    private int resultado = -1;
    
    public Game(Player p1, Player p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                m[i][j] = 0;
            }
    }

    @Override
    public void run() 
    {
        try 
        {
            in1 = new BufferedReader(new InputStreamReader(p1.getS().getInputStream()));
            in2 = new BufferedReader(new InputStreamReader(p2.getS().getInputStream()));
            out1 = new DataOutputStream(p1.getS().getOutputStream());
            out2 = new DataOutputStream(p2.getS().getOutputStream());
        
            out1.writeBytes("CONEXAO_ACEITA:OK\n");
            
            Random r = new Random();
            int n1 = r.nextInt();
            int n2 = r.nextInt();
            
            if (n1 > n2)
            {
                p1.setSimbolo("X");
                p2.setSimbolo("O");
                p1.setStatus("SUA_VEZ");
                p2.setStatus("AGUARDE");
            }
            else
            {
                p2.setSimbolo("X");
                p1.setSimbolo("O");
                p2.setStatus("SUA_VEZ");
                p1.setStatus("AGUARDE");
            }
            
            out1.writeBytes("JOGO:SIMBOLO:" + p1.getSimbolo() + "\n");
            out1.writeBytes("JOGO:OPONENTE:" + p2.getName() + "\n");
            out1.writeBytes("STATUS:" + p1.getStatus() + "\n");
            
            
            out2.writeBytes("JOGO:SIMBOLO:" + p2.getSimbolo() + "\n");
            out2.writeBytes("JOGO:OPONENTE:" + p1.getName() + "\n");
            out2.writeBytes("STATUS:" + p2.getStatus() + "\n");
            
            while (!gameOver)
            {
                if (in1.ready())
                {
                    String s = in1.readLine();
                    LogMessages.addMessage(s);
                    applyLogic(s, 1);
                }
                else if (in2.ready())
                {
                    String s = in2.readLine();
                    LogMessages.addMessage(s);
                    applyLogic(s, 2);
                }
            }
                                
            if (resultado != 0)
            {
                switch (resultado)
                {
                    case 1:
                    {
                        out1.writeBytes("JOGO:FIM:VOCE\n");
                        out2.writeBytes("JOGO:FIM:OPONENTE\n");
                        break;
                    }
                    case 2:
                    {
                        out1.writeBytes("JOGO:FIM:OPONENTE\n");
                        out2.writeBytes("JOGO:FIM:VOCE\n");
                        break;
                    }
                    case 3:
                    {
                        out1.writeBytes("JOGO:FIM:VELHA\n");
                        out2.writeBytes("JOGO:FIM:VELHA\n");
                        break;
                    }
                }
                
                System.out.println("Fim do jogo.");
            }
            else
            {
                LogMessages.addMessage("Ocorreu um erro em um dos jogos.");
            }
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }    
    
    //msg = mensagem vinda do cliente
    //player = cliente que a enviou
    public void applyLogic(String msg, int player) throws IOException
    {
        String[] packet;

        if (msg.contains(":")) {
            packet = msg.split(":");
        } else {
            packet = new String[1];
            packet[0] = msg;
        }
        
        switch(packet[0])
        {
            case "CHAT": //CHAT:NICK:MSG
            {
                if (player == 1)
                {
                    out1.writeBytes("CHAT:" + p1.getName() + ":" + packet[1] + "\n");
                    out2.writeBytes("CHAT:" + p1.getName() + ":" + packet[1] + "\n");
                    System.out.println(packet[1]);
                }
                else
                {
                    out1.writeBytes("CHAT:" + p2.getName() + ":" + packet[1] + "\n");
                    out2.writeBytes("CHAT:" + p2.getName() + ":" + packet[1] + "\n");
                    System.out.println(packet[1]);
                }
                
                break;
            }
            case "JOGADA":
            {
                int i = Integer.parseInt(packet[1]) - 1;
                int j = Integer.parseInt(packet[2]) - 1;
                
                if (m[i][j] == 0) //é uma jogada válida
                {                   
                    if (player == 1 && p1.getStatus().equals("SUA_VEZ"))
                    {
                        m[i][j] = player;
                        out1.writeBytes("JOGADA:OK:" + p1.getSimbolo() + ":" + packet[1] + ":" + packet[2] + "\n");
                        p1.setStatus("AGUARDE");
                        out2.writeBytes("JOGADA:OK:" + p1.getSimbolo() + ":" + packet[1] + ":" + packet[2] + "\n");
                        p2.setStatus("SUA_VEZ");
                        
                        out1.writeBytes("STATUS:" + p1.getStatus() + "\n");
                        out2.writeBytes("STATUS:" + p2.getStatus() + "\n");
                        
                        verificarSeAcabou();
                    }
                    else if (player == 2 && p2.getStatus().equals("SUA_VEZ"))
                    {
                        m[i][j] = player;
                        out1.writeBytes("JOGADA:OK:" + p2.getSimbolo() + ":" + packet[1] + ":" + packet[2] + "\n");
                        p1.setStatus("SUA_VEZ");
                        out2.writeBytes("JOGADA:OK:" + p2.getSimbolo() + ":" + packet[1] + ":" + packet[2] + "\n");
                        p2.setStatus("AGUARDE");
                        
                        out1.writeBytes("STATUS:" + p1.getStatus() + "\n");
                        out2.writeBytes("STATUS:" + p2.getStatus() + "\n");
                        
                        verificarSeAcabou();
                    }
                    else if (player == 1)
                    {
                        out1.writeBytes("JOGADA:INVALIDA\n");
                    }
                    else if (player == 2)
                    {
                        out2.writeBytes("JOGADA:INVALIDA\n");
                    }                    
                }
                else if (player == 1)
                {
                    out1.writeBytes("JOGADA:INVALIDA\n");
                }
                else if (player == 2)
                {
                    out2.writeBytes("JOGADA:INVALIDA\n");
                }
                
                break;
            }
        }
    }
    
    /*
     * 0 = ainda não acabou;
     * 1 = player 1 ganhou
     * 2 = player 2 ganhou
     * 3 = deu velha
     */
    public void verificarSeAcabou() 
    {
       if (((m[0][0] == m[0][1]) && (m[0][1] == m[0][2]) && (m[0][2]) == 1 ) || //ok
           ((m[1][0] == m[1][1]) && (m[1][1] == m[1][2]) && (m[1][2]) == 1) || //ok
           ((m[2][0] == m[2][1]) && (m[2][1] == m[2][2]) && (m[2][2]) == 1) || //ok
           ((m[0][0] == m[1][0]) && (m[1][0] == m[2][0]) && (m[2][0]) == 1) || //ok
           ((m[0][1] == m[1][1]) && (m[1][1] == m[2][1]) && (m[2][1]) == 1) || //ok
           ((m[0][2] == m[1][2]) && (m[1][2] == m[2][2]) && (m[2][2]) == 1) || //ok   
           ((m[0][0] == m[1][1]) && (m[1][1] == m[2][2]) && (m[2][2]) == 1) || //ok
           ((m[2][0] == m[1][1]) && (m[1][1] == m[0][2]) && (m[0][2]) == 1))   //ok
       {
            gameOver = true;
            resultado = 1;
       }
       else if (((m[0][0] == m[0][1]) && (m[0][1] == m[0][2]) && (m[0][2]) == 2 ) || //ok
           ((m[1][0] == m[1][1]) && (m[1][1] == m[1][2]) && (m[1][2]) == 2) || //ok
           ((m[2][0] == m[2][1]) && (m[2][1] == m[2][2]) && (m[2][2]) == 2) || //ok
           ((m[0][0] == m[1][0]) && (m[1][0] == m[2][0]) && (m[2][0]) == 2) || //ok
           ((m[0][1] == m[1][1]) && (m[1][1] == m[2][1]) && (m[2][1]) == 2) || //ok
           ((m[0][2] == m[1][2]) && (m[1][2] == m[2][2]) && (m[2][2]) == 2) || //ok   
           ((m[0][0] == m[1][1]) && (m[1][1] == m[2][2]) && (m[2][2]) == 2) || //ok
           ((m[2][0] == m[1][1]) && (m[1][1] == m[0][2]) && (m[0][2]) == 2))   //ok
       {
           gameOver = true;
           resultado = 2;
       }
       else
       {
           int cont = 0;
           for (int i = 0; i < 3; i++)
           {
               for (int j = 0; j < 3; j++)
               {
                   if (m[i][j] != 0)
                       cont++;
               }
           }
           
           if (cont == 9)
           {
               gameOver = true;
               resultado = 3;           
           }
           else
           {
               resultado = 0;
           }
       }
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }
    
    private class Chat extends Thread
    {
        @Override
        public void run()
        {
        
        }
    }
}
//
//String msg;
//            try (BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) 
//            {
//                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
//                
//                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
//                
//                while ((msg = inFromClient.readLine()) != null) 
//                {
//                    String[] packet;
//                    
//                    if (msg.contains(":"))
//                    {
//                         packet = msg.split(":");
//                    }
//                    else
//                    {
//                        packet = new String[1];
//                        packet[0] = msg;
//                    }
//                    
//                    switch (packet[0])
//                    {
//                        case "CLIENTE":
//                        {
//                            LogMessages.addMessage("IP: " + clientSocket.getInetAddress() + "; NOME: " + packet[1]);
//                            outToClient.writeBytes("CONEXAO_ACEITA\n");
//                            break;
//                        }
//                        case "CHAT":
//                        {
//                            
//                        }
//                        default:
//                        {
//                            LogMessages.addMessage("IP: " + clientSocket.getInetAddress() + "; MSG: " + packet[0]);
//                            break;
//                        }
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(1);
//        }