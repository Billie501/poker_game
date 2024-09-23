/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Poker_Game;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author billi
 */
public class AddPlayerNames extends javax.swing.JFrame {


       static String name;
       private PokerGame game;
       private PokerCLI pokerCLI;
    /**
     * Creates new form AddPlayerNames
     */
    
    public AddPlayerNames() {
        initComponents();
        game = new PokerGame();
        pokerCLI = new PokerCLI();
        
    }

    public AddPlayerNames(PokerCLI pokerCLI) {
        initComponents();
        this.pokerCLI = pokerCLI;
    }
    
//    public String[] getPlayerIds() {
//        String[] pids = GameState.getPlayers().toArray(new String[GameState.getPlayers().size()]);
//        
//        return pids;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SaveButton1 = new javax.swing.JButton();
        CancelButton1 = new javax.swing.JButton();
        PleaseEnterNameTextField1 = new javax.swing.JTextField();
        addPlayerNameLabel1 = new javax.swing.JLabel();
        enterYourNameLabel1 = new javax.swing.JLabel();
        NameofPlayerLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(815, 439));

        SaveButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        SaveButton1.setText("SAVE");
        SaveButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButton1ActionPerformed(evt);
            }
        });

        CancelButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CancelButton1.setText("CANCEL");
        CancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButton1ActionPerformed(evt);
            }
        });

        PleaseEnterNameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PleaseEnterNameTextField1ActionPerformed(evt);
            }
        });

        addPlayerNameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        addPlayerNameLabel1.setText("Adding Player Name");

        enterYourNameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        enterYourNameLabel1.setText("Please Enter Your Name: ");

        NameofPlayerLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addPlayerNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameofPlayerLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CancelButton1)
                            .addComponent(enterYourNameLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SaveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PleaseEnterNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(addPlayerNameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PleaseEnterNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterYourNameLabel1))
                .addGap(18, 18, 18)
                .addComponent(NameofPlayerLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaveButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButton1ActionPerformed
       if (PleaseEnterNameTextField1.getText().isEmpty()) {
        JLabel message = new JLabel("Please enter your name");
        message.setFont(new Font("Arial", Font.BOLD, 24));
        JOptionPane.showMessageDialog(null, message);
    } else {
        name = PleaseEnterNameTextField1.getText().trim();
        
        if (name.contains(" ")) {
            JLabel message = new JLabel("There can only be one player");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message); 
            PleaseEnterNameTextField1.setText("");
            return;  // Exit the method if there's already a player
        }
        
        // Add player and update label
        NameofPlayerLabel1.setText(name);
        
        JLabel successMessage = new JLabel("Successful Save!");
        successMessage.setFont(new Font("Arial", Font.BOLD, 24));
        JOptionPane.showMessageDialog(null, successMessage);
        PleaseEnterNameTextField1.setText("");
        
        this.dispose();  // Close current frame
        
        try {
            pokerCLI.start(name);  // Start the game    
        } catch (InterruptedException ex) {
            Logger.getLogger(AddPlayerNames.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_SaveButton1ActionPerformed
    }
    private void PleaseEnterNameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PleaseEnterNameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PleaseEnterNameTextField1ActionPerformed

    private void CancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButton1ActionPerformed
        this.dispose();  // Close the current frame
        new WelcomeMenu().setVisible(true);  // Open the welcome menu
    }//GEN-LAST:event_CancelButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPlayerNames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new AddPlayerNames().setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton1;
    private javax.swing.JLabel NameofPlayerLabel1;
    private javax.swing.JTextField PleaseEnterNameTextField1;
    private javax.swing.JButton SaveButton1;
    private javax.swing.JLabel addPlayerNameLabel1;
    private javax.swing.JLabel enterYourNameLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
