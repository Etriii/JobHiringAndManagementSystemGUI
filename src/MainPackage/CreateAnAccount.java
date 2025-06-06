package MainPackage;

import Classes.Functions;
import Classes.adminsQueries;
import Classes.mainPStatement;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CreateAnAccount extends javax.swing.JFrame {

    public CreateAnAccount() {
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setImageIcon();
    }

    public void setImageIcon() {
        
        ImageIcon ic = new ImageIcon("src\\profile.jpg");
        Image img = ic.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIC = new ImageIcon(img);
        logo.setIcon(newIC);

        jLabelMainImage.setIcon(Functions.setIconImage("src\\icons\\hun.png", jLabelMainImage.getWidth(), jLabelMainImage.getHeight()));
        jLabelMainImage.setText("");

    }

    public void verifyAccountCreation(String password, String confirmPassword) {

        if (jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && password.replaceAll("\\s+", "").equals("") && confirmPassword.replaceAll("\\s+", "").equals("")) {
            jLabelErrorUsername.setText("Username field is Empty");
            jLabelPasswordError.setText("Password field is Empty");
            jLabelErrorConfirmPassword.setText("Password field is Empty");
            
        } else if (!jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && password.replaceAll("\\s+", "").equals("") && confirmPassword.replaceAll("\\s+", "").equals("")) {

            if (jTextFieldUserName.getText().length() < 2) {
                jLabelErrorUsername.setText("Username is less than 8 in length");
            }

            jLabelPasswordError.setText("Password field is Empty");
            jLabelErrorConfirmPassword.setText("Password field is Empty");
            
        } else if (!jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && !password.replaceAll("\\s+", "").equals("") && confirmPassword.replaceAll("\\s+", "").equals("")) {

            if (jTextFieldUserName.getText().length() < 8) {
                jLabelErrorUsername.setText("Username is less than 8 in length");  
            }

            jLabelErrorConfirmPassword.setText("Password field is Empty");
        } else if (jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && !password.replaceAll("\\s+", "").equals("") && confirmPassword.replaceAll("\\s+", "").equals("")) {
            jLabelErrorUsername.setText("Username field is Empty");
            jLabelErrorConfirmPassword.setText("Password field is Empty");
        } else if (jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && !password.replaceAll("\\s+", "").equals("") && !confirmPassword.replaceAll("\\s+", "").equals("")) {
            jLabelErrorUsername.setText("Username field is Empty");
        } else if (jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && password.replaceAll("\\s+", "").equals("") && !confirmPassword.replaceAll("\\s+", "").equals("")) {
            jLabelErrorUsername.setText("Username field is Empty");
            jLabelPasswordError.setText("Password field is Empty");
        } else if (jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && !password.replaceAll("\\s+", "").equals("") && confirmPassword.replaceAll("\\s+", "").equals("")) {
            jLabelErrorUsername.setText("Username field is Empty");
            jLabelErrorConfirmPassword.setText("Password field is Empty");
        } else if (!jTextFieldUserName.getText().replaceAll("\\s+", "").equals("") && password.replaceAll("\\s+", "").equals("") && !confirmPassword.replaceAll("\\s+", "").equals("")) {

            if (jTextFieldUserName.getText().length() < 8) {
                jLabelErrorUsername.setText("Username is less than 8 in length");
            }

            jLabelPasswordError.setText("Password field is Empty");
        } else {

            if (jTextFieldUserName.getText().length() < 8 && password.length() < 8) {
                jLabelErrorUsername.setText("Username is less than 8 in length");
                jLabelPasswordError.setText("Password is less than 8 in length");
            } else if (jTextFieldUserName.getText().length() < 8 && password.length() >= 8) {
                jLabelErrorUsername.setText("Username is less than 8 in length");
                jLabelPasswordError.setText("");
            } else if (jTextFieldUserName.getText().length() >= 8 && password.length() < 8) {
                jLabelErrorUsername.setText("");
                jLabelPasswordError.setText("Password is less than 8 in length");
            } else {
                int selectedComboBox = jComboBoxSignInAs.getSelectedIndex();
                verifyAccountCreation(selectedComboBox, password, confirmPassword);
            }
            
        }
    }

    public void verifyAccountCreation(int selectedComboBox, String password, String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            jLabelErrorConfirmPassword.setText("Password doesn't match");
        } else {
            //
            boolean accountCreated = false;
            if (selectedComboBox == 0) {

//                if (AccountHolders.checkIfHunterUsernameExist(jTextFieldUserName.getText())) {
//                    JOptionPane.showMessageDialog(this, "Username already exist, please try another username.", "Job Hunter Creation Procecss", JOptionPane.WARNING_MESSAGE);
//                    jTextFieldUserName.requestFocus();
//                } else {
//                    AccountForHunter hunter = new AccountForHunter(jTextFieldUserName.getText(), password);
//                    AccountHolders.addHunter(hunter);
//                    JOptionPane.showMessageDialog(this, "Account Created Successfully!.", "Account Creation for Job Hunters", JOptionPane.INFORMATION_MESSAGE);
//                    accountCreated = true;
//                }
                if (accountCreated) {

                } else {
                    mainPStatement.addAccountForHunter(jTextFieldUserName.getText(), password);
                }

            } else {
//                if (AccountHolders.checkIfRecruiterUsernameExist(jTextFieldUserName.getText())) {
//                    JOptionPane.showMessageDialog(this, "Username already exist, please try another username.", "Job Recruiter Creation Procecss", JOptionPane.WARNING_MESSAGE);
//                    jTextFieldUserName.requestFocus();
//                } else {
//                    AccountForRecruiter recruiter = new AccountForRecruiter(jTextFieldUserName.getText(), password);
//                    AccountHolders.addRecruiter(recruiter);
//                    JOptionPane.showMessageDialog(this, "Account Created Successfully!.", "Account Creation for Job Recruiters", JOptionPane.INFORMATION_MESSAGE);
//                    accountCreated = true;
//                }

                if (accountCreated) {

                } else {
                    mainPStatement.addAccountForRecruiter(jTextFieldUserName.getText(), password);
                }
            }
            //

            if (accountCreated) {
                this.dispose();
                MainPanel mp = new MainPanel();
                mp.setVisible(true);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabelErrorConfirmPassword = new javax.swing.JLabel();
        jComboBoxSignInAs = new javax.swing.JComboBox<>();
        jLabelConfrimPassword = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelForUsername = new javax.swing.JLabel();
        jSignIn = new javax.swing.JLabel();
        jButtonCreateAnAccount = new javax.swing.JButton();
        jLabelForPassword = new javax.swing.JLabel();
        jLabelPasswordError = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        CreateAnAccountTitile = new javax.swing.JLabel();
        jLabelAlreadyHaveAnAccount = new javax.swing.JLabel();
        jPasswordConfirm = new javax.swing.JPasswordField();
        jShowPassword = new javax.swing.JCheckBox();
        jLabelErrorUsername = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMainImage = new javax.swing.JLabel();

        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("a");

        setTitle("Create Account");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 102, 102), null));
        jPanel1.setPreferredSize(new java.awt.Dimension(866, 482));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setText("LOGO");
        logo.setPreferredSize(new java.awt.Dimension(28, 28));

        jLabelErrorConfirmPassword.setForeground(new java.awt.Color(204, 0, 0));
        jLabelErrorConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelErrorConfirmPassword.setText(" ");

        jComboBoxSignInAs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Job Hunter", "Job Recruiter" }));
        jComboBoxSignInAs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxSignInAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSignInAsActionPerformed(evt);
            }
        });

        jLabelConfrimPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelConfrimPassword.setText("Confirm password");

        jLabel4.setText("Create account for");

        jLabelForUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelForUsername.setText("Username");

        jSignIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSignIn.setForeground(new java.awt.Color(0, 103, 103));
        jSignIn.setText("Sign in");
        jSignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSignInMouseClicked(evt);
            }
        });

        jButtonCreateAnAccount.setBackground(new java.awt.Color(0, 102, 102));
        jButtonCreateAnAccount.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCreateAnAccount.setForeground(java.awt.SystemColor.text);
        jButtonCreateAnAccount.setText("CREATE ACCOUNT");
        jButtonCreateAnAccount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jButtonCreateAnAccount.setBorderPainted(false);
        jButtonCreateAnAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCreateAnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateAnAccountActionPerformed(evt);
            }
        });

        jLabelForPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelForPassword.setText("Password");

        jLabelPasswordError.setForeground(new java.awt.Color(204, 0, 0));
        jLabelPasswordError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPasswordError.setText(" ");

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

        CreateAnAccountTitile.setBackground(new java.awt.Color(0, 103, 103));
        CreateAnAccountTitile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CreateAnAccountTitile.setForeground(new java.awt.Color(0, 103, 103));
        CreateAnAccountTitile.setText("CREATE AN ACCOUNT");

        jLabelAlreadyHaveAnAccount.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelAlreadyHaveAnAccount.setText("Already have an account?");

        jPasswordConfirm.setSelectionColor(new java.awt.Color(0, 102, 102));
        jPasswordConfirm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordConfirmFocusGained(evt);
            }
        });
        jPasswordConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordConfirmActionPerformed(evt);
            }
        });
        jPasswordConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordConfirmKeyPressed(evt);
            }
        });

        jShowPassword.setText("Show password");
        jShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowPasswordActionPerformed(evt);
            }
        });

        jLabelErrorUsername.setForeground(new java.awt.Color(204, 0, 0));
        jLabelErrorUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelErrorUsername.setToolTipText("");
        jLabelErrorUsername.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(CreateAnAccountTitile))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxSignInAs, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCreateAnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jShowPassword))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabelAlreadyHaveAnAccount)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabelForPassword)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabelConfrimPassword)
                            .addGap(18, 18, 18)
                            .addComponent(jLabelErrorConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabelForUsername)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelErrorUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldUserName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPasswordConfirm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateAnAccountTitile, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabelErrorUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelForPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPasswordError))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelErrorConfirmPassword)
                            .addComponent(jLabelConfrimPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jShowPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxSignInAs)
                            .addComponent(jButtonCreateAnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAlreadyHaveAnAccount)
                            .addComponent(jSignIn)))
                    .addComponent(jLabelForUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 10, 320, 450));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 23, 487, 37));

        jLabelMainImage.setBackground(new java.awt.Color(0, 153, 153));
        jLabelMainImage.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelMainImage.setForeground(new java.awt.Color(0, 102, 102));
        jLabelMainImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelMainImage.setText("   BACKGROUND IMAGE");
        jPanel1.add(jLabelMainImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 880, 480));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxSignInAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSignInAsActionPerformed
        if (jComboBoxSignInAs.getSelectedIndex() == 0) {
//            jLabel1.setText("JOB HUNTER");
            jLabelMainImage.setIcon(Functions.setIconImage("src\\icons\\hun.png", jLabelMainImage.getWidth(), jLabelMainImage.getHeight()));
            jLabelMainImage.setText("");
        }
        if (jComboBoxSignInAs.getSelectedIndex() == 1) {
//            jLabel1.setText("JOB RECRUITER");
            jLabelMainImage.setIcon(Functions.setIconImage("src\\icons\\rec.png", jLabelMainImage.getWidth(), jLabelMainImage.getHeight()));
            jLabelMainImage.setText("");
        }
    }//GEN-LAST:event_jComboBoxSignInAsActionPerformed

    private void jPasswordConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordConfirmActionPerformed

    private void jPasswordConfirmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordConfirmFocusGained
        if (jLabelErrorConfirmPassword.getText().equals("Password field is Empty") || jLabelErrorConfirmPassword.getText().equals("Passwrod doesn't match")) {
            jLabelErrorConfirmPassword.setText("");
        }
    }//GEN-LAST:event_jPasswordConfirmFocusGained

    private void jSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSignInMouseClicked
        MainPanel mainPanel = new MainPanel();
        mainPanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jSignInMouseClicked

    private void jShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowPasswordActionPerformed
        if (jShowPassword.isSelected()) {
            jPassword.setEchoChar((char) 0);
            jPasswordConfirm.setEchoChar((char) 0);
        } else {
            jPassword.setEchoChar('*');
            jPasswordConfirm.setEchoChar('*');
        }
    }//GEN-LAST:event_jShowPasswordActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusGained

        if (jLabelPasswordError.getText().equals("Password field is Empty")) {
            jLabelPasswordError.setText("");
        }
    }//GEN-LAST:event_jPasswordFocusGained

    private void jTextFieldUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUserNameActionPerformed

    private void jTextFieldUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUserNameFocusGained
        if (jLabelErrorUsername.getText().equals("Username field is empty") || jLabelErrorUsername.getText().equals("Username is less than 8 in length")) {
            jLabelErrorUsername.setText("");
        }
    }//GEN-LAST:event_jTextFieldUserNameFocusGained

    private void jButtonCreateAnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateAnAccountActionPerformed

        String password = String.valueOf(jPassword.getPassword());
        String confirmPassword = String.valueOf(jPasswordConfirm.getPassword());

        verifyAccountCreation(password, confirmPassword);
    }//GEN-LAST:event_jButtonCreateAnAccountActionPerformed

    private void jTextFieldUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUserNameKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonCreateAnAccount.doClick();

        }

        if (jTextFieldUserName.getText().length() < 8) {
            jLabelErrorUsername.setText("Username is less than 8 in length");
        }

        if (jTextFieldUserName.getText().length() >= 8 || jTextFieldUserName.getText().length() <= 1) {
            jLabelErrorUsername.setText("");
        }

        if (jTextFieldUserName.getText().isBlank() || jTextFieldUserName.getText().isEmpty()) {
            jLabelErrorUsername.setText("Username field is empty");
        }

    }//GEN-LAST:event_jTextFieldUserNameKeyPressed

    public int passwordCheckStrength(String password) {
        int strength = 0;

        if (password.length() >= 3 && password.length() <= 5) {
            strength += 1;
        } else if (password.length() >= 6 && password.length() <= 8) {
            strength += 2;
        } else if (password.length() > 9) {
            strength += 3;
        }

        if (password.matches("(?=.*[a-z]).*")) {
            strength++;
        }
        if (password.matches("(?=.*[A-Z]).*")) {
            strength++;
        }
        if (password.matches("(?=.*[0-9]).*")) {
            strength++;
        }
        if (password.matches("(?=.*[!@#$%^&*]).*")) {
            strength++;
        }

        return strength;
    }

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonCreateAnAccount.doClick();
        }

        String password = String.valueOf(jPassword.getPassword());

        int strength = passwordCheckStrength(password);

        if (strength < 3) {
            jLabelPasswordError.setText("Password is weak");
            jLabelPasswordError.setForeground(new Color(204, 0, 0));
        } else if (strength < 5) {
            jLabelPasswordError.setText("Password is medium");
            jLabelPasswordError.setForeground(Color.YELLOW);
        } else {
            jLabelPasswordError.setText("Password is strong");
            jLabelPasswordError.setForeground(new Color(26, 186, 0));
        }

        if (evt.getKeyCode() == 8) {

            if (password.length() <= 1) {
                jLabelPasswordError.setText("");
                jLabelPasswordError.setForeground(new Color(204, 0, 0));
                strength = 0;
            }

        }

    }//GEN-LAST:event_jPasswordKeyPressed

    private void jPasswordConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordConfirmKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonCreateAnAccount.doClick();
        }
    }//GEN-LAST:event_jPasswordConfirmKeyPressed

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
            java.util.logging.Logger.getLogger(CreateAnAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAnAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAnAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAnAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAnAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreateAnAccountTitile;
    private javax.swing.JButton jButtonCreateAnAccount;
    private javax.swing.JComboBox<String> jComboBoxSignInAs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAlreadyHaveAnAccount;
    private javax.swing.JLabel jLabelConfrimPassword;
    private javax.swing.JLabel jLabelErrorConfirmPassword;
    private javax.swing.JLabel jLabelErrorUsername;
    private javax.swing.JLabel jLabelForPassword;
    private javax.swing.JLabel jLabelForUsername;
    private javax.swing.JLabel jLabelMainImage;
    private javax.swing.JLabel jLabelPasswordError;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPasswordConfirm;
    private javax.swing.JCheckBox jShowPassword;
    private javax.swing.JLabel jSignIn;
    private javax.swing.JTextField jTextFieldUserName;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
