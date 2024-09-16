/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Poker_Game;



/**
 *
 * @author billi
 */
public class WelcomeMenu extends javax.swing.JFrame {

    /**
     * Creates new form WelcomeMenu
     */
    
    private PokerCLI pokerCLI; // Reference to PokerCLI for game logic
    
    public WelcomeMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomePanel1 = new javax.swing.JPanel();
        EnterGameButton1 = new javax.swing.JButton();
        ShowUserListButton1 = new javax.swing.JButton();
        UserGameLogButton1 = new javax.swing.JButton();
        ExitGameButton1 = new javax.swing.JButton();
        WelcomeLabel1 = new javax.swing.JLabel();
        pokerImageLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WelcomePanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.selectedBackground"));

        EnterGameButton1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        EnterGameButton1.setText("1. Play Game");
        EnterGameButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterGameButton1ActionPerformed(evt);
            }
        });

        ShowUserListButton1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        ShowUserListButton1.setText("2. Show list of Users");
        ShowUserListButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowUserListButton1ActionPerformed(evt);
            }
        });

        UserGameLogButton1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        UserGameLogButton1.setText("3. Show User Game Log");
        UserGameLogButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserGameLogButton1ActionPerformed(evt);
            }
        });

        ExitGameButton1.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        ExitGameButton1.setText("4. Exit Game");
        ExitGameButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitGameButton1ActionPerformed(evt);
            }
        });

        WelcomeLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        WelcomeLabel1.setText("Welcome To The Poker Game");

        pokerImageLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Poker_Game/—Pngtree—casino game design 600x600.png"))); // NOI18N

        javax.swing.GroupLayout WelcomePanel1Layout = new javax.swing.GroupLayout(WelcomePanel1);
        WelcomePanel1.setLayout(WelcomePanel1Layout);
        WelcomePanel1Layout.setHorizontalGroup(
            WelcomePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(WelcomePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanel1Layout.createSequentialGroup()
                        .addComponent(WelcomeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanel1Layout.createSequentialGroup()
                        .addComponent(pokerImageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addGroup(WelcomePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ExitGameButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UserGameLogButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(WelcomePanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(WelcomePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EnterGameButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ShowUserListButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
        );
        WelcomePanel1Layout.setVerticalGroup(
            WelcomePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WelcomePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WelcomePanel1Layout.createSequentialGroup()
                        .addComponent(WelcomeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pokerImageLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WelcomePanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EnterGameButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShowUserListButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserGameLogButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExitGameButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WelcomePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(WelcomePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitGameButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitGameButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitGameButton1ActionPerformed

    private void EnterGameButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterGameButton1ActionPerformed
        // When the "Play Game" button is clicked, open the AddPlayerNames GUI.
        new AddPlayerNames().setVisible(true); // Pass a new PokerCLI instance
        this.dispose();
    }//GEN-LAST:event_EnterGameButton1ActionPerformed

    private void ShowUserListButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowUserListButton1ActionPerformed
        new ListOfUsersMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ShowUserListButton1ActionPerformed

    private void UserGameLogButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserGameLogButton1ActionPerformed
        new UserNameForLog().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UserGameLogButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(WelcomeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new WelcomeMenu().setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EnterGameButton1;
    private javax.swing.JButton ExitGameButton1;
    private javax.swing.JButton ShowUserListButton1;
    private javax.swing.JButton UserGameLogButton1;
    private javax.swing.JLabel WelcomeLabel1;
    private javax.swing.JPanel WelcomePanel1;
    private javax.swing.JLabel pokerImageLabel1;
    // End of variables declaration//GEN-END:variables
}
