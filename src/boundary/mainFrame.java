/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import DAO.MovieDAO;
import DAO.ProjectionDAO;
import DAO.ScreenDAO;
import entity.CinemApp;
import entity.Movie;
import entity.Screen;
import entity.Theater;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class mainFrame extends javax.swing.JFrame {
    
    public static CinemApp cinemapp = new CinemApp();
        private Inicio inicio=new Inicio();
    public static Theater theater = new Theater();
    
    // PANELS
    private managePanel managePNL = new managePanel();
    private ticketSalePanel ticketPNL = new ticketSalePanel();
    private debuggingPanel debugPNL = new debuggingPanel();
    
    // DAO
    public static MovieDAO pelicula = new MovieDAO();
    public static ProjectionDAO funcion = new ProjectionDAO();
    public static ScreenDAO salas = new ScreenDAO();
    
    
    
    
    /**
     * Creates new form MainFrame
     */
    public mainFrame() {
        initComponents();
        cinemapp.setListings(pelicula.readTable());//Inicialización de los arreglos desde la base de datos
        theater.setScreens(salas.readTable());
        theater.setProjections(funcion.readTable());
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
        jButton1 = new javax.swing.JButton();
        ticketsBTN = new javax.swing.JButton();
        statsBTN = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        debugBTN = new javax.swing.JButton();
        manageBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CinemApp");

        containerMain.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("This is a label main");
        containerMain.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setRollover(true);

        jButton1.setText("Inicio");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

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

        debugBTN.setText("Debugging");
        debugBTN.setFocusable(false);
        debugBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        debugBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        debugBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debugBTNActionPerformed(evt);
            }
        });
        jToolBar1.add(debugBTN);

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
                .addComponent(containerMain, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticketsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketsBTNActionPerformed
        containerMain.setVisible(false);
        containerMain.removeAll();
        containerMain.add(ticketPNL);
        containerMain.setVisible(true);
    }//GEN-LAST:event_ticketsBTNActionPerformed

    private void manageBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageBTNActionPerformed
        containerMain.setVisible(false);
        containerMain.removeAll();
        containerMain.add(managePNL);
        containerMain.setVisible(true);
    }//GEN-LAST:event_manageBTNActionPerformed

    private void debugBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debugBTNActionPerformed
        containerMain.setVisible(false);
        containerMain.removeAll();
        containerMain.add(debugPNL);
        containerMain.setVisible(true);
    }//GEN-LAST:event_debugBTNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                containerMain.setVisible(false);
        containerMain.removeAll();
        containerMain.add(inicio);

        containerMain.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton debugBTN;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton manageBTN;
    private javax.swing.JButton statsBTN;
    private javax.swing.JButton ticketsBTN;
    // End of variables declaration//GEN-END:variables
}
