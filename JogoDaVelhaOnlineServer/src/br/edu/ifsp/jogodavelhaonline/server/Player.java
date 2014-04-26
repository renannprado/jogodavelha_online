/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.jogodavelhaonline.server;

import java.net.Socket;

/**
 *
 * @author Renann
 */
public class Player {
     
    private String name;
    private Socket s;
    private String simbolo = null;
    private String status = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
    
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }
    
}
