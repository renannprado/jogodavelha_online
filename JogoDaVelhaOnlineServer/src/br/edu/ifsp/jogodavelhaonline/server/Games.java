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
public class Games {
    
    private static DefaultListModel listModel = null;
    
    public static void setListModel(DefaultListModel l)
    {
        listModel = l;
    }
    
    public static void addGame(Game g)
    {
        listModel.addElement("[" + g.getP1().getName() + "] vs [" + g.getP2().getName() + "]");
    }
}
