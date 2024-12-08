/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gradesystem;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author USER
 */
public class LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN
     */
    public LOGIN() {
        initComponents();
         setLocationRelativeTo(null); 
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
        jLabel3 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        minimize1 = new javax.swing.JToggleButton();
        user = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        passtext = new javax.swing.JPasswordField();
        ps = new javax.swing.JLabel();
        showpass = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        Login = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("x");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 20, 20));

        jToggleButton1.setBackground(new java.awt.Color(204, 0, 0));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 30, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("-");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 10, 20));

        minimize1.setBackground(new java.awt.Color(0, 153, 0));
        minimize1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        minimize1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimize1ActionPerformed(evt);
            }
        });
        jPanel1.add(minimize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 30));

        user.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("USERNAME:");
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });
        jPanel1.add(usertext, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 321, 26));

        passtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtextActionPerformed(evt);
            }
        });
        jPanel1.add(passtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 320, 26));

        ps.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        ps.setForeground(new java.awt.Color(255, 255, 255));
        ps.setText("PASSWORD:");
        jPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        showpass.setForeground(new java.awt.Color(255, 255, 255));
        showpass.setText("Show Password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Management", "Teacher", "Student" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 140, -1));

        Login.setBackground(new java.awt.Color(0, 204, 0));
        Login.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        Login.setText("LOGIN");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 0, 0));
        cancel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

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

    private void minimize1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimize1ActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimize1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertextActionPerformed

    private void passtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtextActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if(showpass.isSelected()) {
            passtext.setEchoChar((char)0);
        }else{
            passtext.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        String username = usertext.getText();  // Username field input
        String password = new String(passtext.getPassword());  // Password field input
        String selectedRole = jComboBox1.getSelectedItem().toString();  // Selected role from JComboBox

        try {
            // Check if username or password is empty
            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Please type username and password");
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Please type username");
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Please type password");
            } else {
                // Connection setup
                Connection con = Gradesystem.mycon();
                PreparedStatement pst = null;
                ResultSet res = null;
                boolean loginSuccess = false;

                // Handle Student Login
                if ("Student".equals(selectedRole)) {
                    String sql = "SELECT * FROM grades WHERE Name=? AND ID=?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, username);
                    pst.setString(2, password);  // Assuming the ID is entered as the password
                    res = pst.executeQuery();

                    // Check if student exists in the grades table
                    if (res.next()) {
                        loginSuccess = true;
                        JOptionPane.showMessageDialog(rootPane, "Login Successful as Student");
                        // Redirect to Student dashboard
                        new StudentDashboard().setVisible(true);  // Change to the actual Student dashboard
                        setVisible(false);
                    }
                }
                // Handle Teacher or Management Login
                else if ("Teacher".equals(selectedRole) || "Management".equals(selectedRole)) {
                    String sql = "SELECT * FROM users WHERE Username=? AND PasswordHash=?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1, username);
                    pst.setString(2, password);  // Ensure password is hashed before comparison
                    res = pst.executeQuery();

                    // Check if user exists in the users table
                    if (res.next()) {
                        loginSuccess = true;
                        JOptionPane.showMessageDialog(rootPane, "Login Successful as " + selectedRole);
                        // Redirect to GradeManagementSystem for Teacher or Management
                        new GradeManagementSystem().setVisible(true);  // This is for Teacher or Management
                        setVisible(false);
                    }
                }

                // Handle failed login attempt
                if (!loginSuccess) {
                    JOptionPane.showMessageDialog(rootPane, "Invalid username, password, or role.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        usertext.setText("");
        passtext.setText("");
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton minimize1;
    private javax.swing.JPasswordField passtext;
    private javax.swing.JLabel ps;
    private javax.swing.JCheckBox showpass;
    private javax.swing.JLabel user;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables
}
