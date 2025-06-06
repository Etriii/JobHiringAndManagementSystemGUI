package MainPackage;

//import Classes.AccountHolders;
import Classes.setAllConnections;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;

public class RecruitersAddInformation extends javax.swing.JFrame {
    
    DefaultListModel contactLists = new DefaultListModel();
    private String mainIndex = "0";
    
    public RecruitersAddInformation() {
        initComponents();
        
        setAllConnections.setAllConnection();
        setAll();
    }
    
    public RecruitersAddInformation(String mainIndex) {
        this.mainIndex = mainIndex;
        
        initComponents();
        
        setAllConnections.setAllConnection();
        setAll();
    }
    
    public void setAll() {
        
        jListOfContacts.setModel(contactLists);
        jButtonEdit.setEnabled(false);
        jButtonRemove.setEnabled(false);
        jButtonClearLists.setEnabled(false);
        jButtonSave.setEnabled(false);
        
        setCurrentValues();
    }
    
    public void setCurrentValues() {
        
        try {
            
            PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("SELECT * FROM personalinformation WHERE id = " + mainIndex);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                dateOfBirth.setText(rs.getString(3));
                PlaceOFBirth.setText(rs.getString(4));
                
                if ("Male".equals(rs.getString(5))) {
                    jRadioButtonMale.setSelected(true);
                    jRadioButtonFemale.setSelected(false);
                    jRadioButtonPrefNotSay.setSelected(false);
                } else if ("Female".equals(rs.getString(5))) {
                    jRadioButtonMale.setSelected(false);
                    jRadioButtonFemale.setSelected(true);
                    jRadioButtonPrefNotSay.setSelected(false);
                } else {
                    jRadioButtonMale.setSelected(false);
                    jRadioButtonFemale.setSelected(false);
                    jRadioButtonPrefNotSay.setSelected(true);
                }
                
                jTextFieldContactNumber.setText(rs.getString(2));
                
                addressRegion.setText(rs.getString(6));
                addressProvince.setText(rs.getString(7));
                addressCity.setText(rs.getString(8));
                addressBarangay.setText(rs.getString(9));

//                checkboxSameAddress.setText(); ON HOLD NEED OG IFs'
                if (rs.getInt(10) == 0) {
                    checkboxSameAddress.setSelected(false);
                } else {
                    checkboxSameAddress.setSelected(true);
                }
                
                addressRegion2.setText(rs.getString(11));
                addressProvince2.setText(rs.getString(12));
                addressCity2.setText(rs.getString(13));
                addressBarangay2.setText(rs.getString(14));
                
                Object[] contactLists2 = rs.getString(15).split(", ");
                
                for (Object contact : contactLists2) {
                    contactLists.addElement(contact);
                }
                
                jListOfContacts.setModel(contactLists);

//            ON HOLD SA ANG contact_info (15)
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void clearLists() {
        if (jListOfContacts.getModel().getSize() > 0) {
            jButtonClearLists.setEnabled(true);
        } else {
            jButtonClearLists.setEnabled(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dateOfBirth = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PlaceOFBirth = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRadioButtonMale = new javax.swing.JRadioButton();
        jRadioButtonFemale = new javax.swing.JRadioButton();
        jRadioButtonPrefNotSay = new javax.swing.JRadioButton();
        jTextFieldContactNumber = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        addressRegion = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        addressProvince = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        addressCity = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        addressBarangay = new javax.swing.JTextField();
        addressBarangay2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        addressRegion2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        addressProvince2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        addressCity2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        checkboxSameAddress = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListOfContacts = new javax.swing.JList<>();
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonClearLists = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jButtonSave = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButtonResetAll = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel5.setText("Date of Birth:");

        dateOfBirth.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateOfBirthFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateOfBirthFocusLost(evt);
            }
        });
        dateOfBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateOfBirthActionPerformed(evt);
            }
        });

        jLabel6.setText("Place of Birth:");

        PlaceOFBirth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaceOFBirthActionPerformed(evt);
            }
        });

        jLabel7.setText("Sex: ");
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jRadioButtonMale.setText("Male");
        jRadioButtonMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMaleActionPerformed(evt);
            }
        });

        jRadioButtonFemale.setText("Female");
        jRadioButtonFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFemaleActionPerformed(evt);
            }
        });

        jRadioButtonPrefNotSay.setText("Preferrably not to Say");
        jRadioButtonPrefNotSay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPrefNotSayActionPerformed(evt);
            }
        });

        jLabel13.setText("Contact number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonFemale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonPrefNotSay)
                        .addGap(85, 85, 85)
                        .addComponent(jLabel13)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(4, 4, 4)
                        .addComponent(PlaceOFBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(PlaceOFBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButtonMale)
                    .addComponent(jRadioButtonFemale)
                    .addComponent(jRadioButtonPrefNotSay)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complete Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel12.setText("Permanent Address");

        jLabel16.setText("Current Address");

        jLabel18.setText("Region");

        addressRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressRegionActionPerformed(evt);
            }
        });

        jLabel19.setText("Province");

        addressProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressProvinceActionPerformed(evt);
            }
        });

        jLabel20.setText("City/Municipality");

        addressCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressCityActionPerformed(evt);
            }
        });

        jLabel21.setText("Barangay");

        jLabel22.setText("Region");

        addressRegion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressRegion2ActionPerformed(evt);
            }
        });

        jLabel23.setText("Province");

        addressProvince2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressProvince2ActionPerformed(evt);
            }
        });

        jLabel24.setText("City/Municipality");

        addressCity2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressCity2ActionPerformed(evt);
            }
        });

        jLabel25.setText("Barangay");

        checkboxSameAddress.setText("Same as PA");
        checkboxSameAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSameAddressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressRegion, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(addressProvince)
                            .addComponent(addressCity)
                            .addComponent(addressBarangay)))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressRegion2)
                            .addComponent(addressProvince2)
                            .addComponent(addressCity2)
                            .addComponent(addressBarangay2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel22)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkboxSameAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16)
                    .addComponent(checkboxSameAddress))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(addressRegion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(addressProvince2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(addressCity2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(addressBarangay2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(addressRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(addressProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(addressCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(addressBarangay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel9.setText("Type: ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Telephone No.", "E-mail", "Facebook", "Instagram" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jListOfContacts.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jListOfContactsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jListOfContactsFocusLost(evt);
            }
        });
        jListOfContacts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListOfContactsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListOfContacts);

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButtonEditFocusLost(evt);
            }
        });
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonClearLists.setText("Clear Lists");
        jButtonClearLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearListsActionPerformed(evt);
            }
        });

        jLabel10.setText("Terms and Privacy.");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Agree");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Disagree");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jButtonSave.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSave.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.setText("UPDATE PROFILE");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel11.setText("Input Here:");

        jButtonResetAll.setText("Reset All");
        jButtonResetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetAllActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonExit.setText("Return");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButton4)
                        .addGap(7, 7, 7)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonResetAll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonClearLists, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClearLists))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExit)
                    .addComponent(jButtonResetAll))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dateOfBirthFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateOfBirthFocusGained
