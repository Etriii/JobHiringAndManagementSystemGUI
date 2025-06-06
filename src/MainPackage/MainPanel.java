package MainPackage;

import Classes.Functions;
import Classes.mainPStatement;
import Classes.setAllConnections;
import java.awt.Image;

import javax.swing.ImageIcon;

public class MainPanel extends javax.swing.JFrame {
    
    public MainPanel() {
        
        setAllConnections.setAllConnection();
        
        initComponents();
        setImageIcon();
    }
    
    private void setImageIcon() {
        ImageIcon ic = new ImageIcon("src\\MainPackage\\profile.jpg");
        Image img = ic.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIc = new ImageIcon(img);
        
        jLabelBackgroundImage.setIcon(Functions.setIconImage("src\\icons\\rec.png", jLabelBackgroundImage.getWidth(), jLabelBackgroundImage.getHeight()));
        jLabelBackgroundImage.setText("");
        
        logo.setIcon(newIc);
        logo.setText("");
        
        this.setIconImage(img);
        this.setTitle("Job Hiring And Management System");
        this.setIconImage(new ImageIcon("src\\icons\\yow.png").getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSignIn = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jShowPassword = new javax.swing.JCheckBox();
        jNewToJobSeekerQuestion = new javax.swing.JLabel();
        jCreateAnAccount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSignInAs = new javax.swing.JComboBox<>();
        jLabelForUsername = new javax.swing.JLabel();
        jLabelForPassword = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelBackgroundImage = new javax.swing.JLabel();

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(java.awt.SystemColor.text);
        jButton4.setText("LOG IN");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setForeground(java.awt.SystemColor.text);
        jButton5.setText("LOG IN");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setForeground(new java.awt.Color(0, 102, 102));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        title.setForeground(java.awt.SystemColor.window);
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Job Hiring And Management System");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Username or email address");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 167, -1, 21));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 234, -1, -1));

        jButtonSignIn.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSignIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonSignIn.setForeground(java.awt.SystemColor.text);
        jButtonSignIn.setText("Sign In");
        jButtonSignIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButtonSignIn.setBorderPainted(false);
        jButtonSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignInActionPerformed(evt);
            }
        });
        jButtonSignIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonSignInKeyPressed(evt);
            }
        });
        jPanel1.add(jButtonSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 338, 120, 30));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setText("LOGO");
        logo.setPreferredSize(new java.awt.Dimension(28, 28));
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 30, 80, 73));

        jLabel3.setBackground(new java.awt.Color(0, 103, 103));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 103, 103));
        jLabel3.setText("SIGN IN TO JOB SEEKER");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 121, -1, 15));

        jTextFieldUserName.setSelectionColor(new java.awt.Color(0, 102, 102));
        jTextFieldUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUserNameFocusGained(evt);
            }
        });
        jTextFieldUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserNameActionPerformed(evt);
            }
        });
        jTextFieldUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUserNameKeyPressed(evt);
            }
        });
        jPanel1.add(jTextFieldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 194, 299, 27));

        jPassword.setSelectionColor(new java.awt.Color(0, 102, 102));
        jPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFocusGained(evt);
            }
        });
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 255, 299, 28));

        jShowPassword.setText("Show password");
        jShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 302, -1, -1));

        jNewToJobSeekerQuestion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jNewToJobSeekerQuestion.setText("New to Job Seeker?");
        jPanel1.add(jNewToJobSeekerQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 383, -1, -1));

        jCreateAnAccount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCreateAnAccount.setForeground(new java.awt.Color(0, 103, 103));
        jCreateAnAccount.setText("Create an account");
        jCreateAnAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCreateAnAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreateAnAccountMouseClicked(evt);
            }
        });
        jPanel1.add(jCreateAnAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 381, 120, -1));

        jLabel4.setText("Sign in as");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 306, -1, -1));

        jComboBoxSignInAs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Job Hunter", "Job Recruiter", "Admin" }));
        jComboBoxSignInAs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxSignInAs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBoxSignInAsFocusGained(evt);
            }
        });
        jComboBoxSignInAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSignInAsActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxSignInAs, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 338, 167, 30));

        jLabelForUsername.setForeground(new java.awt.Color(204, 0, 0));
        jLabelForUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelForUsername.setText(" ");
        jPanel1.add(jLabelForUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 169, 136, -1));

        jLabelForPassword.setForeground(new java.awt.Color(204, 0, 0));
        jLabelForPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelForPassword.setText(" ");
        jPanel1.add(jLabelForPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 233, -1, -1));

        jLabel5.setText("+");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 15, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 331, 407));

        jLabelBackgroundImage.setText("                                            BACKGROUND IMAGE");
        jPanel3.add(jLabelBackgroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 880, 430));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, java.awt.BorderLayout.LINE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserNameActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowPasswordActionPerformed
        if (jShowPassword.isSelected()) {
            jPassword.setEchoChar((char) 0);
        } else {
            jPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_jShowPasswordActionPerformed

    private void jCreateAnAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreateAnAccountMouseClicked
        CreateAnAccount cA = new CreateAnAccount();
        cA.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jCreateAnAccountMouseClicked

    private void jComboBoxSignInAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSignInAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSignInAsActionPerformed

    private void jTextFieldUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUserNameFocusGained
        if (jLabelForUsername.getText().equals("Username field is empty")) {
            jLabelForUsername.setText("");
        }
    }//GEN-LAST:event_jTextFieldUserNameFocusGained

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusGained
        if (jLabelForPassword.getText().equals("Password field is empty")) {
            jLabelForPassword.setText("");
        }
    }//GEN-LAST:event_jPasswordFocusGained

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonSignIn.doClick();
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    private void jTextFieldUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUserNameKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonSignIn.doClick();
        }
    }//GEN-LAST:event_jTextFieldUserNameKeyPressed

    private void jComboBoxSignInAsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxSignInAsFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSignInAsFocusGained

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
//        AccountHolders.addHunter(new AccountForHunter("Alex", "13"));
//        AccountHolders.addRecruiter(new AccountForRecruiter("Alex2", "13"));
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButtonSignInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonSignInKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSignInKeyPressed

    private void jButtonSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignInActionPerformed
        
        String password = String.valueOf(jPassword.getPassword());
        int comboBoxIndexSelected = jComboBoxSignInAs.getSelectedIndex();
        
        if (jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && password.replaceAll("\\s+", "").equals("")) {
            jLabelForUsername.setText("Username field is empty");
            jLabelForPassword.setText("Password field is empty");
        } else if (jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && !password.replaceAll("\\s+", "").equals("")) {
            jLabelForUsername.setText("Username field is empty");
        } else if (!jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && password.replaceAll("\\s+", "").equals("")) {
            jLabelForPassword.setText("Password field is empty");
        } else {
            
            if (jComboBoxSignInAs.getSelectedIndex() == 0) {
                mainPStatement.getIDofHunter(jTextFieldUserName.getText(), password);
                this.dispose();
            } else if (jComboBoxSignInAs.getSelectedIndex() == 1) {
                mainPStatement.getIDofRecruiter(jTextFieldUserName.getText(), password);
                this.dispose();
            } else {
                mainPStatement.getAdmin(jTextFieldUserName.getText(), password);
                this.dispose();
            }

//            int index = AccountHolders.verifyAccountAndReturnItsIndex(jComboBoxSignInAs.getSelectedIndex(), jTextFieldUserName.getText(), password);
//            if (index == -1) {
//                JOptionPane.showMessageDialog(this, "Username or Passowrd are incorrect");
//            } else {
//                if (comboBoxIndexSelected == 0) {
//                    JobHuntersPortal hp = new JobHuntersPortal(index);
//                    hp.checkFirstTime(index);
//                    this.dispose();
//                } else if (comboBoxIndexSelected == 1) {
//                    JobRecruiterPortal aa = new JobRecruiterPortal(index);
//                    aa.checkFirstTime(index);
//                    this.dispose();
//                } else {
//                    AdministratorPortal admin = new AdministratorPortal();
//                    admin.setVisible(true);
//                    this.dispose();
//                }
//
//            }
        }
    }//GEN-LAST:event_jButtonSignInActionPerformed

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
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonSignIn;
    private javax.swing.JComboBox<String> jComboBoxSignInAs;
    private javax.swing.JLabel jCreateAnAccount;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelBackgroundImage;
    private javax.swing.JLabel jLabelForPassword;
    private javax.swing.JLabel jLabelForUsername;
    private javax.swing.JLabel jNewToJobSeekerQuestion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JCheckBox jShowPassword;
    private javax.swing.JTextField jTextFieldUserName;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
