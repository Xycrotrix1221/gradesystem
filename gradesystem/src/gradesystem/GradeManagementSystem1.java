/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gradesystem;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
/**
 *
 * @author USER
 */
public class GradeManagementSystem1 extends javax.swing.JFrame {
  
    private String[] selectedRowData;
    private MENU menuFrame;
    /**
     * Creates new form GradeManagementSystem
     */
    
    
    private void refreshTableData() {
      
        displayCustomer();
    } 
    
     public void tableChanged(TableModelEvent e) {
        
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();

           
            DefaultTableModel model = (DefaultTableModel) TABLEINFO.getModel();
            Object updatedValue = model.getValueAt(row, column);

            
            UPDATE.updateField(column, updatedValue.toString());
        }
    }
    
    public GradeManagementSystem1() {
        
         setUndecorated(true);
         
        initComponents();
        
         displayCustomer(); 
         
         DefaultTableModel model = (DefaultTableModel) TABLEINFO.getModel();
         selectedRowData = new String[model.getColumnCount()];
          
       
    }
    
   public GradeManagementSystem1(MENU menuFrame) {
        this.menuFrame = menuFrame;
        // Initialize your frame here
    }
    
   private void loadTableData() {
    String query = "SELECT * FROM prelimgrades"; // SQL query to fetch all data from Grades table
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradesystem", "root", "");
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) TABLEINFO.getModel();
            model.setRowCount(0); // Clear any existing data in the table

            while (rs.next()) {
                Object[] row = {
                    rs.getString("NAME"),
                    rs.getString("CourseYear"),
                    rs.getDouble("Calculus"),
                    rs.getDouble("Physics"),
                    rs.getDouble("Chemistry"),
                    rs.getDouble("Fundamental"),
                    rs.getDouble("Database"),
                    rs.getDouble("PE"),
                    rs.getDouble("NSTP"),
                    rs.getDouble("FinalGrade")
                };
                model.addRow(row); // Add each row of data to the table
            }

        } catch (Exception e) {
            e.printStackTrace(); // Print the error for debugging
        }
}
   void displayCustomer() {
    try {
        String searchQuery = SearchF.getText();
        String query;
if (searchQuery.isEmpty()) {
    query = "SELECT NAME, CourseYear, Calculus, Physics, Chemistry, Fundamental, `DataBase`, PE, NSTP, FinalGrade FROM prelimgrades";
} else {
    query = "SELECT NAME, CourseYear, Calculus, Physics, Chemistry, Fundamental, `DataBase`, PE, NSTP, FinalGrade "
            + "FROM prelimgrades WHERE "
            + "NAME LIKE '%" + searchQuery + "%' OR "
            + "CourseYear LIKE '%" + searchQuery + "%' OR "
            + "Calculus LIKE '%" + searchQuery + "%' OR "
            + "Physics LIKE '%" + searchQuery + "%' OR "
            + "Chemistry LIKE '%" + searchQuery + "%' OR "
            + "Fundamental LIKE '%" + searchQuery + "%' OR "
            + "`DataBase` LIKE '%" + searchQuery + "%' OR "
            + "PE LIKE '%" + searchQuery + "%' OR "
            + "NSTP LIKE '%" + searchQuery + "%' OR "
            + "FinalGrade LIKE '%" + searchQuery + "%'";
}

       
        Connection con = Gradesystem.mycon();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        DefaultTableModel model = (DefaultTableModel) TABLEINFO.getModel();
        model.setRowCount(0);

        while (rs.next()) {
            String[] row = {
                rs.getString("NAME"),
                rs.getString("CourseYear"),
                rs.getString("Calculus"),
                rs.getString("Physics"),
                rs.getString("Chemistry"),
                rs.getString("Fundamental"),
                rs.getString("DataBase"),
                rs.getString("PE"),
                rs.getString("NSTP"),
                rs.getString("FinalGrade")
            };
            model.addRow(row);
        }

        
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Search failed. Please check the connection and query.");
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

        jLabel2 = new javax.swing.JLabel();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        minimize = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLEINFO = new javax.swing.JTable();
        SAVEBT = new javax.swing.JButton();
        UPDATEBT = new javax.swing.JButton();
        DELETEBT = new javax.swing.JButton();
        REFRESH = new javax.swing.JButton();
        SearchF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        MENU = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("x");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 10, -1));

        jToggleButton5.setBackground(new java.awt.Color(204, 0, 0));
        jToggleButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 30, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 20, 20));

        minimize.setBackground(new java.awt.Color(0, 153, 0));
        minimize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        getContentPane().add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 30, 30));

        TABLEINFO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Course & Year", "CALCULUS", "PHYSICS", "CHEMISTRY", "FUNDAMENTAL", "DATABASE", "PE", "NSTP", "FinalGrade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLEINFO.setToolTipText("");
        TABLEINFO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEINFOMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLEINFO);
        if (TABLEINFO.getColumnModel().getColumnCount() > 0) {
            TABLEINFO.getColumnModel().getColumn(0).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(1).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(2).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(3).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(4).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(5).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(6).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(7).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(8).setResizable(false);
            TABLEINFO.getColumnModel().getColumn(9).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 1240, 370));

        SAVEBT.setBackground(new java.awt.Color(51, 255, 0));
        SAVEBT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SAVEBT.setForeground(new java.awt.Color(255, 255, 255));
        SAVEBT.setText("ADD");
        SAVEBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEBTActionPerformed(evt);
            }
        });
        getContentPane().add(SAVEBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, -1, -1));

        UPDATEBT.setBackground(new java.awt.Color(51, 153, 255));
        UPDATEBT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        UPDATEBT.setForeground(new java.awt.Color(255, 255, 255));
        UPDATEBT.setText("UPDATE");
        UPDATEBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UPDATEBTActionPerformed(evt);
            }
        });
        getContentPane().add(UPDATEBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, -1, -1));

        DELETEBT.setBackground(new java.awt.Color(255, 0, 0));
        DELETEBT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        DELETEBT.setForeground(new java.awt.Color(255, 255, 255));
        DELETEBT.setText("DELETE");
        DELETEBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEBTActionPerformed(evt);
            }
        });
        getContentPane().add(DELETEBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, -1, -1));

        REFRESH.setBackground(new java.awt.Color(0, 204, 0));
        REFRESH.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        REFRESH.setForeground(new java.awt.Color(255, 255, 255));
        REFRESH.setText("REFRESH");
        REFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REFRESHActionPerformed(evt);
            }
        });
        getContentPane().add(REFRESH, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, -1, -1));

        SearchF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SearchF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFActionPerformed(evt);
            }
        });
        SearchF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFKeyReleased(evt);
            }
        });
        getContentPane().add(SearchF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 400, 30));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setText("SEARCH");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel4.setText("PRELIM GRADES");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel5.setText("≡");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        MENU.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        MENU.setSelected(true);
        MENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MENUActionPerformed(evt);
            }
        });
        getContentPane().add(MENU, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gradesystem/abstract-geometric-blue-and-white-color-background-illustration-vector.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
       int choice = JOptionPane.showConfirmDialog(rootPane, 
                        "Are you sure you want to exit?", 
                        "Confirm Exit", JOptionPane.YES_NO_OPTION);
                
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
         
                }
     
        
    }//GEN-LAST:event_jToggleButton5ActionPerformed
    
    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
       this.setState(JFrame.ICONIFIED);
        // Now you can hide the menuButton from the MENU frame
        if (menuFrame != null && menuFrame.getMenuButton() != null) {
            menuFrame.getMenuButton().setVisible(false); // Hide the MENU button
        }
    }//GEN-LAST:event_minimizeActionPerformed
   
    private void TABLEINFOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEINFOMouseClicked
    int selectedRow = TABLEINFO.getSelectedRow(); // Get the selected row

    if (selectedRow != -1) {
        for (int col = 0; col < TABLEINFO.getColumnCount(); col++) {
            Object cellValue = TABLEINFO.getValueAt(selectedRow, col);
            if (cellValue != null) {
                selectedRowData[col] = cellValue.toString();
            } else {
                selectedRowData[col] = ""; // Replace null with an empty string
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row from the table.");
    }
    }//GEN-LAST:event_TABLEINFOMouseClicked
    private ADD1 addWindow;
    private void SAVEBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEBTActionPerformed
        java.awt.EventQueue.invokeLater(() -> {

            if (addWindow == null || !addWindow.isVisible()) {
                addWindow = new ADD1();
                addWindow.setAlwaysOnTop(true);
                addWindow.setVisible(true);
            } else {

                addWindow.toFront();
            }
        });
    }//GEN-LAST:event_SAVEBTActionPerformed
    private UPDATE1 updateWindow;
    private void UPDATEBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UPDATEBTActionPerformed
    if (selectedRowData != null && selectedRowData.length > 0) {
        // Retrieve values from the stored selected row data
        String studentName = selectedRowData[0];
        String courseYear = selectedRowData[1];
        String calculus = selectedRowData[2];
        String physics = selectedRowData[3];
        String chemistry = selectedRowData[4];
        String fundamental = selectedRowData[5];
        String database = selectedRowData[6];
        String peGrade = selectedRowData[7];
        String nstpGrade = selectedRowData[8];

        // Check if the update window is already open
        if (updateWindow == null || !updateWindow.isVisible()) {
            updateWindow = new UPDATE1(studentName, courseYear, calculus, physics, chemistry, fundamental, database, peGrade, nstpGrade);
            updateWindow.setAlwaysOnTop(true);
            updateWindow.setVisible(true);
        } else {
            // Bring the existing window to the front
            updateWindow.setState(JFrame.NORMAL); // Restore if minimized
            updateWindow.toFront(); // Bring to front
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row from the table.");
    }
    }//GEN-LAST:event_UPDATEBTActionPerformed

    private void DELETEBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEBTActionPerformed
     int rowIndex = TABLEINFO.getSelectedRow(); 

    if (rowIndex != -1) { 
        String nameToDelete = TABLEINFO.getValueAt(rowIndex, 0).toString(); 

        // Show confirmation dialog
        int confirm = JOptionPane.showConfirmDialog(
            this, 
            "Do you really want to delete the record for " + nameToDelete + "?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION
        );

        // Proceed only if the user confirms
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Connection con = Gradesystem.mycon(); 
                String query = "DELETE FROM prelimgrades WHERE NAME = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nameToDelete); 
                
                

                int rowsAffected = ps.executeUpdate(); 

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Record deleted successfully.");
                    displayCustomer(); // Refresh the table
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No record found with the name " + nameToDelete);
                } 

                ps.close(); // Close prepared statement
                con.close(); // Close connection
            } catch (Exception e) {
                e.printStackTrace(); // Print any exception for debugging
                JOptionPane.showMessageDialog(rootPane, "Error deleting record. Please try again.");
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row from the table.");
    } 

    }//GEN-LAST:event_DELETEBTActionPerformed

    private void REFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REFRESHActionPerformed
      loadTableData();

    }//GEN-LAST:event_REFRESHActionPerformed

    private void SearchFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFActionPerformed

    private void SearchFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFKeyReleased

        displayCustomer();
    }//GEN-LAST:event_SearchFKeyReleased
    private MENU menuWindow;
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if (menuWindow == null || !menuWindow.isVisible()) {
            menuWindow = new MENU();  // Create a new MENU instance
            menuWindow.setAlwaysOnTop(true); // Keep the window on top
            menuWindow.setVisible(true); // Make it visible
        } else {
            menuWindow.toFront(); // Bring the existing window to the front
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void MENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MENUActionPerformed
        if (menuWindow == null || !menuWindow.isVisible()) {
            menuWindow = new MENU();  // Create a new MENU instance
            menuWindow.setAlwaysOnTop(true); // Keep the window on top
            menuWindow.setVisible(true); // Make it visible
        } else {
            menuWindow.toFront(); // Bring the existing window to the front
        }
    }//GEN-LAST:event_MENUActionPerformed

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
            java.util.logging.Logger.getLogger(GradeManagementSystem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GradeManagementSystem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GradeManagementSystem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GradeManagementSystem1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GradeManagementSystem1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETEBT;
    private javax.swing.JToggleButton MENU;
    private javax.swing.JButton REFRESH;
    private javax.swing.JButton SAVEBT;
    private javax.swing.JTextField SearchF;
    private javax.swing.JTable TABLEINFO;
    private javax.swing.JButton UPDATEBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton minimize;
    // End of variables declaration//GEN-END:variables
}
