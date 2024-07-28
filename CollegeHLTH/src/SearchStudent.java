/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author prasa
 */
import java.sql.*;

import java.util.Arrays;

import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SearchStudent extends javax.swing.JFrame {
private Map<Integer, Map<Integer, Object>> changedValues = new HashMap<>();
    /**
     * Creates new form SearchStudent
     */
    public SearchStudent() {
        initComponents();
    }
    // Method to retrieve original value from database


    private Connection establishConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/clghealthdpt";
    String username = "root";
    String password = "14ec8d7b";
    return DriverManager.getConnection(url, username, password);
}
    
    
private void performSearch(String searchTerm) {
    String url = "jdbc:mysql://localhost:3306/clghealthdpt";
    String username = "root";
    String password = "14ec8d7b";
    
    // Define the SQL query to search for students and their health issues
    String query = "SELECT h.CaseNo,S.SNAME, s.USN, h.CaseType, h.Referral, h.ChiefComplaints, h.Intervention, h.Date,S.GENDER,S.CONTACT,S.AGE " +
                   "FROM students s " +
                   "JOIN health_issues h ON s.USN = h.USN " +
                   "WHERE s.SNAME LIKE ? OR s.USN LIKE ? OR h.DATE LIKE ? OR h.CaseType LIKE ?";
    
    try {
        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + searchTerm + "%");
        pstmt.setString(2, "%" + searchTerm + "%");
        pstmt.setString(3, "%" + searchTerm + "%");
        pstmt.setString(4, "%" + searchTerm + "%");
        
        System.out.println("Executing SQL query: " + pstmt.toString());
        
        ResultSet rs = pstmt.executeQuery();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CaseNo");
        model.addColumn("SNAME");
        model.addColumn("USN");
        model.addColumn("GENDER");
        model.addColumn("AGE");
        model.addColumn("CONTACT");
        model.addColumn("CaseType");
        model.addColumn("Referral");
        model.addColumn("ChiefComplaints");
        model.addColumn("Intervention");
        model.addColumn("Date");
        
        
      
        
        while (rs.next()) {
            // Print out each row retrieved for debugging
            System.out.println("Found student with health issue: " + rs.getString("USN"));
            
            model.addRow(new Object[] {
                rs.getString("CaseNo"),
                rs.getString("SNAME"),
                 rs.getString("USN"),
                rs.getString("GENDER"),
                rs.getString("AGE"),
                rs.getString("CONTACT"),
                rs.getString("CaseType"),
                rs.getString("Referral"),
                rs.getString("ChiefComplaints"),
                rs.getString("Intervention"),
                rs.getString("Date")
               
                
            });
        }
        
        jTable1.setModel(model);
        
        rs.close();
        pstmt.close();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SearchStudent");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("Search");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CaseNo", "USN", "CaseType", "Gender", "AGE", "GENDER", "CASETYPE", "REFFERAL", "CHIEFCOMPLAINTS", "INTERVENTION", "DATE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("CaseNo");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("USN");
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("CaseType");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Gender");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("AGE");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("GENDER");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("CASETYPE");
            jTable1.getColumnModel().getColumn(7).setHeaderValue("REFFERAL");
            jTable1.getColumnModel().getColumn(8).setHeaderValue("CHIEFCOMPLAINTS");
            jTable1.getColumnModel().getColumn(9).setHeaderValue("INTERVENTION");
            jTable1.getColumnModel().getColumn(10).setHeaderValue("DATE");
        }

        jButton2.setBackground(new java.awt.Color(102, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(638, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String searchTerm = jTextField1.getText().trim();
        
        // Call the performSearch method to search for students
        performSearch(searchTerm);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    Home homeFrame = new Home(); // Create an instance of Home
    homeFrame.setVisible(true); // Make the Home frame visible
    this.dispose(); // Close the current frame (SearchStudent frame)
                                      

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                                               
                                             
                                           
                                           
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        String caseNo = (String) model.getValueAt(selectedRow, 0);
        String usn = (String) model.getValueAt(selectedRow, 2);
        int count = getCaseCountForUSN(usn);
        
        String url = "jdbc:mysql://localhost:3306/clghealthdpt";
        String username = "root";
        String password = "14ec8d7b";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            conn.setAutoCommit(false); // Start a transaction
            
            if (count == 1) {
                // If only one case, delete from both tables
                String deleteStudentQuery = "DELETE FROM students WHERE USN = ?";
                String deleteHealthIssueQuery = "DELETE FROM health_issues WHERE CaseNo = ?";

                try (PreparedStatement pstmt1 = conn.prepareStatement(deleteStudentQuery);
                     PreparedStatement pstmt2 = conn.prepareStatement(deleteHealthIssueQuery)) {
                    
                    pstmt1.setString(1, usn);
                    pstmt1.executeUpdate();

                    pstmt2.setString(1, caseNo);
                    pstmt2.executeUpdate();

                    conn.commit(); // Commit transaction

                    model.removeRow(selectedRow);
                } catch (SQLException ex) {
                    conn.rollback(); // Rollback transaction if any error occurs
                    ex.printStackTrace();
                }
            } else {
                // If multiple cases, delete from health_issues table only
                String deleteHealthIssueQuery = "DELETE FROM health_issues WHERE CaseNo = ?";

                try (PreparedStatement pstmt = conn.prepareStatement(deleteHealthIssueQuery)) {
                    pstmt.setString(1, caseNo);
                    pstmt.executeUpdate();

                    conn.commit(); // Commit transaction

                    model.removeRow(selectedRow);
                } catch (SQLException ex) {
                    conn.rollback(); // Rollback transaction if any error occurs
                    ex.printStackTrace();
                }
            }

            System.out.println("Record(s) deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } else {
        System.out.println("Please select a row to delete.");
    }
}

private int getCaseCountForUSN(String usn) {
    int count = 0;
    String url = "jdbc:mysql://localhost:3306/clghealthdpt";
    String username = "root";
    String password = "14ec8d7b";

    String query = "SELECT COUNT(*) AS count FROM health_issues WHERE USN = ?";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, usn);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt("count");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return count;




    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                                                                              
                                       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow != -1) {
        String caseNo = (String) model.getValueAt(selectedRow, 0);
        String usn = (String) model.getValueAt(selectedRow, 2);
        
        // Retrieve original values from the database
        String originalCaseType = getOriginalValueFromDatabase(usn, "CaseType");
        String originalReferral = getOriginalValueFromDatabase(usn, "Referral");
        String originalChiefComplaints = getOriginalValueFromDatabase(usn, "ChiefComplaints");
        String originalIntervention = getOriginalValueFromDatabase(usn, "Intervention");
        String originalDate = getOriginalValueFromDatabase(usn, "Date");
        
        // Get current values from jTable1
        String currentCaseType = (String) model.getValueAt(selectedRow, 6);
        String currentReferral = (String) model.getValueAt(selectedRow, 7);
        String currentChiefComplaints = (String) model.getValueAt(selectedRow, 8);
        String currentIntervention = (String) model.getValueAt(selectedRow, 9);
        String currentDate = (String) model.getValueAt(selectedRow, 10);
        
        // Check if any changes are made
        if (!currentCaseType.equals(originalCaseType) ||
            !currentReferral.equals(originalReferral) ||
            !currentChiefComplaints.equals(originalChiefComplaints) ||
            !currentIntervention.equals(originalIntervention) ||
            !currentDate.equals(originalDate)) {
            
            // Update the database with new values
            String url = "jdbc:mysql://localhost:3306/clghealthdpt";
            String username = "root";
            String password = "14ec8d7b";
            String updateQuery = "UPDATE health_issues " +
                                  "SET CaseType = ?, Referral = ?, ChiefComplaints = ?, Intervention = ?, Date = ? " +
                                  "WHERE CaseNo = ?";
            
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                
                pstmt.setString(1, currentCaseType);
                pstmt.setString(2, currentReferral);
                pstmt.setString(3, currentChiefComplaints);
                pstmt.setString(4, currentIntervention);
                pstmt.setString(5, currentDate);
                pstmt.setString(6, caseNo);
                
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Record updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to update record.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No changes found.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    }
}

// Helper method to retrieve original value from database
private String getOriginalValueFromDatabase(String usn, String columnName) {
    String value = null;
    String url = "jdbc:mysql://localhost:3306/clghealthdpt";
    String username = "root";
    String password = "14ec8d7b";
    String query = "SELECT " + columnName + " FROM health_issues WHERE USN = ?";
    
    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(query)) {
        
        pstmt.setString(1, usn);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            value = rs.getString(columnName);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return value;

    


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
       
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
            java.util.logging.Logger.getLogger(SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