//        if (dateOfBirth.getText().equals("Ex. mm/dd/yyyy")) {
//            dateOfBirth.setText("");
//            dateOfBirth.setForeground(new Color(0, 0, 0));
//        }
    }//GEN-LAST:event_dateOfBirthFocusGained

    private void dateOfBirthFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateOfBirthFocusLost
//        if (dateOfBirth.getText().equals("")) {
//            dateOfBirth.setText("Ex. mm/dd/yyyy");
//            dateOfBirth.setForeground(new Color(153, 153, 153));
//        }
    }//GEN-LAST:event_dateOfBirthFocusLost

    private void dateOfBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateOfBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateOfBirthActionPerformed

    private void PlaceOFBirthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceOFBirthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlaceOFBirthActionPerformed

    private void jRadioButtonMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMaleActionPerformed
        jRadioButtonFemale.setSelected(false);
        jRadioButtonPrefNotSay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonMaleActionPerformed

    private void jRadioButtonFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFemaleActionPerformed
        jRadioButtonMale.setSelected(false);
        jRadioButtonPrefNotSay.setSelected(false);
    }//GEN-LAST:event_jRadioButtonFemaleActionPerformed

    private void jRadioButtonPrefNotSayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPrefNotSayActionPerformed
        jRadioButtonFemale.setSelected(false);
        jRadioButtonMale.setSelected(false);
    }//GEN-LAST:event_jRadioButtonPrefNotSayActionPerformed

    private void addressRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressRegionActionPerformed

    private void addressProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressProvinceActionPerformed

    private void addressCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressCityActionPerformed

    private void addressRegion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressRegion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressRegion2ActionPerformed

    private void addressProvince2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressProvince2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressProvince2ActionPerformed

    private void addressCity2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressCity2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressCity2ActionPerformed

    private void checkboxSameAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSameAddressActionPerformed
        if (!checkboxSameAddress.isSelected()) {
            addressRegion2.setText("");
            addressProvince2.setText("");
            addressCity2.setText("");
            addressBarangay2.setText("");
        } else {
            addressRegion2.setText(addressRegion.getText());
            addressProvince2.setText(addressProvince.getText());
            addressCity2.setText(addressCity.getText());
            addressBarangay2.setText(addressBarangay.getText());
        }
    }//GEN-LAST:event_checkboxSameAddressActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
        if (jComboBox2.getSelectedItem().equals("Telephone No.")) {
            //            jTextField7.setText("09633127462");
            jTextField7.setText("");
        } else if (jComboBox2.getSelectedItem().equals("E-mail")) {
            //            jTextField7.setText("alexarnaizaparece@gmail.com");
            jTextField7.setText("");
        } else if (jComboBox2.getSelectedItem().equals("Facebook")) {
            //            jTextField7.setText("alexaparecejr");
            jTextField7.setText("");
        } else {
            jTextField7.setText("");
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        //        if (jTextField7.getText().equals("Input Here") || jTextField7.getText().equals("09633127462") || jTextField7.getText().equals("alexarnaizaparece@gmail.com") || jTextField7.getText().equals("alexaparecejr") || jTextField7.getText().equals("yeahyeah")) {
        //            jTextField7.setText("");
        //            jTextField7.setForeground(new Color(0, 0, 0));
        //        }

        if (jButtonEdit.getText().equals("UPDATE")) {
            jButtonAdd.setEnabled(false);
            jButtonRemove.setEnabled(false);
        } else {
            jButtonAdd.setEnabled(true);
            jButtonEdit.setEnabled(false);
            jButtonRemove.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        //        if (jTextField7.getText().equals("")) {
        //            jTextField7.setText("Input Here");
        //            jTextField7.setForeground(new Color(153, 153, 153));
        //        }
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jListOfContactsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListOfContactsFocusGained

    }//GEN-LAST:event_jListOfContactsFocusGained

    private void jListOfContactsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jListOfContactsFocusLost
        //        jList1.clearSelection();
    }//GEN-LAST:event_jListOfContactsFocusLost

    private void jListOfContactsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListOfContactsMouseClicked
        //        if (jList1.getModel().getSize() == 0) {
        //            jButtonClearLists.setEnabled(false);
        //            jButtonEdit.setEnabled(true);
        //            jButtonRemove.setEnabled(true);
        //        }
        if (jListOfContacts.getModel().getSize() > 0) {
            jButtonClearLists.setEnabled(true);
            jButtonAdd.setEnabled(false);
            jButtonEdit.setEnabled(true);
            jButtonRemove.setEnabled(true);
        } else {
            jButtonAdd.setEnabled(true);
            jButtonEdit.setEnabled(false);
            jButtonRemove.setEnabled(false);
            jButtonClearLists.setEnabled(false);
        }
    }//GEN-LAST:event_jListOfContactsMouseClicked

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        //        if (jTextField7.getText().equals("Input Here") || jTextField7.getText().equals("09633127462") || jTextField7.getText().equals("alexarnaizaparece@gmail.com") || jTextField7.getText().equals("alexaparecejr") || jTextField7.getText().equals("yeahyeah")) {
        if (jTextField7.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Input Something First", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            contactLists.addElement(jComboBox2.getSelectedItem() + ": " + jTextField7.getText().trim());
            jTextField7.setText("");
            //            jTextField7.setForeground(new Color(153, 153, 153));
            clearLists();
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButtonEditFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditFocusLost

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        
        if (jButtonEdit.getText().equals("Edit")) {
            jButtonEdit.setText("UPDATE");
            jTextField7.setText(jListOfContacts.getSelectedValue());
            jButtonEdit.setForeground(Color.white);
            jButtonEdit.setBackground(Color.green);
            jListOfContacts.setEnabled(false);
            jButtonRemove.setEnabled(false);
            jButtonClearLists.setEnabled(false);
        } else {
            
            jButtonEdit.setText("Edit");
            int index = jListOfContacts.getSelectedIndex();
            
            contactLists.removeElementAt(index);
            contactLists.insertElementAt(jTextField7.getText(), index);
            jButtonEdit.setEnabled(false);
            jButtonRemove.setEnabled(false);
            jButtonAdd.setEnabled(true);
            jTextField7.setText(null);
            jListOfContacts.setEnabled(true);
            clearLists();
            
            jButtonEdit.setForeground(null);
            jButtonEdit.setBackground(null);
            
        }
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure that you want to remove this item?");
        
        if (choice == 0) {
            if (jListOfContacts.getModel().getSize() == 0) {
                JOptionPane.showMessageDialog(null, "NOTHING TO REMOVE");
                return;
            }
            int index = jListOfContacts.getSelectedIndex();
            contactLists.removeElementAt(index);
        }

    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonClearListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearListsActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure that you want to remove this item?");
        
        if (choice == 0) {
            if (jListOfContacts.getModel().getSize() == 0) {
                JOptionPane.showMessageDialog(null, "NO SET OF LISTS YET");
                return;
            } else {
                contactLists.removeAllElements();
            }
        }
    }//GEN-LAST:event_jButtonClearListsActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if (jRadioButton4.isSelected()) {
            jButtonSave.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        if (jRadioButton5.isSelected()) {
            jButtonSave.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        
        String gender;
        if (jRadioButtonMale.isSelected()) {
            gender = jRadioButtonMale.getText();
        } else if (jRadioButtonFemale.isSelected()) {
            gender = jRadioButtonFemale.getText();
        } else {
            gender = jRadioButtonPrefNotSay.getText();
        }
        
        int stateOfCheckBox;
        if (checkboxSameAddress.isSelected()) {
            stateOfCheckBox = 1;
        } else {
            stateOfCheckBox = 0;
        }

//        AccountHolders.getRecruiterByIndex(mainIndex).setAddInformationOfRecruiter(dateOfBirth.getText(), gender, addressRegion.getText(), addressProvince.getText(),
//                addressCity.getText(), addressBarangay.getText(), addressRegion2.getText(), addressProvince2.getText(), addressCity2.getText(),
//                addressBarangay2.getText(), contactLists, stateOfCheckBox, jTextFieldContactNumber.getText());
        try {
            
            PreparedStatement check = setAllConnections.getConRecruiter().prepareStatement("SELECT * FROM personalinformation WHERE id = " + mainIndex);
            ResultSet rs = check.executeQuery();
            
            if (rs.next()) {
                PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("UPDATE personalinformation SET contact_number = ?, birth_date = ?, place_of_birth = ?, sex = ?, p_a_region = ?, p_a_province = ?, p_a_city = ?, p_a_barangay = ?, same_as_pa = ?, c_a_region = ?, c_a_province = ?, c_a_city = ?, c_a_barangay = ?, contact_information = ? WHERE id = " + mainIndex);
                ps.setString(1, jTextFieldContactNumber.getText());
                ps.setString(2, dateOfBirth.getText());
                ps.setString(3, PlaceOFBirth.getText());
                ps.setString(4, gender);
                ps.setString(5, addressRegion.getText());
                ps.setString(6, addressProvince.getText());
                ps.setString(7, addressCity.getText());
                ps.setString(8, addressBarangay.getText());
                ps.setInt(9, stateOfCheckBox);
                ps.setString(10, addressRegion2.getText());
                ps.setString(11, addressProvince2.getText());
                ps.setString(12, addressCity2.getText());
                ps.setString(13, addressBarangay2.getText());
                
                StringBuilder contacts = new StringBuilder();
                for (int i = 0; i < contactLists.size(); i++) {
                    contacts.append(contactLists.getElementAt(i));
                    if (i < contactLists.size() - 1) {
                        contacts.append(", ");
                    }
                }
                
                String finalContact = String.valueOf(contacts);
                
                ps.setString(14, finalContact);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Update Information Successfully");
                
            } else {
                
                PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("INSERT INTO personalinformation(id, contact_number, birth_date, place_of_birth, sex, p_a_region, p_a_province, p_a_city, p_a_barangay,same_as_pa, c_a_region,c_a_province,  c_a_city, c_a_barangay, contact_information) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, mainIndex);
                ps.setString(2, jTextFieldContactNumber.getText());
                ps.setString(3, dateOfBirth.getText());
                ps.setString(4, PlaceOFBirth.getText());
                ps.setString(5, gender);
                ps.setString(6, addressRegion.getText());
                ps.setString(7, addressProvince.getText());
                ps.setString(8, addressCity.getText());
                ps.setString(9, addressBarangay.getText());
                ps.setInt(10, stateOfCheckBox);
                ps.setString(11, addressRegion2.getText());
                ps.setString(12, addressProvince2.getText());
                ps.setString(13, addressCity2.getText());
                
                StringBuilder contacts = new StringBuilder();
                for (int i = 0; i < contactLists.size(); i++) {
                    contacts.append(contactLists.getElementAt(i));
                    if (i < contactLists.size() - 1) {
                        contacts.append(", ");
                    }
                }
                
                String finalContact = String.valueOf(contacts);
                
                ps.setString(14, finalContact);
                
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Update Information Successfully");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonResetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetAllActionPerformed
        
        dateOfBirth.setText("Ex. mm/dd/yyyy");
        PlaceOFBirth.setText("");
        jRadioButtonMale.setSelected(false);
        jRadioButtonFemale.setSelected(false);
        jRadioButtonPrefNotSay.setSelected(false);
        addressRegion.setText("");
        addressProvince.setText("");
        addressCity.setText("");
        addressBarangay.setText("");
        checkboxSameAddress.setSelected(false);
        addressRegion2.setText("");
        addressProvince2.setText("");
        addressCity2.setText("");
        addressBarangay2.setText("");
        jComboBox2.setSelectedIndex(0);
        jTextField7.setText("");
        contactLists.removeAllElements();
        
        dateOfBirth.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_jButtonResetAllActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonExitActionPerformed

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
            java.util.logging.Logger.getLogger(RecruitersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecruitersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecruitersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecruitersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecruitersAddInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PlaceOFBirth;
    private javax.swing.JTextField addressBarangay;
    private javax.swing.JTextField addressBarangay2;
    private javax.swing.JTextField addressCity;
    private javax.swing.JTextField addressCity2;
    private javax.swing.JTextField addressProvince;
    private javax.swing.JTextField addressProvince2;
    private javax.swing.JTextField addressRegion;
    private javax.swing.JTextField addressRegion2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkboxSameAddress;
    private javax.swing.JTextField dateOfBirth;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClearLists;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonResetAll;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListOfContacts;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonPrefNotSay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldContactNumber;
    // End of variables declaration//GEN-END:variables

}
