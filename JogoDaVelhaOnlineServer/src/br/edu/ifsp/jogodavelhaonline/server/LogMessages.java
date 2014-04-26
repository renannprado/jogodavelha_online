/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.jogodavelhaonline.server;

import javax.swing.DefaultListModel;

/**
 *
 * @author Renann
 */
public class LogMessages {
    
    private static DefaultListModel listModel = null;
    
    public static DefaultListModel getMessages()
    {
        return listModel;
    }
    
    public static void addMessage(String s)
    {
        listModel.addElement(s);
    }
    
    public static void setModel(DefaultListModel model)
    {
        listModel = model;
    }
    
}
