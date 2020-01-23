/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import control.CinemApp;
import entity.Client;
import entity.Movie;
import entity.Projection;
import entity.Screen;
import entity.Ticket;
import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class PanelDebug extends javax.swing.JPanel {

    /**
     * Creates new form debuggingPanel
     */
    public PanelDebug() {
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

        printScreenBTN = new javax.swing.JButton();
        printMovieBTN = new javax.swing.JButton();
        printProjectionBTN = new javax.swing.JButton();
        printTicketBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        printClientBTN = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 400));

        printScreenBTN.setText("Print Screens");
        printScreenBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printScreenBTNActionPerformed(evt);
            }
        });

        printMovieBTN.setText("Print Movies");
        printMovieBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMovieBTNActionPerformed(evt);
            }
        });

        printProjectionBTN.setText("Print Projections");
        printProjectionBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printProjectionBTNActionPerformed(evt);
            }
        });

        printTicketBTN.setText("Print Tickets");
        printTicketBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTicketBTNActionPerformed(evt);
            }
        });

        jLabel1.setText("Welcome to the debugging panel:");

        printClientBTN.setText("Print Clients");
        printClientBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printClientBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(printScreenBTN)
                    .addComponent(printMovieBTN)
                    .addComponent(printProjectionBTN)
                    .addComponent(printTicketBTN)
                    .addComponent(printClientBTN))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(printScreenBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printMovieBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printProjectionBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printTicketBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printClientBTN)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void printScreenBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printScreenBTNActionPerformed
        // Fetch Screens from CinemApp>Theatre>{Screens}
        ArrayList<Screen> theScreens = CinemApp.getScreens();

        System.out.println("\n // PRINTING SCREENS BELOW // \n");

        for (Screen s : theScreens) {
            System.out.println(s);
        }

        System.out.println("\n // DONE PRINTING SCREENS // \n");
    }//GEN-LAST:event_printScreenBTNActionPerformed

    private void printMovieBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printMovieBTNActionPerformed
        // Fetch Movies from CinemApp>{Movies}
        ArrayList<Movie> theMovie = CinemApp.getListings();

        System.out.println("\n // PRINTING MOVIES BELOW // \n");

        for (Movie m : theMovie) {
            System.out.println(m);
        }

        System.out.println("\n // DONE PRINTING MOVIES // \n");
    }//GEN-LAST:event_printMovieBTNActionPerformed

    private void printProjectionBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printProjectionBTNActionPerformed
        // Fetch Projections from CinemApp>Theatre>{Projections}
        ArrayList<Projection> theProjections = CinemApp.getProjections();

        System.out.println("\n // PRINTING PROJECTIONS BELOW // \n");

        for (Projection p : theProjections) {
            System.out.println(p);
        }

        System.out.println("\n // DONE PRINTING PROJECTIONS // \n");
    }//GEN-LAST:event_printProjectionBTNActionPerformed

    private void printTicketBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printTicketBTNActionPerformed
        // Fetch Tickets from CinemApp>Theatre>{Tickets}
        // ArrayList<Ticket> theTickets = ¿?

        ArrayList<Ticket> theTickets = CinemApp.getTickets();

        System.out.println("\n // PRINTING TICKETS BELOW // \n");

        for (Ticket t : theTickets) {
            System.out.println(t);
        }

        System.out.println("\n // DONE PRINTING TICKETS // \n");
    }//GEN-LAST:event_printTicketBTNActionPerformed

    private void printClientBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printClientBTNActionPerformed
        // TODO add your handling code here:
        ArrayList<Client> theClients = CinemApp.getClients();

        System.out.println("\n // PRINTING CLIENTS BELOW // \n");

        for (Client c : theClients) {
            System.out.println(c);
        }

        System.out.println("\n // DONE CLIENTS TICKETS // \n");
    }//GEN-LAST:event_printClientBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton printClientBTN;
    private javax.swing.JButton printMovieBTN;
    private javax.swing.JButton printProjectionBTN;
    private javax.swing.JButton printScreenBTN;
    private javax.swing.JButton printTicketBTN;
    // End of variables declaration//GEN-END:variables
}
