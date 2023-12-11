/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.neu.csye6200.view;

import edu.neu.csye6200.controller.TheatreController;
import edu.neu.csye6200.model.Movie;
import edu.neu.csye6200.model.Theatre;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author yashl
 */
public class MovieDetailScreen extends javax.swing.JFrame {

    /**
     * Creates new form MovieDetailScreen
     */
    private Movie movie;
    
    public MovieDetailScreen() {
        initComponents();
        setDetailsOnScreen();
    }
    
    public void setDetailsOnScreen() {
                //Getting list of Theatre
        TheatreController theatreList = new TheatreController();
        List<Theatre> theatres = theatreList.getAllTheatres();
        String[] listOfTheatres = new String[theatres.size()];
      
        for(int i = 0; i < listOfTheatres.length; i++) {
            listOfTheatres[i] = theatres.get(i).getName();
        }
        theatreDropdown.setModel(new DefaultComboBoxModel<>(listOfTheatres));
        theatreDropdown.setSelectedIndex(0);
        movieDetailsPanel.add(theatreDropdown); // Add theatreDropdown to the movieDetailsPanel
        
        
        //Setting Showtimedropdown to default times
        String[] showtimes = {"- Select -"};
        showTimeDropdown.setModel(new DefaultComboBoxModel<>(showtimes));
        showTimeDropdown.setSelectedIndex(0);
        movieDetailsPanel.add(showTimeDropdown); // Add showTimeDropdown to the movieDetailsPanel
    }
    
    public void leftSidePanel(){
        String moviePosterPath = "/properties/images/" + this.movie.getTitle()+"_big.jpg";
        System.out.println(moviePosterPath);
        //moviePosterLabel.setIcon(new javax.swing.ImageIcon(moviePosterPath)); // 
        moviePosterLabel.setPreferredSize(new java.awt.Dimension(226, 260));
        add(moviePosterLabel);
        jPanel2.add(moviePosterLabel);
        
        movieName.setText(this.movie.getTitle());
        int duration = this.movie.getDuration();
        movieDuration.setText(Integer.toString(duration));
        movieGenre.setText(this.movie.getGenre());
        pack();
        
    }

    MovieDetailScreen(Movie selectedMovie) {
        this.movie = selectedMovie;
        initComponents();
        setDetailsOnScreen();
        leftSidePanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        movieDetailsPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        moviePosterLabel = new javax.swing.JLabel();
        movieName = new javax.swing.JLabel();
        movieGenre = new javax.swing.JLabel();
        movieReview = new javax.swing.JLabel();
        movieDuration = new javax.swing.JLabel();
        showTimeDropdown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        theatreDropdown = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        movieDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(7, 59, 76));

        jPanel3.setPreferredSize(new java.awt.Dimension(220, 300));

        moviePosterLabel.setText("jLabel4");
        moviePosterLabel.setPreferredSize(new java.awt.Dimension(230, 300));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(moviePosterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(moviePosterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        movieName.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        movieName.setForeground(new java.awt.Color(255, 255, 255));
        movieName.setText("Default Movie Name");

        movieGenre.setBackground(new java.awt.Color(51, 51, 51));
        movieGenre.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        movieGenre.setForeground(new java.awt.Color(204, 204, 204));
        movieGenre.setText("Drama");

        movieReview.setBackground(new java.awt.Color(51, 51, 51));
        movieReview.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        movieReview.setForeground(new java.awt.Color(204, 204, 204));
        movieReview.setText("4.5 out of 5");

        movieDuration.setBackground(new java.awt.Color(51, 51, 51));
        movieDuration.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        movieDuration.setForeground(new java.awt.Color(204, 204, 204));
        movieDuration.setText("150 mins");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(movieReview, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(movieName))
                    .addComponent(movieDuration)
                    .addComponent(movieGenre))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(movieName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(movieReview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(movieDuration)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(movieGenre)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        showTimeDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        showTimeDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTimeDropdownActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Show Times");

        theatreDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        theatreDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theatreDropdownActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("Theatre");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Select Seats");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book Tickets");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout movieDetailsPanelLayout = new javax.swing.GroupLayout(movieDetailsPanel);
        movieDetailsPanel.setLayout(movieDetailsPanelLayout);
        movieDetailsPanelLayout.setHorizontalGroup(
            movieDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieDetailsPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addGroup(movieDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showTimeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(movieDetailsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(theatreDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        movieDetailsPanelLayout.setVerticalGroup(
            movieDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(movieDetailsPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(theatreDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showTimeDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(movieDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(movieDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(movieDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showTimeDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTimeDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showTimeDropdownActionPerformed

    private void theatreDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theatreDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theatreDropdownActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(MovieDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieDetailScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieDetailScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel movieDetailsPanel;
    private javax.swing.JLabel movieDuration;
    private javax.swing.JLabel movieGenre;
    private javax.swing.JLabel movieName;
    private javax.swing.JLabel moviePosterLabel;
    private javax.swing.JLabel movieReview;
    private javax.swing.JComboBox<String> showTimeDropdown;
    private javax.swing.JComboBox<String> theatreDropdown;
    // End of variables declaration//GEN-END:variables
}
