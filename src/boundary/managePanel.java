/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

/**
 *
 * @author juanc
 */
public class managePanel extends javax.swing.JPanel {
    
    private movieForm1 movieFRM = new movieForm1();
    private projectionForm1 projFRM = new projectionForm1();
    private screenForm screenFRM = new screenForm();
    /**
     * Creates new form managePanel
     */
    public managePanel() {
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

        jToolBar1 = new javax.swing.JToolBar();
        projBTN = new javax.swing.JButton();
        moviesBTN = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        screensBTN = new javax.swing.JButton();
        containerManage = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        projBTN.setText("Projections");
        projBTN.setFocusable(false);
        projBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        projBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        projBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projBTNActionPerformed(evt);
            }
        });
        jToolBar1.add(projBTN);

        moviesBTN.setText("Movies");
        moviesBTN.setFocusable(false);
        moviesBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        moviesBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        moviesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moviesBTNActionPerformed(evt);
            }
        });
        jToolBar1.add(moviesBTN);
        jToolBar1.add(filler1);

        screensBTN.setText("Screens");
        screensBTN.setFocusable(false);
        screensBTN.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        screensBTN.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        screensBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screensBTNActionPerformed(evt);
            }
        });
        jToolBar1.add(screensBTN);

        containerManage.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("This is a label");
        containerManage.add(jLabel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(containerManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void projBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projBTNActionPerformed
        // TODO add your handling code here:
        containerManage.setVisible(false);
        containerManage.removeAll();
        containerManage.add(projFRM);
        containerManage.setVisible(true);
    }//GEN-LAST:event_projBTNActionPerformed

    private void moviesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moviesBTNActionPerformed
        // TODO add your handling code here:
        containerManage.setVisible(false);
        containerManage.removeAll();
        containerManage.add(movieFRM);
        containerManage.setVisible(true);
    }//GEN-LAST:event_moviesBTNActionPerformed

    private void screensBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screensBTNActionPerformed
        // TODO add your handling code here:
        containerManage.setVisible(false);
        containerManage.removeAll();
        containerManage.add(screenFRM);
        containerManage.setVisible(true);
    }//GEN-LAST:event_screensBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerManage;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton moviesBTN;
    private javax.swing.JButton projBTN;
    private javax.swing.JButton screensBTN;
    // End of variables declaration//GEN-END:variables
}
