/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.jogodavelhaonline.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Renann
 */
public class ServerThread extends Thread 
{
    private ServerSocket serverSocket = null;
    private String message = null;
    private ArrayList<Game> gameList = new ArrayList<>();
    private int port = 10000; // porta padrão
    
    public ServerThread(int port) {
        try {
            this.port = port;
            serverSocket = new ServerSocket(this.port);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() 
    {
        do
        {
            try
            {
                LogMessages.addMessage("Server started and listening at port " + port + ".");
                
                while (!isInterrupted())
                {
                    Socket sP1 = serverSocket.accept();                   
                    
                    LogMessages.addMessage("Client connected " + sP1.getRemoteSocketAddress().toString());
                    DataOutputStream out1 = new DataOutputStream(sP1.getOutputStream());
                    BufferedReader in1 = new BufferedReader(new InputStreamReader(sP1.getInputStream()));
                    
                    Player p1 = new Player();
                    p1.setName(in1.readLine());                    
                    
                    out1.writeBytes("CONEXAO_ACEITA:AGUARDE\n");
                    
                    LogMessages.addMessage("Client [" + p1.getName() + "] is waiting for another player.");
                    
                    Socket sP2 = serverSocket.accept();
                    
                    LogMessages.addMessage("Client connected " + sP2.getRemoteSocketAddress().toString());
                    
                    DataOutputStream out2 = new DataOutputStream(sP2.getOutputStream());
                    BufferedReader in2 = new BufferedReader(new InputStreamReader(sP2.getInputStream()));
                    
                    Player p2 = new Player();
                    p2.setName(in2.readLine());                    
                    
                    LogMessages.addMessage("Client [" + p2.getName() + "] connected, the game will start.");
                    
                    out2.writeBytes("CONEXAO_ACEITA:OK\n");
                    
                    p1.setS(sP1);
                    p2.setS(sP2);
                    
                    Game g = new Game(p1, p2);
                    gameList.add(g);
                    
                    Games.addGame(g);
                    
                    gameList.get(gameList.size() - 1).start();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }while (!isInterrupted());
        
        LogMessages.addMessage("O servidor parou.");
    }
}