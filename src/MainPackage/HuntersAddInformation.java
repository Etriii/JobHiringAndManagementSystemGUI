package MainPackage;

//import Classes.AccountHolders;
import Classes.setAllConnections;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class HuntersAddInformation extends javax.swing.JFrame {

    DefaultListModel contactLists = new DefaultListModel();

    private String mainIndex;

    public HuntersAddInformation() {
        initComponents();
        setAllConnections.setAllConnection();

        jListOfContacts.setModel(contactLists);
        jButtonEdit.setEnabled(false);
        jButtonRemove.setEnabled(false);
        jButtonClearLists.setEnabled(false);
        jButtonSave.setEnabled(false);

        setCurrentValues(mainIndex);

    }

    public HuntersAddInformation(String mainIndex) {
        this.mainIndex = mainIndex;

        initComponents();
        jListOfContacts.setModel(contactLists);
        jButtonEdit.setEnabled(false);
        jButtonRemove.setEnabled(false);
        jButtonClearLists.setEnabled(false);
        jButtonSave.setEnabled(false);

        setCurrentValues(mainIndex);
    }

    public void setCurrentValues(String mainIndex) {

//
//        if (("Male").equals(AccountHolders.getHunterByIndex(mainIndex).isSex())) {
//            jRadioButtonMale.setSelected(true);
//        } else if (("Female").equals(AccountHolders.getHunterByIndex(mainIndex).isSex())) {
//            jRadioButtonFemale.setSelected(true);
//        } else {
//            jRadioButtonPrefNotSay.setSelected(true);
//        }
//
//        dateOfBirth.setText(AccountHolders.getHunterByIndex(mainIndex).getDateOfBirth());
//        jFirstName.setText(AccountHolders.getHunterByIndex(mainIndex).getFirstName());
//        jMiddleName.setText(AccountHolders.getHunterByIndex(mainIndex).getMiddleName());
//        jLastName.setText(AccountHolders.getHunterByIndex(mainIndex).getLastName());
//        jEmail.setText(AccountHolders.getHunterByIndex(mainIndex).getEmailAddress());
//        jSuffix.setText(AccountHolders.getHunterByIndex(mainIndex).getSuffix());
//        jAge.setText(String.valueOf(AccountHolders.getHunterByIndex(mainIndex).getAge()));
//        PlaceOFBirth.setText(AccountHolders.getHunterByIndex(mainIndex).getPlaceOfBirth());
//        addressRegion.setText(AccountHolders.getHunterByIndex(mainIndex).getRegionLived());
//        addressProvince.setText(AccountHolders.getHunterByIndex(mainIndex).getProvinceLived());
//        addressCity.setText(AccountHolders.getHunterByIndex(mainIndex).getCityLived());
//        addressBarangay.setText(AccountHolders.getHunterByIndex(mainIndex).getBaranggayLived());
//        checkboxSameAddress.setSelected(AccountHolders.getHunterByIndex(mainIndex).isStateOfCheckBox());
//        addressRegion2.setText(AccountHolders.getHunterByIndex(mainIndex).getCregionLived());
//        addressProvince2.setText(AccountHolders.getHunterByIndex(mainIndex).getCprovinceLived());
//        addressCity2.setText(AccountHolders.getHunterByIndex(mainIndex).getCcityLived());
//        addressBarangay2.setText(AccountHolders.getHunterByIndex(mainIndex).getCbaranggayLived());
//
//        DefaultComboBoxModel cb = AccountHolders.getHunterByIndex(mainIndex).getContactLists();
//        for (int i = 0; i < cb.getSize(); i++) {
//            contactLists.addElement(cb.getElementAt(i));
//        }
        jRadioButtonPrefNotSay.setSelected(true);

        try {
            PreparedStatement admin = setAllConnections.getConAdmin().prepareStatement("SELECT * FROM hunters_account WHERE id = " + mainIndex);
            PreparedStatement hunter = setAllConnections.getConHunter().prepareStatement("SELECT * FROM personalinformation WHERE id = " + mainIndex);

            ResultSet a = admin.executeQuery();
            ResultSet h = hunter.executeQuery();

            if (a.next()) {
                this.setTitle(a.getString(5) + " | UPDATE (HUNTERS PORTAL)   ID - " + mainIndex);
                jFirstName.setText(a.getString(5));
                jMiddleName.setText(a.getString(6));
                jLastName.setText(a.getString(7));
                jSuffix.setText(a.getString(8));
                jAge.setText(a.getString(9));
            }

            if (h.next()) {
                jEmail.setText(h.getString(2));
                jTextFieldContactNumber.setText(h.getString(3));
                dateOfBirth.setText(h.getString(4));
                PlaceOFBirth.setText(h.getString(5));

//                sex.setText(mainIndex); ON HOLD NEENDS IFs'
                if ("Male".equals(h.getString(6))) {
                    jRadioButtonMale.setSelected(true);
                    jRadioButtonFemale.setSelected(false);
                    jRadioButtonPrefNotSay.setSelected(false);
                } else if ("Female".equals(h.getString(6))) {
                    jRadioButtonMale.setSelected(false);
                    jRadioButtonFemale.setSelected(true);
                    jRadioButtonPrefNotSay.setSelected(false);
                } else {
                    jRadioButtonMale.setSelected(false);
                    jRadioButtonFemale.setSelected(false);
                    jRadioButtonPrefNotSay.setSelected(true);
                }

                addressRegion.setText(h.getString(7));
                addressProvince.setText(h.getString(8));
                addressCity.setText(h.getString(9));
                addressBarangay.setText(h.getString(10));

                if (h.getInt(11) == 0) {
                    checkboxSameAddress.setSelected(false);
                } else {
                    checkboxSameAddress.setSelected(true);
                }
//                checkboxSameAddress.setText(); ON HOLD NEED OG IFs'
                addressRegion2.setText(h.getString(12));
                addressProvince2.setText(h.getString(13));
                addressCity2.setText(h.getString(14));
                addressBarangay2.setText(h.getString(15));

//                contactLists.addElement(h.getString(16));
    
                Object[] contactlists = h.getString(16).split(", ");
                for(Object contact: contactlists){
                    contactLists.addElement(contact);
                }


                jListOfContacts.setModel(contactLists);

//                jListOfContacts.setText(mainIndex); ON HOLD STILL NEEDS EXPIREMENT
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
        dateOfBirth5 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
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
        jLabel8 = new javax.swing.JLabel();
        jFirstName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jMiddleName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLastName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSuffix = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jAge = new javax.swing.JTextField();
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

        jLabel26.setText("Age");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButton4)
                        .addGap(7, 7, 7)
                        .addComponent(jRadioButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonResetAll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonClearLists, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel5.setText("Birth Date");

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

        jLabel13.setText("Contact number:");

        jLabel8.setText("First Name");

        jFirstName.setFocusable(false);
        jFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFirstNameFocusLost(evt);
            }
        });
        jFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFirstNameActionPerformed(evt);
            }
        });

        jLabel14.setText("Middle Name");

        jMiddleName.setFocusable(false);
        jMiddleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jMiddleNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jMiddleNameFocusLost(evt);
            }
        });
        jMiddleName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiddleNameActionPerformed(evt);
            }
        });

        jLabel15.setText("Last Name");

        jLastName.setFocusable(false);
        jLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLastNameFocusLost(evt);
            }
        });
        jLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLastNameActionPerformed(evt);
            }
        });

        jLabel17.setText("Suffix");

        jSuffix.setFocusable(false);
        jSuffix.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jSuffixFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jSuffixFocusLost(evt);
            }
        });
        jSuffix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSuffixActionPerformed(evt);
            }
        });

        jLabel27.setText("E-mail");

        jEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jEmailFocusLost(evt);
            }
        });
        jEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailActionPerformed(evt);
            }
        });

        jLabel28.setText("Age");

        jAge.setFocusable(false);
        jAge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jAgeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jAgeFocusLost(evt);
            }
        });
        jAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonMale)
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButtonFemale)
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButtonPrefNotSay))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel27))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel6))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSuffix))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(183, 183, 183)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jAge)
                                        .addGap(2, 2, 2))
                                    .addComponent(PlaceOFBirth)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jSuffix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(PlaceOFBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonMale)
                        .addComponent(jLabel7))
                    .addComponent(jRadioButtonFemale)
                    .addComponent(jRadioButtonPrefNotSay)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Complete Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Permanent Address");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel16.setText("Current Address");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jLabel18.setText("Region");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        addressRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressRegionActionPerformed(evt);
            }
        });
        jPanel4.add(addressRegion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 213, -1));

        jLabel19.setText("Province");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        addressProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressProvinceActionPerformed(evt);
            }
        });
        jPanel4.add(addressProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 213, -1));

        jLabel20.setText("City/Municipality");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        addressCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressCityActionPerformed(evt);
            }
        });
        jPanel4.add(addressCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 213, -1));

        jLabel21.setText("Barangay");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel4.add(addressBarangay, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 213, -1));
        jPanel4.add(addressBarangay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 213, -1));

        jLabel22.setText("Region");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        addressRegion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressRegion2ActionPerformed(evt);
            }
        });
        jPanel4.add(addressRegion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 213, -1));

        jLabel23.setText("Province");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        addressProvince2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressProvince2ActionPerformed(evt);
            }
        });
        jPanel4.add(addressProvince2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 213, -1));

        jLabel24.setText("City/Municipality");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        addressCity2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressCity2ActionPerformed(evt);
            }
        });
        jPanel4.add(addressCity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 213, -1));

        jLabel25.setText("Barangay");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        checkboxSameAddress.setText("Same as PA");
        checkboxSameAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSameAddressActionPerformed(evt);
            }
        });
        jPanel4.add(checkboxSameAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 211, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

        try {

            PreparedStatement hunter = setAllConnections.getConHunter().prepareStatement("SELECT * FROM personalinformation WHERE id = " + mainIndex);
            ResultSet rh = hunter.executeQuery();

//            e_mail = ?, contact_number = ?, birth_date = ?, place_of_birth = ?, sex = ?,
//            p_a_region = ?, p_a_province = ?, p_a_city = ?, p_a_barangay = ?, same_as_pa = ?, 
//            c_a_region = ?, c_a_province = ?, c_a_city = ?, c_a_barangay = ?, contact_information = ?
            if (rh.next()) {
                PreparedStatement hunter2 = setAllConnections.getConHunter().prepareStatement("UPDATE personalinformation SET e_mail = ?, contact_number = ?, birth_date = ?, place_of_birth = ?, sex = ?, p_a_region = ?, p_a_province = ?, p_a_city = ?, p_a_barangay = ?, same_as_pa = ?, c_a_region = ?, c_a_province = ?, c_a_city = ?, c_a_barangay = ?, contact_information = ? WHERE id = " + mainIndex);
                hunter2.setString(1, jEmail.getText());
                hunter2.setString(2, jTextFieldContactNumber.getText());
                hunter2.setString(3, dateOfBirth.getText());
                hunter2.setString(4, PlaceOFBirth.getText());
                hunter2.setString(5, gender);
                hunter2.setString(6, addressRegion.getText());
                hunter2.setString(7, addressProvince.getText());
                hunter2.setString(8, addressCity.getText());
                hunter2.setString(9, addressBarangay.getText());
                hunter2.setInt(10, stateOfCheckBox);
                hunter2.setString(11, addressRegion2.getText());
                hunter2.setString(12, addressProvince2.getText());
                hunter2.setString(13, addressCity2.getText());
                hunter2.setString(14, addressBarangay2.getText());

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < contactLists.size(); i++) {
                    sb.append(contactLists.get(i));  // Add the item from the JList to the StringBuilder
                    if (i < contactLists.size() - 1) {
                        sb.append(", ");  // Append a comma and space if it's not the last item
                    }
                }

                String concatenatedItems = sb.toString();

                hunter2.setString(15, concatenatedItems);
//contactLists
                hunter2.executeUpdate();
                StringBuilder yow = new StringBuilder();

                JOptionPane.showMessageDialog(null, "Updated Successfully");
            } else {

//            id = ?, e_mail = ?, contact_number = ?, birth_date = ?, place_of_birth = ?, sex = ?,
//            p_a_region = ?, p_a_province = ?, p_a_city = ?, p_a_barangay = ?, same_as_pa = ?, 
//            c_a_region = ?, c_a_province = ?, c_a_city = ?, c_a_barangay = ?, contact_information = ?
//    
                PreparedStatement hunter2 = setAllConnections.getConHunter().prepareStatement("INSERT INTO personalinformation(id, e_mail, contact_number, birth_date, place_of_birth, sex, p_a_region, p_a_province, p_a_city, p_a_barangay,same_as_pa, c_a_region,c_a_province,  c_a_city, c_a_barangay, contact_information) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                hunter2.setString(1, mainIndex);
                hunter2.setString(2, jEmail.getText());
                hunter2.setString(3, jTextFieldContactNumber.getText());
                hunter2.setString(4, dateOfBirth.getText());
                hunter2.setString(5, PlaceOFBirth.getText());
                hunter2.setString(6, gender);
                hunter2.setString(7, addressRegion.getText());
                hunter2.setString(8, addressProvince.getText());
                hunter2.setString(9, addressCity.getText());
                hunter2.setString(10, addressBarangay.getText());
                hunter2.setInt(11, stateOfCheckBox);
                hunter2.setString(12, addressRegion2.getText());
                hunter2.setString(13, addressProvince2.getText());
                hunter2.setString(14, addressCity2.getText());
                hunter2.setString(15, addressBarangay2.getText());
                hunter2.setString(16, "LATER");
                hunter2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Updated Successfully");

            }

        } catch (Exception e) {
            System.out.println("yea");
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

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        if (jRadioButton5.isSelected()) {
            jButtonSave.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

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

    private void jFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFirstNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jFirstNameFocusGained

    private void jFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFirstNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jFirstNameFocusLost

    private void jFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFirstNameActionPerformed

    private void jMiddleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMiddleNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jMiddleNameFocusGained

    private void jMiddleNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jMiddleNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jMiddleNameFocusLost

    private void jMiddleNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiddleNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMiddleNameActionPerformed

    private void jLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLastNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLastNameFocusGained

    private void jLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLastNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLastNameFocusLost

    private void jLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLastNameActionPerformed

    private void jSuffixFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSuffixFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jSuffixFocusGained

    private void jSuffixFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSuffixFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jSuffixFocusLost

    private void jSuffixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSuffixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSuffixActionPerformed

    private void jEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailFocusGained

    private void jEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jEmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailFocusLost

    private void jEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jEmailActionPerformed

    private void jAgeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jAgeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jAgeFocusGained

    private void jAgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jAgeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jAgeFocusLost

    private void jAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAgeActionPerformed

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
            java.util.logging.Logger.getLogger(HuntersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HuntersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HuntersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HuntersAddInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HuntersAddInformation().setVisible(true);
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
    private javax.swing.JTextField dateOfBirth5;
    private javax.swing.JTextField jAge;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonClearLists;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonResetAll;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFirstName;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLastName;
    private javax.swing.JList<String> jListOfContacts;
    private javax.swing.JTextField jMiddleName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButtonFemale;
    private javax.swing.JRadioButton jRadioButtonMale;
    private javax.swing.JRadioButton jRadioButtonPrefNotSay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSuffix;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextFieldContactNumber;
    // End of variables declaration//GEN-END:variables
}
