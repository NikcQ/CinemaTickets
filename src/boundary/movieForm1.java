/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.Movie;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class movieForm1 extends javax.swing.JPanel {

    Movie movie1=new Movie();
    ArrayList lenguajes = new ArrayList();
            ArrayList genero = new ArrayList();

    /**
     * Creates new form movieForm1
     */
    public movieForm1() {
        initComponents();
//        movie2 = new Movie(null, 0, null, false, false);

        String[] arr = movie1.getMOVIE_GENRE();
        for (int i = 0; i < arr.length; i++) {
            listGeneros.addItem(arr[i]);

        }
        String[] arr1 = movie1.getMOVIE_LANGS();
        for (int i = 0; i < arr1.length; i++) {
            lenguajesList.addItem(arr1[i]);

        }
        String[] arr3 = movie1.getMOVIE_RATING();
        for (int i = 0; i < arr3.length; i++) {
            ratingList.addItem(arr3[i]);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        is3d = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        is4d = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        crear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lenguajesList = new javax.swing.JComboBox<>();
        title = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        listGeneros = new javax.swing.JComboBox<>();
        ratingList = new javax.swing.JComboBox<>();
        Cerrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        añadir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        is3d.setText("IS 3D");
        is3d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is3dActionPerformed(evt);
            }
        });

        jLabel1.setText("LENGTH");

        is4d.setText("IS 4D");
        is4d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                is4dActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        jLabel3.setText("LANGUAGE");

        lenguajesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lenguajesListActionPerformed(evt);
            }
        });

        title.setText("TITLE");

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("GENRE");

        titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloActionPerformed(evt);
            }
        });

        jLabel4.setText("RATING");

        listGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listGenerosActionPerformed(evt);
            }
        });

        ratingList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratingListActionPerformed(evt);
            }
        });

        Cerrar.setText("Cerrar");
        Cerrar.setActionCommand("Cerrar ");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });

        jLabel5.setText("DATE");

        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });

        añadir.setText("+");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lenguajesList, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(listGeneros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(74, 74, 74)
                        .addComponent(añadir))
                    .addComponent(jTextField1)
                    .addComponent(ratingList, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(is3d)
                        .addGap(94, 94, 94)
                        .addComponent(is4d)
                        .addGap(15, 15, 15))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crear)
                .addGap(18, 18, 18)
                .addComponent(Cerrar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(añadir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lenguajesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ratingList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(is3d)
                    .addComponent(is4d))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cerrar)
                    .addComponent(crear))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void is3dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is3dActionPerformed
        movie1.setIs3D(is3d.isSelected());
        if (is3d.isSelected() == true) {
            is4d.setSelected(false);
        }
    }//GEN-LAST:event_is3dActionPerformed

    private void is4dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_is4dActionPerformed
        movie1.setIs4D(is4d.isSelected());
        if (is4d.isSelected() == true) {
            is3d.setSelected(false);
        }
    }//GEN-LAST:event_is4dActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed

        movie1.setTitle(titulo.getText());
        movie1.setRuntime(Integer.parseInt(jTextField1.getText()));
        movie1.setRating((String) ratingList.getSelectedItem());
        movie1.setIs3D(is3d.isSelected());
        movie1.setIs4D(is4d.isSelected());
        String f = fecha.getText();
        movie1.setReleaseDate(LocalDate.parse(f));

        System.out.println(movie1.getTitle() + "\n");

        String[] geneross = movie1.getGenre();
        for (int i = 0; i < geneross.length; i++) {
            System.out.println(geneross[i]);
        }
        System.out.println("\n" + movie1.getRuntime() + "\n");

        for (int i = 0; i < movie1.getLanguages().length; i++) {
            System.out.println(movie1.getLanguages()[i]);
        }
        System.out.println(movie1.getRating());

        System.out.println(movie1.getReleaseDate());

        System.out.println(movie1.isIs3D());
        System.out.println(movie1.isIs4D());

        JOptionPane.showMessageDialog(null, "Ok", "Usuario creado correctamente", JOptionPane.INFORMATION_MESSAGE);

        mainFrame.cinemapp.addMovie(movie1);
        titulo.setText(null);

        genero.clear();
        jLabel6.setText(null);


        jTextField1.setText(null);


        lenguajes.clear();
        jLabel7.setText(null);


        fecha.setText(null);
        is3d.setSelected(false);
        is4d.setSelected(false);
        for (Movie listing : mainFrame.cinemapp.getListings()) {
            System.out.println(listing.getTitle());
        }

    }//GEN-LAST:event_crearActionPerformed

    private void lenguajesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lenguajesListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lenguajesListActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        

        lenguajes.add(lenguajesList.getSelectedItem());
       String[] array = (String[]) lenguajes.toArray(new String[lenguajes.size()]);
        movie1.setLanguages(array);
        String[] array3 = movie1.getLanguages();

        StringBuffer cadena = new StringBuffer();
        for (int x = 0; x < array3.length; x++) {
            cadena = cadena.append(array3[x] + " & ");
        }
        String cad = cadena.toString();
        jLabel7.setText(cad);
                String[] lenguaje = (String[]) lenguajes.toArray(new String[lenguajes.size()]);
        movie1.setLanguages(lenguaje);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tituloActionPerformed

    private void listGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listGenerosActionPerformed

    }//GEN-LAST:event_listGenerosActionPerformed

    private void ratingListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratingListActionPerformed
        String arr = (String) ratingList.getSelectedItem();
        movie1.setRating(arr);
    }//GEN-LAST:event_ratingListActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed

    }//GEN-LAST:event_CerrarActionPerformed

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed

    }//GEN-LAST:event_fechaActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed


        genero.add(listGeneros.getSelectedItem());

        String[] array = (String[]) genero.toArray(new String[genero.size()]);
        movie1.setGenre(array);
        StringBuffer cadena = new StringBuffer();
        for (int x = 0; x < array.length; x++) {
            cadena = cadena.append(array[x] + " & ");
        }
        String cad = cadena.toString();
        jLabel6.setText(cad);
        System.out.println(cadena);
                String[] gene = (String[]) genero.toArray(new String[genero.size()]);
        movie1.setGenre(gene);
    }//GEN-LAST:event_añadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton añadir;
    private javax.swing.JButton crear;
    private javax.swing.JTextField fecha;
    private javax.swing.JCheckBox is3d;
    private javax.swing.JCheckBox is4d;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> lenguajesList;
    private javax.swing.JComboBox<String> listGeneros;
    private javax.swing.JComboBox<String> ratingList;
    private javax.swing.JLabel title;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
