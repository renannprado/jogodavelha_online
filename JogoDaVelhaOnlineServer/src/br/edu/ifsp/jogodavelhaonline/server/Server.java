/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.jogodavelhaonline.server;

/**
 *
 * @author Renann
 */
public class Server {

    private static int port = 10000; //porta padrão
    private static ServerThread serverThread; //thread servidora
    private static String lastMessage = "";
    
    public static boolean isOnline()
    {
        if (serverThread != null)
        {
            return serverThread.isAlive();
        }
        else
        {
            return false;
        }
    }

    public static boolean startServer() 
    {
        if (serverThread == null) 
        {
            serverThread = new ServerThread(port);
        }
        
        if (!serverThread.isAlive())
            serverThread.start();
        
        return true;
    }

    public static boolean stopServer()
    {
        if (serverThread != null) 
        {
            serverThread.interrupt();
        }
        
        return true;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        Server.port = port;
    }
}
