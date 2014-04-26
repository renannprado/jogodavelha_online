package velhacliente;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JogodaVelhaOnlineCliente.java
 *
 * Created on Jan 19, 2012, 8:29:38 PM
 */


import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos
 */
public class JogodaVelhaOnlineCliente extends JFrame 
{

    /** Creates new form JogodaVelhaOnlineCliente */
    public JogodaVelhaOnlineCliente() {
        initComponents();
        Cliente.setTxtStatus(txtStatus);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        grpBotoes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn21 = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMsg = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAdd = new javax.swing.JTextArea();
        btnEnviarMensagem = new javax.swing.JButton();
        txtIP = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblXO = new javax.swing.JLabel();
        btn22 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btn21.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn21.setText("-");
        grpBotoes.add(btn21);
        btn21.setEnabled(false);
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(btn21, gridBagConstraints);

        txtStatus.setEnabled(false);
        txtStatus.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 19;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel1.add(txtStatus, gridBagConstraints);

        jLabel5.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        jPanel1.add(jLabel5, gridBagConstraints);

        txtMsg.setColumns(20);
        txtMsg.setRows(5);
        txtMsg.setEnabled(false);
        jScrollPane1.setViewportView(txtMsg);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 20, 6);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        txtAdd.setColumns(20);
        txtAdd.setRows(5);
        txtAdd.setText("Escreva aqui uma mensagem.");
        jScrollPane2.setViewportView(txtAdd);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 9, 14, 5);
        jPanel1.add(jScrollPane2, gridBagConstraints);

        btnEnviarMensagem.setText("Enviar");
        btnEnviarMensagem.setEnabled(false);
        btnEnviarMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarMensagemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipady = 71;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 13, 6);
        jPanel1.add(btnEnviarMensagem, gridBagConstraints);

        txtIP.setText("localhost");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 10);
        jPanel1.add(txtIP, gridBagConstraints);

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 3;
        jPanel1.add(btnConectar, gridBagConstraints);

        txtNome.setText("Digite seu nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(txtNome, gridBagConstraints);

        lblXO.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblXO.setText("Você é: -");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 21;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(lblXO, gridBagConstraints);

        btn22.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn22.setText("-");
        grpBotoes.add(btn22);
        btn22.setEnabled(false);
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn22, gridBagConstraints);

        btn11.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn11.setText("-");
        grpBotoes.add(btn11);
        btn11.setEnabled(false);
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn11, gridBagConstraints);

        btn13.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn13.setText("-");
        grpBotoes.add(btn13);
        btn13.setEnabled(false);
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn13, gridBagConstraints);

        btn33.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn33.setText("-");
        grpBotoes.add(btn33);
        btn33.setEnabled(false);
        btn33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn33ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn33, gridBagConstraints);

        btn32.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn32.setText("-");
        grpBotoes.add(btn32);
        btn32.setEnabled(false);
        btn32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn32ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn32, gridBagConstraints);

        btn12.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn12.setText("-");
        grpBotoes.add(btn12);
        btn12.setEnabled(false);
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn12, gridBagConstraints);

        btn31.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn31.setText("-");
        grpBotoes.add(btn31);
        btn31.setEnabled(false);
        btn31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn31ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn31, gridBagConstraints);

        btn23.setFont(new java.awt.Font("Vrinda", 1, 48)); // NOI18N
        btn23.setText("-");
        grpBotoes.add(btn23);
        btn23.setEnabled(false);
        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 11, 4, 9);
        jPanel1.add(btn23, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Chat:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
// TODO add your handling code here:
    if (Cliente.TLisConected()) {
        Cliente.applyLogic("DESCONECTAR");
        txtNome.setEnabled(true);
        txtIP.setEnabled(true);
        btnConectar.setText("conectar");
        return;
    }

    if (txtNome.getText().equals("") || txtNome.getText().equals("Digite seu nome")) {
        JOptionPane.showMessageDialog(this, "Insira o nome do jogador");
        return;
    }

    if (!Cliente.configSocket(txtIP.getText(), 10000, txtNome.getText(), new LogicaInterface())) {
        JOptionPane.showMessageDialog(this, "Falha ao conectar.\nTente novamente");
    } else {
        txtNome.setEnabled(false);
        txtIP.setEnabled(false);
        btnConectar.setText("Desconectar");
        
    }

}//GEN-LAST:event_btnConectarActionPerformed

    private void btnEnviarMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarMensagemActionPerformed

        Cliente.sendPacket("CHAT:" + txtAdd.getText() + "\n");
        txtAdd.setText("");
    }//GEN-LAST:event_btnEnviarMensagemActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        
        Cliente.sendPacket("JOGADA:2:1\n");
        
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        
        Cliente.sendPacket("JOGADA:2:2\n");
        
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed

        Cliente.sendPacket("JOGADA:1:1\n");
        
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        
        Cliente.sendPacket("JOGADA:1:3\n");
        
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn33ActionPerformed
        
        Cliente.sendPacket("JOGADA:3:3\n");
        
    }//GEN-LAST:event_btn33ActionPerformed

    private void btn32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn32ActionPerformed
        
        Cliente.sendPacket("JOGADA:3:2\n");
        
    }//GEN-LAST:event_btn32ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        
        Cliente.sendPacket("JOGADA:1:2\n");
        
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn31ActionPerformed
        
        Cliente.sendPacket("JOGADA:3:1\n");
        
    }//GEN-LAST:event_btn31ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        
        Cliente.sendPacket("JOGADA:2:3\n");
        
    }//GEN-LAST:event_btn23ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */


        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JogodaVelhaOnlineCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogodaVelhaOnlineCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogodaVelhaOnlineCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogodaVelhaOnlineCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JogodaVelhaOnlineCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn11;
    public javax.swing.JButton btn12;
    public javax.swing.JButton btn13;
    public javax.swing.JButton btn21;
    public javax.swing.JButton btn22;
    public javax.swing.JButton btn23;
    public javax.swing.JButton btn31;
    public javax.swing.JButton btn32;
    public javax.swing.JButton btn33;
    public javax.swing.JButton btnConectar;
    public javax.swing.JButton btnEnviarMensagem;
    private javax.swing.ButtonGroup grpBotoes;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblXO;
    public javax.swing.JTextArea txtAdd;
    public javax.swing.JTextField txtIP;
    public javax.swing.JTextArea txtMsg;
    public javax.swing.JTextField txtNome;
    public javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

    public class LogicaInterface {

        public void setEnableButtons(boolean state)
        {
            Enumeration<AbstractButton> elements = grpBotoes.getElements();
            while (elements.hasMoreElements()) {
                    AbstractButton b = elements.nextElement();

                    b.setEnabled(state);
            }
        }
        
        public void applyLogic(String msg) 
        {
            String[] packet;
            
            if (msg != null) {

                if (msg.contains(":")) {
                    packet = msg.split(":");
                } else {
                    packet = new String[1];
                    packet[0] = msg;
                }

                switch (packet[0]) {
                    case "CHAT":
                        if (packet[1].equals("BLOQUEAR")) {
                            
                            btnEnviarMensagem.setEnabled(false);

                        } else if (packet[1].equals("DESBLOQUEAR")) {
                            btnEnviarMensagem.setEnabled(true);

                        } else if (packet[1].equals("MESSAGE")) {
                            txtMsg.setText(txtMsg.getText() + packet[2] + " disse: " + packet[3] + "\n");
                        }
                        break;
                    case "GAME":
                    {
                        Enumeration<AbstractButton> elements = grpBotoes.getElements();
                        
                        if (packet[1].equals("BLOQUEAR")) 
                        {
                            setEnableButtons(false);
                        }
                        else if (packet[1].equals("DESBLOQUEAR")) 
                        {
                            setEnableButtons(true);
                        }
                        else if (packet[1].equals("FIM"))
                        {
                            applyLogic("GAME:BLOQUEAR");
                            applyLogic("CHAT:BLOQUEAR");
                            switch(packet[2])
                            {
                                case "VOCE":
                                {
                                    JOptionPane.showMessageDialog(JogodaVelhaOnlineCliente.this, "Você venceu!");
                                    break;
                                }
                                case "OPONENTE":
                                {
                                    JOptionPane.showMessageDialog(JogodaVelhaOnlineCliente.this, Cliente.getOpNickName() + " venceu!");
                                    break;
                                }
                                case "VELHA":
                                {
                                    JOptionPane.showMessageDialog(JogodaVelhaOnlineCliente.this, "Deu velha!");                                    
                                    break;
                                }
                            }
                        }
                        
                        break;
                    }
                    case "LABEL": //LABEL:LBLXO:{X,O}
                        if (packet[1].equals("LBLXO")) {
                            lblXO.setText("Você é: " + packet[2]);
                        }
                        break;
                    case "JOGADA":
                    {
                        if (packet[1].equals("OK"))
                        {
                            String s = packet[2];
                            
                            switch(packet[3]) //packet[3] seria a linha do simbolo
                            {
                                case "1":
                                {
                                    switch(packet[4]) //packet[4] seria a coluna do simbolo
                                    {
                                        case "1":
                                        {
                                            btn11.setText(s);
                                            break;
                                        }
                                        case "2":
                                        {
                                            btn12.setText(s);
                                            break;
                                        }
                                        case "3":
                                        {
                                            btn13.setText(s);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case "2":
                                {
                                    switch(packet[4])
                                    {
                                        case "1":
                                        {
                                            btn21.setText(s);
                                            break;
                                        }
                                        case "2":
                                        {
                                            btn22.setText(s);
                                            break;
                                        }
                                        case "3":
                                        {
                                            btn23.setText(s);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case "3":
                                {
                                    switch(packet[4])
                                    {
                                        case "1":
                                        {
                                            btn31.setText(s);
                                            break;
                                        }
                                        case "2":
                                        {
                                            btn32.setText(s);
                                            break;
                                        }
                                        case "3":
                                        {
                                            btn33.setText(s);
                                            break;
                                        }
                                    }
                                    break;
                                }     
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(JogodaVelhaOnlineCliente.this, "Jogada inválida.");
                        }
                        
                        break;
                    }
                    case "STATUS":
                    {
                        if (packet[1].equals("SUA_VEZ"))
                        {
                            Cliente.changeTxtStatus("Sua vez. Faça uma jogada.");
                        }
                        else if (packet[1].equals("AGUARDE"))
                        {
                        Cliente.changeTxtStatus("Aguarde a jogada do oponente.");
                        }
                        else
                        {
                            Cliente.changeTxtStatus("Deu pau.");                            
                        }
                        
                        break;
                    }
                }
            }
        }
    }
}
