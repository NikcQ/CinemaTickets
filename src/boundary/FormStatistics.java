/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.ManageMovie;
import control.ManageProjection;
import control.CinemApp;
import entity.Movie;
import entity.Projection;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class FormStatistics extends javax.swing.JPanel {

    ArrayList<Projection> filteredProj;

    /**
     * Creates new form statistics
     */
    public FormStatistics() {
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
        loadBTN = new javax.swing.JButton();
        filterbydateBTN = new javax.swing.JButton();
        startTXT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        projectionCBX = new javax.swing.JComboBox<>();
        generateBTN = new javax.swing.JButton();
        filterbymovieBTN = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        endTXT = new javax.swing.JTextField();
        singleReportBTN = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 400));

        jLabel1.setText("Movies:");

        movieCBX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieCBXActionPerformed(evt);
            }
        });

        loadBTN.setText("LOAD PROJECTIONS / RESET FILTERS");
        loadBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBTNActionPerformed(evt);
            }
        });

        filterbydateBTN.setText("Filter by Date");
        filterbydateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterbydateBTNActionPerformed(evt);
            }
        });

        jLabel2.setText("Projections:");

        generateBTN.setText("GENERATE REPORT");
        generateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBTNActionPerformed(evt);
            }
        });

        filterbymovieBTN.setText("Filter by movie");
        filterbymovieBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterbymovieBTNActionPerformed(evt);
            }
        });

        jLabel3.setText("Start date:");

        jLabel4.setText("End date:");

        singleReportBTN.setText("Single Projection Report");
        singleReportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleReportBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loadBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(movieCBX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(endTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(filterbydateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(projectionCBX, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterbymovieBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(singleReportBTN, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadBTN)
                    .addComponent(generateBTN))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterbymovieBTN)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterbydateBTN)
                    .addComponent(startTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectionCBX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(singleReportBTN)
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBTNActionPerformed
        // TODO add your handling code here:

        System.out.println("Loading...");
        // Display all Projections
        projectionCBX.removeAllItems();
        filteredProj = ManageProjection.getAllProjections();
        for (String d : ManageProjection.getProjectionDescriptions(filteredProj, true)) {
            projectionCBX.addItem(d);
        }
        // Display all Movies
        movieCBX.removeAllItems();
        for (String t : ManageProjection.getProjectionTitles(filteredProj)) {
            movieCBX.addItem(t);
        }
        System.out.println("Loaded");

    }//GEN-LAST:event_loadBTNActionPerformed

    private void movieCBXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieCBXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieCBXActionPerformed

    private void filterbymovieBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterbymovieBTNActionPerformed
        // TODO add your handling code here:
        System.out.println("Filtering by Movie... \"" + (String) movieCBX.getSelectedItem() + "\"");
        // Filter and display projections of the selected movie
        projectionCBX.removeAllItems();
        filteredProj = ManageProjection.filterProjectionsByTitle(filteredProj, (String) movieCBX.getSelectedItem());
        for (String d : ManageProjection.getProjectionDescriptions(filteredProj, true)) {
            projectionCBX.addItem(d);
            //System.out.println(d);
        }
        System.out.println("Filtered by Movie.");
    }//GEN-LAST:event_filterbymovieBTNActionPerformed

    private void generateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBTNActionPerformed
        // TODO add your handling code here:
        System.out.println(ManageProjection.getReport(filteredProj));
    }//GEN-LAST:event_generateBTNActionPerformed

    private void filterbydateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterbydateBTNActionPerformed
        // TODO add your handling code here:
        LocalDate start = LocalDate.parse(startTXT.getText());
        LocalDate end = LocalDate.parse(endTXT.getText());
        if (start.isAfter(end)) {
            System.out.println("The START date is after the END date.");
        } else {
            System.out.println("Filtering by Date...");
            // Filter and display projections on the selected date
            projectionCBX.removeAllItems();
            filteredProj = ManageProjection.filterProjectionsByDate(filteredProj, start, end);

            for (String d : ManageProjection.getProjectionDescriptions(filteredProj, true)) {
                projectionCBX.addItem(d);
            }

            // update movies and show only those with projections on the date
            movieCBX.removeAllItems();
            for (String t : ManageProjection.getProjectionTitles(filteredProj)) {
                movieCBX.addItem(t);
            }
            System.out.println("Filtered by Date.");
        }
    }//GEN-LAST:event_filterbydateBTNActionPerformed

    private void singleReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleReportBTNActionPerformed
        // TODO add your handling code here:
        if (projectionCBX.getSelectedItem() != null) {
            //setRowCBX(ManageProjection.getProjection((String) projectionCBX.getSelectedItem()), "GA");
            System.out.println(ManageProjection.getReport(ManageProjection.getProjection((String) projectionCBX.getSelectedItem())));
        }
    }//GEN-LAST:event_singleReportBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField endTXT;
    private javax.swing.JButton filterbydateBTN;
    private javax.swing.JButton filterbymovieBTN;
    private javax.swing.JButton generateBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loadBTN;
    private javax.swing.JComboBox<String> movieCBX;
    private javax.swing.JComboBox<String> projectionCBX;
    private javax.swing.JButton singleReportBTN;
    private javax.swing.JTextField startTXT;
    // End of variables declaration//GEN-END:variables
}
