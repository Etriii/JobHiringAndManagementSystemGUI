package MainPackage;

//import Classes.AccountHolders;
import Classes.setAllConnections;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class semiProfileForHunter extends javax.swing.JFrame {

    private static String mainIndex;

    public semiProfileForHunter() {
        initComponents();
    }

    public semiProfileForHunter(String index) {
        initComponents();
        mainIndex = index;
        jCheckBoxIHaveExperience.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();
        jTextFieldForFirstName = new javax.swing.JTextField();
        jLabelLastName = new javax.swing.JLabel();
        jTextFieldForLastName = new javax.swing.JTextField();
        jLabelRecentExperience = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBoxIHaveExperience = new javax.swing.JCheckBox();
        jLabelJobTitle = new javax.swing.JLabel();
        jTextFieldJobTitle = new javax.swing.JTextField();
        jLabelCompanyName = new javax.swing.JLabel();
        jTextFieldCompanyName = new javax.swing.JTextField();
        jLabelStarted = new javax.swing.JLabel();
        jTextFieldStartedMonth = new javax.swing.JTextField();
        jTextFieldStartedYear = new javax.swing.JTextField();
        jTextFieldEndedMonth = new javax.swing.JTextField();
        jTextFieldEndedYear = new javax.swing.JTextField();
        jLabelEnded = new javax.swing.JLabel();
        jCheckBoxStillInRole = new javax.swing.JCheckBox();
        jButtonSaveAndContinue = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelFormat = new javax.swing.JLabel();
        jLabelFirstName1 = new javax.swing.JLabel();
        jTextFieldForMiddleName = new javax.swing.JTextField();
        jLabelLastName1 = new javax.swing.JLabel();
        jTextFieldForSuffix = new javax.swing.JTextField();
        jLabelLastName2 = new javax.swing.JLabel();
        jTextFieldForAge = new javax.swing.JTextField();
        jButtonSaveAndContinue1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(376, 451));

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WELCOME NEW JOB HUNTER");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("START A HUNTER PROFILE");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelFirstName.setText("First Name");

        jTextFieldForFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForFirstNameActionPerformed(evt);
            }
        });

        jLabelLastName.setText("Last Name");

        jTextFieldForLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForLastNameActionPerformed(evt);
            }
        });
        jTextFieldForLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldForLastNameKeyPressed(evt);
            }
        });

        jLabelRecentExperience.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelRecentExperience.setText("Recent Experience");

        jSeparator1.setBackground(new java.awt.Color(0, 102, 102));

        jCheckBoxIHaveExperience.setSelected(true);
        jCheckBoxIHaveExperience.setText("I have experience");
        jCheckBoxIHaveExperience.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxIHaveExperienceActionPerformed(evt);
            }
        });

        jLabelJobTitle.setText("Job title");

        jTextFieldJobTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJobTitleActionPerformed(evt);
            }
        });

        jLabelCompanyName.setText("Company Name");

        jTextFieldCompanyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCompanyNameActionPerformed(evt);
            }
        });

        jLabelStarted.setText("Started");

        jTextFieldStartedMonth.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldStartedMonth.setText("Month");
        jTextFieldStartedMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldStartedMonthFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldStartedMonthFocusLost(evt);
            }
        });
        jTextFieldStartedMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStartedMonthActionPerformed(evt);
            }
        });

        jTextFieldStartedYear.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldStartedYear.setText("Year");
        jTextFieldStartedYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldStartedYearFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldStartedYearFocusLost(evt);
            }
        });
        jTextFieldStartedYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStartedYearActionPerformed(evt);
            }
        });
        jTextFieldStartedYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldStartedYearKeyPressed(evt);
            }
        });

        jTextFieldEndedMonth.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldEndedMonth.setText("Month");
        jTextFieldEndedMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEndedMonthFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEndedMonthFocusLost(evt);
            }
        });
        jTextFieldEndedMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEndedMonthActionPerformed(evt);
            }
        });

        jTextFieldEndedYear.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldEndedYear.setText("Year");
        jTextFieldEndedYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEndedYearFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEndedYearFocusLost(evt);
            }
        });
        jTextFieldEndedYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEndedYearActionPerformed(evt);
            }
        });
        jTextFieldEndedYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEndedYearKeyPressed(evt);
            }
        });

        jLabelEnded.setText("Ended");

        jCheckBoxStillInRole.setText("Still in role");
        jCheckBoxStillInRole.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBoxStillInRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxStillInRoleActionPerformed(evt);
            }
        });

        jButtonSaveAndContinue.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSaveAndContinue.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSaveAndContinue.setText("Save and Continue");
        jButtonSaveAndContinue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaveAndContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveAndContinueActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 102, 102));

        jSeparator3.setBackground(new java.awt.Color(0, 102, 102));

        jLabelFormat.setText("Format: 02/2005");

        jLabelFirstName1.setText("Middle Name");

        jTextFieldForMiddleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForMiddleNameActionPerformed(evt);
            }
        });

        jLabelLastName1.setText("Suffix");

        jTextFieldForSuffix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForSuffixActionPerformed(evt);
            }
        });
        jTextFieldForSuffix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldForSuffixKeyPressed(evt);
            }
        });

        jLabelLastName2.setText("Age");

        jTextFieldForAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldForAgeActionPerformed(evt);
            }
        });
        jTextFieldForAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldForAgeKeyPressed(evt);
            }
        });

        jButtonSaveAndContinue1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSaveAndContinue1.setForeground(new java.awt.Color(0, 102, 102));
        jButtonSaveAndContinue1.setText("Back");
        jButtonSaveAndContinue1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaveAndContinue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveAndContinue1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStarted)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldStartedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldStartedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEndedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelEnded))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBoxStillInRole, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldEndedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabelFormat))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCompanyName)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabelRecentExperience)
                                        .addGap(60, 60, 60)
                                        .addComponent(jCheckBoxIHaveExperience, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldForMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelFirstName1))
                                            .addGap(24, 24, 24)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelLastName1)
                                                .addComponent(jTextFieldForSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(6, 6, 6)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldForAge)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabelLastName2)
                                                    .addGap(0, 0, Short.MAX_VALUE))))
                                        .addComponent(jSeparator3)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldForFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelFirstName))
                                            .addGap(24, 24, 24)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelLastName)
                                                .addComponent(jTextFieldForLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jSeparator1)
                                        .addComponent(jTextFieldJobTitle)
                                        .addComponent(jLabelJobTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButtonSaveAndContinue1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonSaveAndContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3))))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName)
                    .addComponent(jLabelLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldForFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldForLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFirstName1)
                    .addComponent(jLabelLastName1)
                    .addComponent(jLabelLastName2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldForMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldForSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldForAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRecentExperience)
                    .addComponent(jCheckBoxIHaveExperience))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelJobTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldJobTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCompanyName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelStarted)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldStartedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStartedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEnded)
                            .addComponent(jCheckBoxStillInRole))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEndedMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEndedYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFormat))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveAndContinue)
                    .addComponent(jButtonSaveAndContinue1))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveAndContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveAndContinueActionPerformed
        if (jTextFieldForFirstName.getText().replaceAll("\\s+", "").equals("") || jTextFieldForLastName.getText().replaceAll("\\s+", "").equals("")
                || jTextFieldForMiddleName.getText().replaceAll("\\s+", "").equals("") || jTextFieldForSuffix.getText().replaceAll("\\s+", "").equals("") || jTextFieldForAge.getText().replaceAll("\\s+", "").equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
        } else if (jCheckBoxIHaveExperience.isSelected()) {
            if (!jCheckBoxStillInRole.isSelected()) {
                if (jTextFieldForFirstName.getText().replaceAll("\\s+", "").equals("") || jTextFieldForLastName.getText().replaceAll("\\s+", "").equals("")
                        || jTextFieldForMiddleName.getText().replaceAll("\\s+", "").equals("") || jTextFieldForSuffix.getText().replaceAll("\\s+", "").equals("") || jTextFieldForAge.getText().replaceAll("\\s+", "").equals("")
                        || jTextFieldJobTitle.getText().replaceAll("\\s+", "").equals("") || jTextFieldCompanyName.getText().replaceAll("\\s+", "").equals("") || jTextFieldStartedMonth.getText().replaceAll("\\s+", "").equals("")
                        || jTextFieldStartedYear.getText().replaceAll("\\s+", "").equals("") || jTextFieldEndedMonth.getText().replaceAll("\\s+", "").equals("") || jTextFieldEndedYear.getText().replaceAll("\\s+", "").equals("")
                        || jTextFieldStartedMonth.getText().replaceAll("\\s+", "").equals("Month") || jTextFieldStartedYear.getText().replaceAll("\\s+", "").equals("Year") || jTextFieldEndedMonth.getText().replaceAll("\\s+", "").equals("Month")
                        || jTextFieldEndedYear.getText().replaceAll("\\s+", "").equals("Year")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                } else {
//                    AccountHolders.getHunterByIndex(mainIndex).setFirstName(jTextFieldForFirstName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setLastName(jTextFieldForLastName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setMiddleName(jTextFieldForMiddleName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setSuffix(jTextFieldForSuffix.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setAge(Integer.parseInt(jTextFieldForAge.getText()));
//                    AccountHolders.getHunterByIndex(mainIndex).setJobTitleExperience(jTextFieldJobTitle.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobCompanyNameExperience(jTextFieldCompanyName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobStartExperienceMonth(jTextFieldStartedMonth.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobSartExperienceYear(jTextFieldStartedYear.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobEndExperienceMonth(jTextFieldEndedMonth.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobEndExperienceYear(jTextFieldEndedYear.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setHaveExperience(true);
//                    AccountHolders.getHunterByIndex(mainIndex).setStillInRole(false);
//                    AccountHolders.getHunterByIndex(mainIndex).setStartedFillProfile(true);
                    JOptionPane.showMessageDialog(this, "Partial Information saved successfully. :)");
//                    JobHuntersPortal jp = new JobHuntersPortal(mainIndex);
//                    jp.setVisible(true);
                    this.dispose();
                }
            } else {
                if (jTextFieldForFirstName.getText().replaceAll("\\s+", "").equals("") || jTextFieldForLastName.getText().replaceAll("\\s+", "").equals("")
                        || jTextFieldForMiddleName.getText().replaceAll("\\s+", "").equals("") || jTextFieldForSuffix.getText().replaceAll("\\s+", "").equals("") || jTextFieldForAge.getText().replaceAll("\\s+", "").equals("")
                        || jTextFieldJobTitle.getText().replaceAll("\\s+", "").equals("") || jTextFieldCompanyName.getText().replaceAll("\\s+", "").equals("") || jTextFieldStartedMonth.getText().replaceAll("\\s+", "").equals("")
                        || jTextFieldStartedYear.getText().replaceAll("\\s+", "").equals("") || jTextFieldStartedMonth.getText().replaceAll("\\s+", "").equals("Month") || jTextFieldStartedYear.getText().replaceAll("\\s+", "").equals("Year")) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                } else {
//                    AccountHolders.getHunterByIndex(mainIndex).setFirstName(jTextFieldForFirstName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setLastName(jTextFieldForLastName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setMiddleName(jTextFieldForMiddleName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setSuffix(jTextFieldForSuffix.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setAge(Integer.parseInt(jTextFieldForAge.getText()));
//                    AccountHolders.getHunterByIndex(mainIndex).setJobTitleExperience(jTextFieldJobTitle.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobCompanyNameExperience(jTextFieldCompanyName.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobStartExperienceMonth(jTextFieldStartedMonth.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setJobSartExperienceYear(jTextFieldStartedYear.getText());
//                    AccountHolders.getHunterByIndex(mainIndex).setHaveExperience(true);
//                    AccountHolders.getHunterByIndex(mainIndex).setStillInRole(true);
//                    AccountHolders.getHunterByIndex(mainIndex).setStartedFillProfile(true);
                    JOptionPane.showMessageDialog(this, "Partial Information saved successfully. :)");
//                    JobHuntersPortal jp = new JobHuntersPortal(mainIndex);
//                    jp.setVisible(true);
                    this.dispose();
                }
            }
        } else {
//            AccountHolders.getHunterByIndex(mainIndex).setFirstName(jTextFieldForFirstName.getText());
//            AccountHolders.getHunterByIndex(mainIndex).setLastName(jTextFieldForLastName.getText());
//            AccountHolders.getHunterByIndex(mainIndex).setMiddleName(jTextFieldForMiddleName.getText());
//            AccountHolders.getHunterByIndex(mainIndex).setSuffix(jTextFieldForSuffix.getText());
//            AccountHolders.getHunterByIndex(mainIndex).setAge(Integer.parseInt(jTextFieldForAge.getText()));
//            AccountHolders.getHunterByIndex(mainIndex).setStartedFillProfile(true);

            try {

                PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("UPDATE hunters_account SET first_name = ?, middle_name = ?, last_name = ?,suffix = ?, age = ?, semi_info = ? WHERE id =" + mainIndex);
                ps.setString(1, jTextFieldForFirstName.getText());
                ps.setString(2, jTextFieldForMiddleName.getText());
                ps.setString(3, jTextFieldForLastName.getText());
                ps.setString(4, jTextFieldForSuffix.getText());
                ps.setInt(5, Integer.parseInt(jTextFieldForAge.getText()));
                ps.setInt(6, 1);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Partial Information saved successfully. :)");

                JobHuntersPortal jp = new JobHuntersPortal(mainIndex);
                jp.setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonSaveAndContinueActionPerformed

    private void jCheckBoxStillInRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxStillInRoleActionPerformed
        if (jCheckBoxStillInRole.isSelected()) {
            jTextFieldEndedMonth.setEnabled(false);
            jTextFieldEndedYear.setEnabled(false);
            jTextFieldEndedMonth.setText("");
            jTextFieldEndedYear.setText("");

        } else {
            jTextFieldEndedMonth.setEnabled(true);
            jTextFieldEndedYear.setEnabled(true);
            jTextFieldEndedMonth.setText("Month");
            jTextFieldEndedYear.setText("Year");
        }
    }//GEN-LAST:event_jCheckBoxStillInRoleActionPerformed

    private void jTextFieldEndedYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEndedYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEndedYearActionPerformed

    private void jTextFieldEndedYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEndedYearFocusLost
        if (jTextFieldEndedYear.getText().replaceAll("\\s+", "").equals("")) {
            jTextFieldEndedYear.setText("Year");
            jTextFieldEndedYear.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextFieldEndedYearFocusLost

    private void jTextFieldEndedYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEndedYearFocusGained
        if (jTextFieldEndedYear.getText().replaceAll("\\s+", "").equals("Year")) {
            jTextFieldEndedYear.setText("");
            jTextFieldEndedYear.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldEndedYearFocusGained

    private void jTextFieldEndedMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEndedMonthActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldEndedMonthActionPerformed

    private void jTextFieldEndedMonthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEndedMonthFocusLost
        if (jTextFieldEndedMonth.getText().replaceAll("\\s+", "").equals("")) {
            jTextFieldEndedMonth.setText("Month");
            jTextFieldEndedMonth.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextFieldEndedMonthFocusLost

    private void jTextFieldEndedMonthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEndedMonthFocusGained
        if (jTextFieldEndedMonth.getText().replaceAll("\\s+", "").equals("Month")) {
            jTextFieldEndedMonth.setText("");
            jTextFieldEndedMonth.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldEndedMonthFocusGained

    private void jTextFieldStartedYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStartedYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStartedYearActionPerformed

    private void jTextFieldStartedYearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStartedYearFocusLost
        if (jTextFieldStartedYear.getText().replaceAll("\\s+", "").equals("")) {
            jTextFieldStartedYear.setText("Year");
            jTextFieldStartedYear.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextFieldStartedYearFocusLost

    private void jTextFieldStartedYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStartedYearFocusGained
        if (jTextFieldStartedYear.getText().replaceAll("\\s+", "").equals("Year")) {
            jTextFieldStartedYear.setText("");
            jTextFieldStartedYear.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldStartedYearFocusGained

    private void jTextFieldStartedMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStartedMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStartedMonthActionPerformed

    private void jTextFieldStartedMonthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStartedMonthFocusLost
        if (jTextFieldStartedMonth.getText().replaceAll("\\s+", "").equals("")) {
            jTextFieldStartedMonth.setText("Month");
            jTextFieldStartedMonth.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextFieldStartedMonthFocusLost

    private void jTextFieldStartedMonthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStartedMonthFocusGained
        if (jTextFieldStartedMonth.getText().replaceAll("\\s+", "").equals("Month")) {
            jTextFieldStartedMonth.setText("");
            jTextFieldStartedMonth.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldStartedMonthFocusGained

    private void jTextFieldCompanyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCompanyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCompanyNameActionPerformed

    private void jTextFieldJobTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJobTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJobTitleActionPerformed

    private void jCheckBoxIHaveExperienceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIHaveExperienceActionPerformed
        if (!jCheckBoxIHaveExperience.isSelected()) {
            jLabelJobTitle.setText("New to the industry? That's fine. You can always add your");
            jLabelCompanyName.setText("work experience later in your Profile.");
            jTextFieldJobTitle.setVisible(false);
            jTextFieldCompanyName.setVisible(false);
            jLabelStarted.setVisible(false);
            jLabelEnded.setVisible(false);
            jCheckBoxStillInRole.setVisible(false);
            jTextFieldStartedMonth.setVisible(false);
            jTextFieldStartedYear.setVisible(false);
            jTextFieldEndedMonth.setVisible(false);
            jTextFieldEndedYear.setVisible(false);
            jLabelFormat.setVisible(false);
            this.setSize(new Dimension(384, 425));
        } else {
            jLabelJobTitle.setText("Job title");
            jLabelCompanyName.setText("Company Name");
            jTextFieldJobTitle.setVisible(true);
            jTextFieldCompanyName.setVisible(true);
            jLabelStarted.setVisible(true);
            jLabelEnded.setVisible(true);
            jCheckBoxStillInRole.setVisible(true);
            jTextFieldStartedMonth.setVisible(true);
            jTextFieldStartedYear.setVisible(true);
            jTextFieldEndedMonth.setVisible(true);
            jTextFieldEndedYear.setVisible(true);
            jLabelFormat.setVisible(true);
            this.setSize(new Dimension(384, 555));
        }
    }//GEN-LAST:event_jCheckBoxIHaveExperienceActionPerformed

    private void jTextFieldForLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForLastNameActionPerformed

    private void jTextFieldForFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForFirstNameActionPerformed

    private void jTextFieldForLastNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldForLastNameKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonSaveAndContinue.doClick();
        }
    }//GEN-LAST:event_jTextFieldForLastNameKeyPressed

    private void jTextFieldForMiddleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForMiddleNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForMiddleNameActionPerformed

    private void jTextFieldForSuffixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForSuffixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForSuffixActionPerformed

    private void jTextFieldForSuffixKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldForSuffixKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForSuffixKeyPressed

    private void jTextFieldForAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldForAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldForAgeActionPerformed

    private void jTextFieldForAgeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldForAgeKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonSaveAndContinue.doClick();
        }
    }//GEN-LAST:event_jTextFieldForAgeKeyPressed

    private void jTextFieldStartedYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldStartedYearKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonSaveAndContinue.doClick();
        }
    }//GEN-LAST:event_jTextFieldStartedYearKeyPressed

    private void jTextFieldEndedYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEndedYearKeyPressed
        if (evt.getKeyCode() == 10) {
            jButtonSaveAndContinue.doClick();
        }
    }//GEN-LAST:event_jTextFieldEndedYearKeyPressed

    private void jButtonSaveAndContinue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveAndContinue1ActionPerformed
        this.dispose();
        MainPanel mp = new MainPanel();
        mp.setVisible(true);
    }//GEN-LAST:event_jButtonSaveAndContinue1ActionPerformed

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
            java.util.logging.Logger.getLogger(semiProfileForHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(semiProfileForHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(semiProfileForHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(semiProfileForHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new semiProfileForHunter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSaveAndContinue;
    private javax.swing.JButton jButtonSaveAndContinue1;
    private javax.swing.JCheckBox jCheckBoxIHaveExperience;
    private javax.swing.JCheckBox jCheckBoxStillInRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCompanyName;
    private javax.swing.JLabel jLabelEnded;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelFirstName1;
    private javax.swing.JLabel jLabelFormat;
    private javax.swing.JLabel jLabelJobTitle;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelLastName1;
    private javax.swing.JLabel jLabelLastName2;
    private javax.swing.JLabel jLabelRecentExperience;
    private javax.swing.JLabel jLabelStarted;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextFieldCompanyName;
    private javax.swing.JTextField jTextFieldEndedMonth;
    private javax.swing.JTextField jTextFieldEndedYear;
    private javax.swing.JTextField jTextFieldForAge;
    private javax.swing.JTextField jTextFieldForFirstName;
    private javax.swing.JTextField jTextFieldForLastName;
    private javax.swing.JTextField jTextFieldForMiddleName;
    private javax.swing.JTextField jTextFieldForSuffix;
    private javax.swing.JTextField jTextFieldJobTitle;
    private javax.swing.JTextField jTextFieldStartedMonth;
    private javax.swing.JTextField jTextFieldStartedYear;
    // End of variables declaration//GEN-END:variables
}
