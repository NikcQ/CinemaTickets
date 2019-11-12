/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.CinemApp;

/**
 *
 * @author Estudiante
 */
public class mainFrame extends javax.swing.JFrame {
    
    public static CinemApp cinemapp = new CinemApp();
    private managePanel managePNL = new managePanel();
    
    /**
     * Creates new form MainFrame
     */
    public mainFrame() {
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

        containerMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        ticketsBTN = new javax.swing.JButton();
        statsBTN = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        manageBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CinemApp");

        containerMain.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("This is a label main");
        containerMain.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setRollover(true);

        ticketsBTN.setText("Tickets");
        ticketsBTN.setFocusable(false);
        ticketsBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ticketsBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ticketsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketsBTNActionPerformed(evt);
            }
        });
        jToolBar1.add(ticketsBTN);

        statsBTN.setText("Statistics");
        statsBTN.setFocusable(false);
        statsBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statsBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(statsBTN);
        jToolBar1.add(filler1);

        manageBTN.setText("Manage");
        manageBTN.setFocusable(false);
        manageBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        manageBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        manageBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBTNActionPerformed(evt);
            }
        });
        jToolBar1.add(manageBTN);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerMain, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticketsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketsBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketsBTNActionPerformed

    private void manageBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBTNActionPerformed
        containerMain.setVisible(false);
        containerMain.removeAll();
        containerMain.add(managePNL);
        containerMain.setVisible(true);
    }//GEN-LAST:event_manageBTNActionPerformed

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerMain;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton manageBTN;
    private javax.swing.JButton statsBTN;
    private javax.swing.JButton ticketsBTN;
    // End of variables declaration//GEN-END:variables
}
