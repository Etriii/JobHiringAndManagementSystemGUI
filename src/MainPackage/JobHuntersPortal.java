package MainPackage;

//import Classes.Functions;
//import Classes.AccountForHunter;
//import Classes.AccountForRecruiter;
//import Classes.AccountHolders;
//import Classes.JobsApplied;
import Classes.Functions;
import Classes.setAllConnections;
import JobHunter.JobSemiInfoEdit;
import JobRecruiter.ShowJob;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class JobHuntersPortal extends javax.swing.JFrame {

//    private ArrayList<AccountForHunter> listOfHunters;
    private static String mainIndex;

    public JobHuntersPortal() {
        initComponents();
        setIconImages();
        setAllConnections.setAllConnection();
        setAccount();
    }

    public static void setMainIndex(String smainIndex) {
        mainIndex = smainIndex;
    }

    public JobHuntersPortal(String index) {
        initComponents();
        setAllConnections.setAllConnection();
        setMainIndex(index);

//        listOfHunters = AccountHolders.getListOfHunters();
//        jLabelProfile.setText(listOfHunters.get(index).getFirstName());
//        setJListForRecommendedJobs();
        arrangeDataTableForJobRequests();
//
//
        setIconImages();
        setAccount();
    }

    public void setTableForRecommendedJobs() {
        try {
            DefaultTableModel tab = (DefaultTableModel) jTableRecJob.getModel();
            tab.setRowCount(0);

            PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("SELECT * FROM job_posted");
            ResultSet rs = ps.executeQuery();

            while (true) {
                if (rs.next()) {

                    Object jobName = rs.getString(2);
                    Object jobIndustry = rs.getString(6);
                    Object recruitersID = rs.getString(1);
                    Object jobRecruiters = "";
                    Object monthlySalarys = rs.getString(8);

                    PreparedStatement getRecruitersData = setAllConnections.getConAdmin().prepareStatement("SELECT given_name, family_name FROM recruiters_account WHERE id = " + rs.getString(1));
                    ResultSet nameHolder = getRecruitersData.executeQuery();

                    if (nameHolder.next()) {
                        jobRecruiters = nameHolder.getString(1) + " " + nameHolder.getString(2);
                    }

                    tab.addRow(new Object[]{jobName, jobIndustry, recruitersID, jobRecruiters, monthlySalarys});

                } else {
                    break;
                }

            }

            jTableRecJob.setModel(tab);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setAccount() {

        try {

            setTableForRecommendedJobs();

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT * FROM hunters_account WHERE ID = " + mainIndex);
            ResultSet rs = ps.executeQuery();

            jLabelID.setText("ID - " + mainIndex);

            if (rs.next()) {

                jLabelFullName.setText(rs.getString(5) + " " + rs.getString(6).charAt(0) + ". " + rs.getString(7) + " " + rs.getString(8));
                this.setTitle(rs.getString(5) + " | Employee Panel");

                if (rs.getInt(10) == 1) {
                    jLabelStatus.setText("HIRED - " + rs.getString(11) + " / " + rs.getString(12));
                } else {
                    jLabelStatus.setText("NOT HIRED");
                }

                try {
                    InputStream inputStream = rs.getBinaryStream(14);
                    // Use ImageIO to read the InputStream
                    Image image = ImageIO.read(inputStream);
                    if (image != null) {
                        // Return the ImageIcon
                        jLabelForProfile.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(jLabelForProfile.getWidth(), jLabelForProfile.getHeight(), Image.SCALE_SMOOTH)));
                        jLabelForProfile.setText("");
                    }
                } catch (Exception e) {
                    jLabelForProfile.setIcon(Functions.setIconImage("src\\MainPackage\\profile.jpg", jLabelForProfile.getWidth(), jLabelForProfile.getHeight()));
                    jLabelForProfile.setText("");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

//        jLabelFullName.setText(listOfHunters.get(mainIndex).getLastName() + " " + listOfHunters.get(mainIndex).getFirstName());
//
//        if (listOfHunters.get(mainIndex).getMiddleName() != null) {
//            jLabelFullName.setText(listOfHunters.get(mainIndex).getLastName() + ", " + listOfHunters.get(mainIndex).getFirstName() + " " + listOfHunters.get(mainIndex).getMiddleName().charAt(0) + ".");
//        }
//
//        if (listOfHunters.get(mainIndex).getStatus()) {
//            jLabelStatus.setText("HIRED      JOB NAME: " + listOfHunters.get(mainIndex).getHiredJOb());
//            //e apil kung kinsa iyang employer
//        } else {
//            jLabelStatus.setText("Not Hired");
//        }
//
//        jLabelFullAddress.setText(listOfHunters.get(mainIndex).getFullAddress());
//        jLabelEmailAddress.setText(listOfHunters.get(mainIndex).getEmailAddress());
//        jLabelContactNumber.setText(listOfHunters.get(mainIndex).getContactNumber());
    }

    public void arrangeDataTableForJobRequests() {
        DefaultTableModel table = (DefaultTableModel) jTableForJobRequest.getModel();
        table.setRowCount(0);

//        if (AccountHolders.getHunterByIndex(mainIndex).getJobsApplied().size() > 0) {
//            for (int i = 0; i < AccountHolders.getHunterByIndex(mainIndex).getJobsApplied().size(); i++) {
//
//                Object jobName = AccountHolders.getHunterByIndex(mainIndex).getJobAppliedAtIndex(i).getJobName();
//                Object jobRecruitersName = AccountHolders.getHunterByIndex(mainIndex).getJobAppliedAtIndex(i).getJobsRecrutiersName();
//                Object jobInudstry = AccountHolders.getHunterByIndex(mainIndex).getJobAppliedAtIndex(i).getJobsIndustry();
//                Object jobTimeSent = AccountHolders.getHunterByIndex(mainIndex).getJobAppliedAtIndex(i).getDateSent();
//
//                table.addRow(new Object[]{jobName, jobRecruitersName, jobInudstry, jobTimeSent});
//            }
//
//            jTableForJobRequest.setModel(table);
//        }
        try {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void setJListForRecommendedJobs() {

//        listOfRecommendedJobs = new DefaultComboBoxModel();
//        ArrayList<AccountForRecruiter> listsOfRecruiters = AccountHolders.getLlistOfRecruiters();
//
//        for (int i = 0; i < listsOfRecruiters.size(); i++) {
//            for (int j = 0; j < listsOfRecruiters.get(i).getJobPostedLength(); j++) {
//                if (listsOfRecruiters.get(i).getJobAtIndex(j).getEmployeeNeeded() > 0) {
//                    listOfRecommendedJobs.addElement(listsOfRecruiters.get(i).getJobAtIndex(j).getJobName() + "  /  " + listsOfRecruiters.get(i).getFirstName()
//                            + " / " + listsOfRecruiters.get(i).getJobAtIndex(j).getIndustry());
//                }
//            }
//        }
//        jListRecommendedJob.setModel(listOfRecommendedJobs);
    }

    public void setIconImages() {

//        if (AccountHolders.getHunterByIndex(mainIndex).getProfileImage() == null) {
//            jLabelForProfile.setIcon(Functions.iconImageFit("src\\MainPackage\\profile.jpg", jLabelForProfile.getWidth(), jLabelForProfile.getHeight()));
//            jLabelForProfile.setText("");
//        } else {
//            jLabelForProfile.setIcon(AccountHolders.getHunterByIndex(mainIndex).getProfileImage());
//            jLabelForProfile.setText("");
//        }
//
//        jLabelLogo.setIcon(Functions.iconImageFit("src\\MainPackage\\profile.jpg", jLabelLogo.getWidth(), jLabelLogo.getHeight()));
//        jLabeLogOut.setIcon(Functions.iconImageFit("src\\icons\\accountAdmin.png", jLabeLogOut.getWidth(), jLabeLogOut.getHeight()));
//        jLabeLogOut.setText("");
//        jLabelLogo.setText("");
        jLabelLogo.setIcon(Functions.setIconImage("src\\icons\\yow.png", jLabelLogo.getWidth(), jLabelLogo.getHeight()));
        jLabelLogo.setText("");

        jLabeLogOut.setIcon(Functions.setIconImage("src\\icons\\accountAdmin.png", jLabeLogOut.getWidth(), jLabeLogOut.getHeight()));
        jLabeLogOut.setText("");

    }

    public void checkFirstTime(int index) {
//        if (!listOfHunters.get(index).getStartedFillProfile()) {
//            semiProfileForHunter sp = new semiProfileForHunter(mainIndex);
//            sp.setVisible(true);
//        } else {
//            this.setVisible(true);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPopupMenuForLogOut = new javax.swing.JPopupMenu();
        jMenuItemLogOut = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelProfile = new javax.swing.JLabel();
        jLabelJobSearch = new javax.swing.JLabel();
        jLabelProfileNav = new javax.swing.JLabel();
        jLabelRequest = new javax.swing.JLabel();
        jLabelInvi = new javax.swing.JLabel();
        jSeparatorRequest = new javax.swing.JSeparator();
        jLabeLogOut = new javax.swing.JLabel();
        jSeparatorJobSearch = new javax.swing.JSeparator();
        jSeparatorProfile = new javax.swing.JSeparator();
        jSeparatorInvi = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPaneMain = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTextFieldWhat = new javax.swing.JTextField();
        jTextFieldWhere = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jButtonViewRecommendedJobs = new javax.swing.JButton();
        jButtonViewSavedJobs = new javax.swing.JButton();
        jLabelRefresh = new javax.swing.JLabel();
        jLabelRefresh1 = new javax.swing.JLabel();
        jButtonApplyRecommendedJobs = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRecJob = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabelFullName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabelContactNumber = new javax.swing.JLabel();
        jLabelForProfile = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelFullAddress = new javax.swing.JLabel();
        jLabelEmailAddress = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButtonDeleteAccountRecruiteres = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButtonViewRecruiters = new javax.swing.JButton();
        jLabelRefreshJobRequest = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableForJobRequest = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButtonDeleteAccountRecruiteres1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButtonViewRecruiters1 = new javax.swing.JButton();
        jButtonViewRecruiters2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableForJobRequest1 = new javax.swing.JTable();

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

        jMenuItemLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItemLogOut.setForeground(new java.awt.Color(0, 102, 102));
        jMenuItemLogOut.setText("LOG OUT");
        jMenuItemLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemLogOutMouseClicked(evt);
            }
        });
        jMenuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLogOutActionPerformed(evt);
            }
        });
        jPopupMenuForLogOut.add(jMenuItemLogOut);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1015, 107));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setText("LOGO");
        jPanel1.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 70));

        jLabel2.setFont(new java.awt.Font("Cooper Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Job Blow");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 42, -1, -1));

        jLabelProfile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelProfile.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfile.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelProfile.setText("PROFILE");
        jPanel1.add(jLabelProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 45, 142, -1));

        jLabelJobSearch.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabelJobSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJobSearch.setText("JOB SEARCH");
        jLabelJobSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelJobSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelJobSearchMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelJobSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 44, -1, -1));

        jLabelProfileNav.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabelProfileNav.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProfileNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProfileNav.setText("PROFILE");
        jLabelProfileNav.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelProfileNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProfileNavMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelProfileNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 44, -1, -1));

        jLabelRequest.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabelRequest.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRequest.setText("JOB REQUEST");
        jLabelRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRequestMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 44, -1, -1));

        jLabelInvi.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabelInvi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInvi.setText("JOB INVITATION");
        jLabelInvi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInvi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInviMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelInvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 44, -1, -1));

        jSeparatorRequest.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorRequest.setEnabled(false);
        jSeparatorRequest.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jSeparatorRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, 20));

        jLabeLogOut.setForeground(new java.awt.Color(0, 102, 102));
        jLabeLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeLogOut.setText("Sign");
        jLabeLogOut.setComponentPopupMenu(jPopupMenuForLogOut);
        jLabeLogOut.setOpaque(true);
        jLabeLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabeLogOutMouseClicked(evt);
            }
        });
        jPanel1.add(jLabeLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 40, 40));

        jSeparatorJobSearch.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorJobSearch.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jSeparatorJobSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 100, 20));

        jSeparatorProfile.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorProfile.setEnabled(false);
        jSeparatorProfile.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jSeparatorProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 70, 20));

        jSeparatorInvi.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorInvi.setEnabled(false);
        jSeparatorInvi.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jSeparatorInvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 130, 20));

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(null);

        jTextFieldWhat.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldWhat.setText("Enter Keywords");
        jTextFieldWhat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldWhatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldWhatFocusLost(evt);
            }
        });
        jTextFieldWhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWhatActionPerformed(evt);
            }
        });

        jTextFieldWhere.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldWhere.setText("Enter Province, City, Or Region");
        jTextFieldWhere.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldWhereFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldWhereFocusLost(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any Classification", "Communication and Information technology", "Night Market", "Sa Akong Heart" }));

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("What");

        jLabel5.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Where");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextFieldWhat, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextFieldWhere)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldWhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldWhere, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldWhat, jTextFieldWhere});

        jPanel4.add(jPanel8);
        jPanel8.setBounds(0, 0, 1020, 122);

        jLabel6.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Recommended job");

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Saved job");

        jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(jList4);

        jButtonViewRecommendedJobs.setText("View");
        jButtonViewRecommendedJobs.setEnabled(false);
        jButtonViewRecommendedJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewRecommendedJobsActionPerformed(evt);
            }
        });

        jButtonViewSavedJobs.setText("View");
        jButtonViewSavedJobs.setEnabled(false);

        jLabelRefresh.setForeground(new java.awt.Color(0, 102, 102));
        jLabelRefresh.setText("Refresh");
        jLabelRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefreshMouseClicked(evt);
            }
        });

        jLabelRefresh1.setForeground(new java.awt.Color(0, 102, 102));
        jLabelRefresh1.setText("Refresh");
        jLabelRefresh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButtonApplyRecommendedJobs.setBackground(new java.awt.Color(0, 102, 102));
        jButtonApplyRecommendedJobs.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonApplyRecommendedJobs.setForeground(new java.awt.Color(255, 255, 255));
        jButtonApplyRecommendedJobs.setText("Apply");
        jButtonApplyRecommendedJobs.setEnabled(false);
        jButtonApplyRecommendedJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApplyRecommendedJobsActionPerformed(evt);
            }
        });

        jTableRecJob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Name", "Industry", "Recruiters ID", "Recruiters Name", "Monthly Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRecJob.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRecJob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecJobMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRecJob);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(287, 287, 287)
                        .addComponent(jLabelRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonViewRecommendedJobs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonApplyRecommendedJobs, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRefresh1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonViewSavedJobs)))
                .addGap(30, 30, 30))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonViewSavedJobs)
                    .addComponent(jLabelRefresh1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButtonViewRecommendedJobs)
                    .addComponent(jLabel7)
                    .addComponent(jLabelRefresh)
                    .addComponent(jButtonApplyRecommendedJobs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel9);
        jPanel9.setBounds(0, 130, 1020, 200);

        jTabbedPaneMain.addTab("tab1", jPanel4);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFullName.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabelFullName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFullName.setText("Full name of the Account");
        jPanel11.add(jLabelFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Full Address: ");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact Number:");
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 80, -1));

        jButton3.setText("Delete Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Status:");
        jPanel11.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 57, -1));

        jLabelContactNumber.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelContactNumber.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContactNumber.setText(" ");
        jPanel11.add(jLabelContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 200, -1));

        jLabelForProfile.setForeground(new java.awt.Color(255, 255, 255));
        jLabelForProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelForProfile.setText("2x2");
        jLabelForProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelForProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelForProfileMouseClicked(evt);
            }
        });
        jPanel11.add(jLabelForProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 90));

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setForeground(new java.awt.Color(0, 102, 102));
        jButton11.setText("UPLOAD");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 130, 100, -1));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Email Address: ");
        jPanel11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setText(" ");
        jPanel11.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 480, -1));

        jLabelFullAddress.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelFullAddress.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFullAddress.setText(" ");
        jPanel11.add(jLabelFullAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 280, -1));

        jLabelEmailAddress.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelEmailAddress.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmailAddress.setText(" ");
        jPanel11.add(jLabelEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 240, -1));

        jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelID.setForeground(new java.awt.Color(255, 255, 255));
        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelID.setText("ID - 0");
        jPanel11.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 160, -1));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Personal Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.");

        jButton4.setText("Update Personal Info");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Career History", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.");

        jButton5.setText("Add role");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Education", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel14.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.");

        jButton6.setText("Add education");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Skills", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel15.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.");

        jButton7.setText("Add skills");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "License and Certifications", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel16.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.");

        jButton8.setText("Add license or certifications");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Languages", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.");

        jButton9.setText("Add language");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Résumé", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel18.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor.");

        jButton10.setText("Add resume");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(324, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel10);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        jTabbedPaneMain.addTab("tab2", jPanel5);

        jButtonDeleteAccountRecruiteres.setText("Delete Request");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Job Requests sent ");

        jButtonViewRecruiters.setText("View");

        jLabelRefreshJobRequest.setForeground(new java.awt.Color(0, 102, 102));
        jLabelRefreshJobRequest.setText("Refresh");
        jLabelRefreshJobRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRefreshJobRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefreshJobRequestMouseClicked(evt);
            }
        });

        jTableForJobRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Title", "Industry", "Recruiter", "Date Sent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableForJobRequest.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableForJobRequest.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableForJobRequest);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 428, Short.MAX_VALUE)
                        .addComponent(jButtonViewRecruiters)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteAccountRecruiteres)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelRefreshJobRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jButtonViewRecruiters)
                    .addComponent(jButtonDeleteAccountRecruiteres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRefreshJobRequest)
                .addGap(39, 39, 39))
        );

        jTabbedPaneMain.addTab("tab3", jPanel6);

        jButtonDeleteAccountRecruiteres1.setText("Remove from inbox");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Job Invitations ");

        jButtonViewRecruiters1.setText("View");

        jButtonViewRecruiters2.setText("Accept Invitation");
        jButtonViewRecruiters2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewRecruiters2ActionPerformed(evt);
            }
        });

        jTableForJobRequest1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Title", "Industry", "Recruiter", "Date Sent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableForJobRequest1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableForJobRequest1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableForJobRequest1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                        .addComponent(jButtonViewRecruiters1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonViewRecruiters2)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonDeleteAccountRecruiteres1)
                        .addGap(128, 128, 128))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jButtonViewRecruiters1)
                    .addComponent(jButtonDeleteAccountRecruiteres1)
                    .addComponent(jButtonViewRecruiters2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jTabbedPaneMain.addTab("tab4", jPanel7);

        jPanel3.add(jTabbedPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1020, 400));

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelJobSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelJobSearchMouseClicked
        jTabbedPaneMain.setSelectedIndex(0);
        jSeparatorJobSearch.setEnabled(true);
        jSeparatorProfile.setEnabled(false);
        jSeparatorRequest.setEnabled(false);
        jSeparatorInvi.setEnabled(false);
    }//GEN-LAST:event_jLabelJobSearchMouseClicked

    private void jLabelProfileNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProfileNavMouseClicked
        jTabbedPaneMain.setSelectedIndex(1);
        jSeparatorJobSearch.setEnabled(false);
        jSeparatorProfile.setEnabled(true);
        jSeparatorRequest.setEnabled(false);
        jSeparatorInvi.setEnabled(false);
    }//GEN-LAST:event_jLabelProfileNavMouseClicked

    private void jLabelRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRequestMouseClicked
        jTabbedPaneMain.setSelectedIndex(2);
        jSeparatorJobSearch.setEnabled(false);
        jSeparatorProfile.setEnabled(false);
        jSeparatorRequest.setEnabled(true);
        jSeparatorInvi.setEnabled(false);
    }//GEN-LAST:event_jLabelRequestMouseClicked

    private void jLabelInviMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInviMouseClicked
        jTabbedPaneMain.setSelectedIndex(3);
        jSeparatorJobSearch.setEnabled(false);
        jSeparatorProfile.setEnabled(false);
        jSeparatorRequest.setEnabled(false);
        jSeparatorInvi.setEnabled(true);
    }//GEN-LAST:event_jLabelInviMouseClicked

    private void jTextFieldWhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWhatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldWhatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JobSemiInfoEdit jb = new JobSemiInfoEdit(mainIndex);
        jb.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Account deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (choice == 0) {
                PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT password FROM hunters_account WHERE id = " + mainIndex);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String passwordToCheck = JOptionPane.showInputDialog("TO CONFIRM PLEASE ENTER YOUR PASSWORD");
                    if (passwordToCheck.equals(rs.getString("password"))) {

                        PreparedStatement delAdmin = setAllConnections.getConAdmin().prepareStatement("DELETE FROM hunters_account WHERE id = " + mainIndex);
                        delAdmin.executeUpdate();

                        PreparedStatement delHiredEmployees = setAllConnections.getConAdmin().prepareStatement("DELETE FROM hired_employees WHERE ID = " + mainIndex);
                        delHiredEmployees.executeUpdate();

                        PreparedStatement delPersoInfo = setAllConnections.getConHunter().prepareStatement("DELETE FROM personalinformation WHERE id = " + mainIndex);
                        delPersoInfo.executeUpdate();

//
//                      ang mga gipnag hired nimo, didto mismo sa account nila
                        JOptionPane.showMessageDialog(null, "Account Deleted Successfully.");

                        this.dispose();
                        new MainPanel().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Password is Incorrect Please try Again.");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButtonViewRecruiters2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewRecruiters2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewRecruiters2ActionPerformed

    private void jLabelForProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelForProfileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelForProfileMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose an Image");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {

                File selectedFile = fileChooser.getSelectedFile();

                BufferedImage originalImage = ImageIO.read(selectedFile);
                ImageIcon icon = new ImageIcon(originalImage.getScaledInstance(jLabelForProfile.getWidth(), jLabelForProfile.getHeight(), Image.SCALE_SMOOTH)); // Resize and convert to ImageIcon
//                AccountHolders.getHunterByIndex(mainIndex).setProfileImage(icon);

                jLabelForProfile.setIcon(icon);
                jLabelForProfile.setText("");
                setIconImages();

                try {
                    PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("UPDATE hunters_account SET profile_picture = ? WHERE id = " + mainIndex);
                    InputStream is = new FileInputStream(selectedFile);
                    ps.setBlob(1, is);
                    ps.executeUpdate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading image.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jMenuItemLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemLogOutMouseClicked

    }//GEN-LAST:event_jMenuItemLogOutMouseClicked

    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        this.dispose();
        MainPanel mp = new MainPanel();
        mp.setVisible(true);
    }//GEN-LAST:event_jMenuItemLogOutActionPerformed

    private void jTextFieldWhatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldWhatFocusGained
        if ("Enter Keywords".equals(jTextFieldWhat.getText())) {
            jTextFieldWhat.setText("");
            jTextFieldWhat.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldWhatFocusGained

    private void jTextFieldWhatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldWhatFocusLost
        if ("".equals(jTextFieldWhat.getText())) {
            jTextFieldWhat.setText("Enter Keywords");
            jTextFieldWhat.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextFieldWhatFocusLost

    private void jTextFieldWhereFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldWhereFocusGained
        if ("Enter Province, City, Or Region".equals(jTextFieldWhere.getText())) {
            jTextFieldWhere.setText("");
            jTextFieldWhere.setForeground(Color.black);
        }
    }//GEN-LAST:event_jTextFieldWhereFocusGained

    private void jTextFieldWhereFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldWhereFocusLost
        if ("".equals(jTextFieldWhere.getText())) {
            jTextFieldWhere.setText("Enter Province, City, Or Region");
            jTextFieldWhere.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextFieldWhereFocusLost

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HuntersAddInformation ha = new HuntersAddInformation(mainIndex);
        ha.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefreshMouseClicked
        setTableForRecommendedJobs();

        jButtonViewRecommendedJobs.setEnabled(false);
        jButtonApplyRecommendedJobs.setEnabled(false);
    }//GEN-LAST:event_jLabelRefreshMouseClicked

    private void jButtonViewRecommendedJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewRecommendedJobsActionPerformed

        String jobName = jTableRecJob.getValueAt(jTableRecJob.getSelectedRow(), 0).toString();
        new ShowJob(jobName).setVisible(true);

        jButtonViewRecommendedJobs.setEnabled(false);
        jButtonApplyRecommendedJobs.setEnabled(false);
        jTableRecJob.clearSelection();

    }//GEN-LAST:event_jButtonViewRecommendedJobsActionPerformed

    private void jButtonApplyRecommendedJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApplyRecommendedJobsActionPerformed
        try {

            String c1 = mainIndex;
            String c2 = String.valueOf(jTableRecJob.getValueAt(jTableRecJob.getSelectedRow(), 0));
            String c3 = String.valueOf(jTableRecJob.getValueAt(jTableRecJob.getSelectedRow(), 1));
            String c4 = String.valueOf(jTableRecJob.getValueAt(jTableRecJob.getSelectedRow(), 2));

            PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("SELECT id FROM job_requests WHERE id = ? AND job_name = ? AND job_industry = ? AND recruiters_id = ?");
            ps.setString(1, c1);
            ps.setString(2, c2);
            ps.setString(3, c3);
            ps.setString(4, c4);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "You can only apply once in the same job", "error", JOptionPane.ERROR_MESSAGE);
            } else {
                PreparedStatement ps2 = setAllConnections.getConRecruiter().prepareStatement("INSERT INTO job_requests VALUES(?, ?, ?, ?, DEFAULT)");
                ps2.setString(1, c1);
                ps2.setString(2, c2);
                ps2.setString(3, c3);
                ps2.setString(4, c4);

                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, "You have applied for this job Successfully");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jButtonApplyRecommendedJobsActionPerformed

    private void jLabelRefreshJobRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefreshJobRequestMouseClicked
        arrangeDataTableForJobRequests();
    }//GEN-LAST:event_jLabelRefreshJobRequestMouseClicked

    private void jLabeLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabeLogOutMouseClicked

    }//GEN-LAST:event_jLabeLogOutMouseClicked

    private void jTableRecJobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecJobMouseClicked
        if (jTableRecJob.getRowCount() == 0) {
            jButtonViewRecommendedJobs.setEnabled(false);
            jButtonApplyRecommendedJobs.setEnabled(false);
        } else {
            jButtonViewRecommendedJobs.setEnabled(true);
            jButtonApplyRecommendedJobs.setEnabled(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableRecJobMouseClicked

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
            java.util.logging.Logger.getLogger(JobHuntersPortal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobHuntersPortal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobHuntersPortal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobHuntersPortal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobHuntersPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonApplyRecommendedJobs;
    private javax.swing.JButton jButtonDeleteAccountRecruiteres;
    private javax.swing.JButton jButtonDeleteAccountRecruiteres1;
    private javax.swing.JButton jButtonViewRecommendedJobs;
    private javax.swing.JButton jButtonViewRecruiters;
    private javax.swing.JButton jButtonViewRecruiters1;
    private javax.swing.JButton jButtonViewRecruiters2;
    private javax.swing.JButton jButtonViewSavedJobs;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabeLogOut;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelContactNumber;
    private javax.swing.JLabel jLabelEmailAddress;
    private javax.swing.JLabel jLabelForProfile;
    private javax.swing.JLabel jLabelFullAddress;
    private javax.swing.JLabel jLabelFullName;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInvi;
    private javax.swing.JLabel jLabelJobSearch;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelProfile;
    private javax.swing.JLabel jLabelProfileNav;
    private javax.swing.JLabel jLabelRefresh;
    private javax.swing.JLabel jLabelRefresh1;
    private javax.swing.JLabel jLabelRefreshJobRequest;
    private javax.swing.JLabel jLabelRequest;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JList<String> jList4;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenuForLogOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparatorInvi;
    private javax.swing.JSeparator jSeparatorJobSearch;
    private javax.swing.JSeparator jSeparatorProfile;
    private javax.swing.JSeparator jSeparatorRequest;
    private javax.swing.JTabbedPane jTabbedPaneMain;
    private javax.swing.JTable jTableForJobRequest;
    private javax.swing.JTable jTableForJobRequest1;
    private javax.swing.JTable jTableRecJob;
    private javax.swing.JTextField jTextFieldWhat;
    private javax.swing.JTextField jTextFieldWhere;
    // End of variables declaration//GEN-END:variables
}

// butangangag  progress bar sa profile
