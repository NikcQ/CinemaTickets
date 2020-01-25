/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.ManageMovie;
import control.ManageProjection;
import control.ManageScreen;

/**
 *
 * @author Edisson
 */

public class FormProjection extends javax.swing.JPanel {

    /**
     * Creates new form NewProjectionForm
     */
    public FormProjection() {
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

        jLabel1 = new javax.swing.JLabel();
        movieCBX = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        screenCBX = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dateFLD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        timeFLD = new javax.swing.JTextField();
        is3DCHK = new javax.swing.JCheckBox();
        is4DCHK = new javax.swing.JCheckBox();
        submitBTN = new javax.swing.JButton();
        loadBTN = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 400));

        jLabel1.setText("Movie");

        movieCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieCBXActionPerformed(evt);
            }
        });

        jLabel2.setText("Screen");

        screenCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenCBXActionPerformed(evt);
            }
        });

        jLabel3.setText("Date");

        dateFLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFLDActionPerformed(evt);
            }
        });

        jLabel4.setText("Time");

        is3DCHK.setText("is 3D");
        is3DCHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is3DCHKActionPerformed(evt);
            }
        });

        is4DCHK.setText("is 4D");
        is4DCHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is4DCHKActionPerformed(evt);
            }
        });

        submitBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/entity/comprobado.png"))); // NOI18N
        submitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBTNActionPerformed(evt);
            }
        });

        loadBTN.setText("LOAD");
        loadBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 284, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(is3DCHK)
                                        .addGap(73, 73, 73)
                                        .addComponent(is4DCHK))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dateFLD, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(screenCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(timeFLD, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(movieCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 29, Short.MAX_VALUE)))
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitBTN)
                        .addGap(67, 67, 67))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(loadBTN)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loadBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(screenCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateFLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(timeFLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(is3DCHK)
                    .addComponent(is4DCHK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(submitBTN)
                .addGap(55, 55, 55))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateFLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFLDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFLDActionPerformed

    private void submitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBTNActionPerformed
        String result;
        result = ManageProjection.verifyProjection(timeFLD.getText(), dateFLD.getText(), is3DCHK.isSelected(), is4DCHK.isSelected(), (String) movieCBX.getSelectedItem(), (String) screenCBX.getSelectedItem());
        if (result.equals("Projection successfully created .")) {
            System.out.println(result);
            timeFLD.setText(null);
            dateFLD.setText(null);
            movieCBX.removeAllItems();
            screenCBX.removeAllItems();
            is3DCHK.setSelected(false);
            is4DCHK.setSelected(false);
        } else {
            System.out.println(result);
        }
    }//GEN-LAST:event_submitBTNActionPerformed

    private void loadBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBTNActionPerformed
        // TODO add your handling code here:
        movieCBX.removeAllItems();
        screenCBX.removeAllItems();

        for (String t : ManageMovie.getMovieTitles()) {
            movieCBX.addItem(t);
        }
        for (String n : ManageScreen.getScreenNames()) {
            screenCBX.addItem(n);
        }
    }//GEN-LAST:event_loadBTNActionPerformed

    private void movieCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieCBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieCBXActionPerformed

    private void screenCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenCBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_screenCBXActionPerformed

    private void is3DCHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is3DCHKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_is3DCHKActionPerformed

    private void is4DCHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is4DCHKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_is4DCHKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dateFLD;
    private javax.swing.JCheckBox is3DCHK;
    private javax.swing.JCheckBox is4DCHK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loadBTN;
    private javax.swing.JComboBox<String> movieCBX;
    private javax.swing.JComboBox<String> screenCBX;
    private javax.swing.JButton submitBTN;
    private javax.swing.JTextField timeFLD;
    // End of variables declaration//GEN-END:variables
}
//  JOptionPane.showMessageDialog(null, "Ok", "Projection Booked", JOptionPane.INFORMATION_MESSAGE);