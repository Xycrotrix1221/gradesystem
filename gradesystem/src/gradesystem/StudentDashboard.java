/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gradesystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author USER
 */
public class StudentDashboard extends javax.swing.JFrame {
   
    /**
     * Creates new form StudentDashboard
     */
    public StudentDashboard() {
        initComponents();
    }
   private void fetchAndDisplayData() {
    String enteredName = name.getText().trim();
    String enteredID = id.getText().trim();

    // Validate input
    if (enteredName.isEmpty() || enteredID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both Name and ID.");
        return;
    }

    // Ensure ID is numeric and pad it to 8 digits
    if (!enteredID.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "ID must be numeric.");
        return;
    }
    
    // Pad ID to 8 digits if it's less than 8 digits long
    String paddedID = String.format("%08d", Integer.parseInt(enteredID));

    // SQL connection and queries
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradesystem", "root", "")) {

        // Query for Grades
        String gradesQuery = "SELECT * FROM Grades WHERE Name = ? AND LPAD(ID, 8, '0') = ?";
        try (PreparedStatement gradesStmt = conn.prepareStatement(gradesQuery)) {
            gradesStmt.setString(1, enteredName);
            gradesStmt.setString(2, paddedID);  // Use the padded ID
            try (ResultSet gradesResult = gradesStmt.executeQuery()) {
                populateTable(TABLEINFO1, gradesResult);
            }
        }

        // Query for PrelimGrades
        String prelimQuery = "SELECT * FROM PrelimGrades WHERE Name = ? AND LPAD(ID, 8, '0') = ?";
        try (PreparedStatement prelimStmt = conn.prepareStatement(prelimQuery)) {
            prelimStmt.setString(1, enteredName);
            prelimStmt.setString(2, paddedID);  // Use the padded ID
            try (ResultSet prelimResult = prelimStmt.executeQuery()) {
                populateTable(TABLEINFO2, prelimResult);
            }
        }

        // Query for MidtermGrades
        String midtermQuery = "SELECT * FROM MidtermGrades WHERE Name = ? AND LPAD(ID, 8, '0') = ?";
        try (PreparedStatement midtermStmt = conn.prepareStatement(midtermQuery)) {
            midtermStmt.setString(1, enteredName);
            midtermStmt.setString(2, paddedID);  // Use the padded ID
            try (ResultSet midtermResult = midtermStmt.executeQuery()) {
                populateTable(TABLEINFO3, midtermResult);
            }
        }

        // Query for FinalsGrades
        String finalsQuery = "SELECT * FROM FinalsGrades WHERE Name = ? AND LPAD(ID, 8, '0') = ?";
        try (PreparedStatement finalsStmt = conn.prepareStatement(finalsQuery)) {
            finalsStmt.setString(1, enteredName);
            finalsStmt.setString(2, paddedID);  // Use the padded ID
            try (ResultSet finalsResult = finalsStmt.executeQuery()) {
                populateTable(TABLEINFO4, finalsResult);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error retrieving data: " + e.getMessage());
    }
}
   private void populateTable(javax.swing.JTable table, ResultSet resultSet) {
    try {
        // Get metadata from the result set
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Create a new DefaultTableModel to set to the JTable
        DefaultTableModel model = new DefaultTableModel();

        // Add columns based on the metadata
        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));  // Add column names
        }

        // Add rows based on the result set
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = resultSet.getObject(i);  // Populate row with data
            }
            model.addRow(row);  // Add the row to the model
        }

        // Set the model to the table
        table.setModel(model);

    } catch (SQLException e) {
        // Catch any SQLException and show a message
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error populating table: " + e.getMessage());
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
        jLabel7 = new javax.swing.JLabel();
        minimize = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jToggleButton5 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLEINFO4 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABLEINFO1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLEINFO2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABLEINFO3 = new javax.swing.JTable();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SUBMIT = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 740));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("-");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 20, 20));

        minimize.setBackground(new java.awt.Color(0, 153, 0));
        minimize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        jPanel1.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 30, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("x");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 10, -1));

        jToggleButton5.setBackground(new java.awt.Color(204, 0, 0));
        jToggleButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 30, 30));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel4.setText("STUDENT PORTAL");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        TABLEINFO4.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLEINFO4.setToolTipText("");
        TABLEINFO4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEINFO4MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLEINFO4);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 1240, 60));

        TABLEINFO1.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLEINFO1.setToolTipText("");
        TABLEINFO1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEINFO1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TABLEINFO1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 1240, 60));

        TABLEINFO2.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLEINFO2.setToolTipText("");
        TABLEINFO2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEINFO2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TABLEINFO2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 1240, 60));

        TABLEINFO3.setModel(new javax.swing.table.DefaultTableModel(
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
        TABLEINFO3.setToolTipText("");
        TABLEINFO3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEINFO3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TABLEINFO3);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 1240, 60));

        name.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 260, 40));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setText("ID:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, -1, -1));

        id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 260, 40));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel5.setText("FINAL GRADES");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, 30));

        SUBMIT.setBackground(new java.awt.Color(0, 204, 0));
        SUBMIT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        SUBMIT.setForeground(new java.awt.Color(255, 255, 255));
        SUBMIT.setText("SUBMIT");
        SUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUBMITActionPerformed(evt);
            }
        });
        jPanel1.add(SUBMIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setText("NAME:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel8.setText("FINAL GRADES IN WHOLE SEMESTER");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel9.setText("PRELIM GRADES");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel10.setText("MIDTERM GRADES");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gradesystem/abstract-geometric-blue-and-white-color-background-illustration-vector.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeActionPerformed
        this.setState(JFrame.ICONIFIED);
        // Now you can hide the menuButton from the MENU frame
        
    }//GEN-LAST:event_minimizeActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        int choice = JOptionPane.showConfirmDialog(rootPane,
            "Are you sure you want to exit?",
            "Confirm Exit", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);

        }

    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void TABLEINFO4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEINFO4MouseClicked
        
    }//GEN-LAST:event_TABLEINFO4MouseClicked

    private void TABLEINFO1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEINFO1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLEINFO1MouseClicked

    private void TABLEINFO2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEINFO2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLEINFO2MouseClicked

    private void TABLEINFO3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEINFO3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TABLEINFO3MouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        fetchAndDisplayData();
    }//GEN-LAST:event_idActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
       fetchAndDisplayData();
    }//GEN-LAST:event_nameActionPerformed

    private void SUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBMITActionPerformed
       fetchAndDisplayData();
    }//GEN-LAST:event_SUBMITActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SUBMIT;
    private javax.swing.JTable TABLEINFO1;
    private javax.swing.JTable TABLEINFO2;
    private javax.swing.JTable TABLEINFO3;
    private javax.swing.JTable TABLEINFO4;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton minimize;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
