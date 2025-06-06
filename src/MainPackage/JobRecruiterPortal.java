package MainPackage;

import AdminsView.ViewHunter;
import Classes.Functions;
import Classes.setAllConnections;
import JobRecruiter.CheckJobToPost;
import JobRecruiter.SemiInfoEditRecruiter;
//import Classes.AccountForHunter;
//import Classes.AccountHolders;
//import Classes.AccountForRecruiter;
//import Classes.Functions;
import JobRecruiter.ShowJob;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JobRecruiterPortal extends javax.swing.JFrame {

//    private ArrayList<AccountForRecruiter> listOfRecruiters;
    private static String mainIndex;

    public JobRecruiterPortal() {
        initComponents();
        setAllConnections.setAllConnection();
        setAccount();

    }

    public JobRecruiterPortal(String index) {
//        listOfRecruiters = AccountHolders.getLlistOfRecruiters();
//        setMainIndex(index);
//        this.setTitle(listOfRecruiters.get(index).getFirstName() + " | Recruiters Panel");
//        setIconImages();
//        jLabelProfile.setText(listOfRecruiters.get(index).getFirstName());
//        setTablesForJobPosted();
//        setTableOfJobRequest();

        initComponents();
        mainIndex = index;
        setAccount();
    }

    public void setAccount() {

        setTablesForJobPosted();
        setTableOfJobRequest();

//        jLabelRemainingPost.setText("REMAINING POST: " + listOfRecruiters.get(mainIndex).getJobPostRemaining());
//
//        jLabelFullName.setText(listOfRecruiters.get(mainIndex).getLastName() + " " + listOfRecruiters.get(mainIndex).getFirstName());
//
//        if (listOfRecruiters.get(mainIndex).getMiddleName() != null) {
//            jLabelFullName.setText(listOfRecruiters.get(mainIndex).getLastName() + ", " + listOfRecruiters.get(mainIndex).getFirstName() + " " + listOfRecruiters.get(mainIndex).getMiddleName().charAt(0) + ".");
//        }
//
//        jLabelFullAddress.setText(listOfRecruiters.get(mainIndex).getCompleteAddress());
//        jLabelEmailAddress.setText(listOfRecruiters.get(mainIndex).getEmailAddress());
//        jLabelContactNumber.setText(listOfRecruiters.get(mainIndex).getContactNumber());
//        jLabelBusinessName.setText(listOfRecruiters.get(mainIndex).getbName());
        try {

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT * FROM recruiters_account WHERE id = " + mainIndex);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                jLabelRemainingPost.setText("REMAINING POST: " + rs.getInt(12));
                jLabelFullName.setText(rs.getString(6) + ", " + rs.getString(5));
                jLabelID.setText("ID - " + rs.getString(1));
                jLabelFullAddress.setText(rs.getString(10));
                jLabelEmailAddress.setText(rs.getString(7));
                jLabelContactNumber.setText(rs.getString(9));
                jLabelBusinessName.setText(rs.getString(8));

                try {
                    InputStream inputStream = rs.getBinaryStream(11);
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

        setIcons();
    }

    public void setTablesForJobPosted() {

        try {
            PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("SELECT * FROM job_posted WHERE id = " + mainIndex);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel jTable = (DefaultTableModel) jTableForJobPosted.getModel();
            jTable.setRowCount(0);

            String rowCountHired;

            while (true) {
                if (rs.next()) {

                    Object industry = rs.getString(6);
                    Object jobName = rs.getString(2);
                    Object remaining_slot = rs.getString(7);

                    PreparedStatement checkHiredRowCount = setAllConnections.getConAdmin().prepareStatement("SELECT COUNT(*) AS rowcount FROM hired_employees WHERE recruiters_id = ? AND job_name = ?");
                    checkHiredRowCount.setInt(1, Integer.parseInt(mainIndex));
                    checkHiredRowCount.setString(2, jobName.toString());

                    ResultSet rowCount = checkHiredRowCount.executeQuery();

                    if (rowCount.next()) {
                        rowCountHired = rowCount.getString("rowcount");
                    } else {
                        rowCountHired = "0";
                    }

                    Object hired_hunters = rowCountHired;

                    jTable.addRow((new Object[]{industry, jobName, hired_hunters, remaining_slot}));

                } else {
                    break;
                }
            }

            jTableForJobPosted.setModel(jTable);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setIcons() {
        jLabeLogOut.setIcon(Functions.setIconImage("src\\icons\\accountAdmin.png", jLabeLogOut.getWidth(), jLabeLogOut.getHeight()));
        jLabeLogOut.setText("");

        jLabelLogo.setIcon(Functions.setIconImage("src\\icons\\yow.png", jLabelLogo.getWidth(), jLabelLogo.getHeight()));
        jLabelLogo.setText("");
    }

    public void setIconImages() {

//        if (AccountHolders.getRecruiterByIndex(mainIndex).getProfileImage() == null) {
//            jLabelForProfile.setIcon(Functions.iconImageFit("src\\MainPackage\\profile.jpg", jLabelForProfile.getWidth(), jLabelForProfile.getHeight()));
//            jLabelForProfile.setText("");
//        } else {
//            jLabelForProfile.setIcon(AccountHolders.getRecruiterByIndex(mainIndex).getProfileImage());
//            jLabelForProfile.setText("");
//        }
//
//        jLabelLogo.setIcon(Functions.iconImageFit("src\\MainPackage\\profile.jpg", jLabelLogo.getWidth(), jLabelLogo.getHeight()));
//        jLabeLogOut.setIcon(Functions.iconImageFit("src\\icons\\accountAdmin.png", jLabeLogOut.getWidth(), jLabeLogOut.getHeight()));
//        jLabeLogOut.setText("");
//        jLabelLogo.setText("");
    }

    public void setTableOfJobRequest() {

        try {
            DefaultTableModel model = (DefaultTableModel) jTableForJobRequest.getModel();
            model.setRowCount(0);

            try {
                PreparedStatement getDataFromJobReq = setAllConnections.getConRecruiter().prepareStatement("SELECT * FROM job_requests WHERE recruiters_id = ?");
                getDataFromJobReq.setString(1, mainIndex);
                ResultSet rsDataFromJRequests = getDataFromJobReq.executeQuery();

                while (true) {
                    if (rsDataFromJRequests.next()) {

                        PreparedStatement check = setAllConnections.getConAdmin().prepareStatement("SELECT status FROM hunters_account WHERE id = ?");
                        check.setString(1, rsDataFromJRequests.getString(1));
                        ResultSet stat = check.executeQuery();

                        if (stat.next()) {
                            if (stat.getInt("status") == 1) {

                            } else {
                                String c1 = rsDataFromJRequests.getString(2);
                                String c2 = rsDataFromJRequests.getString(3);
                                String c3 = rsDataFromJRequests.getString(1);
                                String c4 = rsDataFromJRequests.getString(5);

                                model.addRow(new Object[]{c1, c2, c3, c4});
                            }
                        }

                    } else {
                        break;
                    }
                }

                jTableForJobRequest.setModel(model);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            jTableForJobRequest.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void checkFirstTime(int index) {
//        if (!listOfRecruiters.get(index).getStartedFillProfile()) {
//            semiProfileForRecruiter sp = new semiProfileForRecruiter(mainIndex);
//            sp.setVisible(true);
//        } else {
//            this.setVisible(true);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuForLogOut = new javax.swing.JPopupMenu();
        jMenuItemLogOut = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelProfile = new javax.swing.JLabel();
        jLabeLogOut = new javax.swing.JLabel();
        jLabelJobSearch = new javax.swing.JLabel();
        jLabelProfileNav = new javax.swing.JLabel();
        jLabelRequest = new javax.swing.JLabel();
        jLabelInvi = new javax.swing.JLabel();
        jSeparatorRequest = new javax.swing.JSeparator();
        jSeparatorJobSearch = new javax.swing.JSeparator();
        jSeparatorProfile = new javax.swing.JSeparator();
        jSeparatorInvi = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPaneMain = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabelRemainingPost = new javax.swing.JLabel();
        jButtonPostAJob = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableForJobPosted = new javax.swing.JTable();
        jButtonDeleteJob = new javax.swing.JButton();
        jButtonViewJob = new javax.swing.JButton();
        jLabelRefresh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabelFullName = new javax.swing.JLabel();
        jLabelFA = new javax.swing.JLabel();
        jLabelBN = new javax.swing.JLabel();
        jButtonEdit = new javax.swing.JButton();
        jButtonDeleteAccount = new javax.swing.JButton();
        jLabelContactNumber = new javax.swing.JLabel();
        jLabelForProfile = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabelEA = new javax.swing.JLabel();
        jLabelBusinessName = new javax.swing.JLabel();
        jLabelFullAddress = new javax.swing.JLabel();
        jLabelEmailAddress = new javax.swing.JLabel();
        jLabelCN = new javax.swing.JLabel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableForJobInvitation = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jButtonDeleteAccountRecruiteres1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButtonViewRecruiters1 = new javax.swing.JButton();
        jButtonViewRecruiters2 = new javax.swing.JButton();
        jLabelRefreshJobRequest = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableForJobRequest = new javax.swing.JTable();

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

        jLabeLogOut.setBackground(new java.awt.Color(255, 255, 255));
        jLabeLogOut.setForeground(new java.awt.Color(0, 102, 102));
        jLabeLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeLogOut.setText("SIGN OUT");
        jLabeLogOut.setComponentPopupMenu(jPopupMenuForLogOut);
        jLabeLogOut.setOpaque(true);
        jLabeLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabeLogOutMouseClicked(evt);
            }
        });
        jPanel1.add(jLabeLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 40, 40, 40));

        jLabelJobSearch.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabelJobSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJobSearch.setText("POST JOBS");
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
        jLabelRequest.setText("JOB INVITATION");
        jLabelRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRequestMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 44, -1, -1));

        jLabelInvi.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabelInvi.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInvi.setText("JOB REQUEST");
        jLabelInvi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInvi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInviMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelInvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 44, 110, -1));

        jSeparatorRequest.setBackground(new java.awt.Color(0, 0, 0));
        jSeparatorRequest.setEnabled(false);
        jSeparatorRequest.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jSeparatorRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 120, 20));

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
        jPanel1.add(jSeparatorInvi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 110, 20));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRemainingPost.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabelRemainingPost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRemainingPost.setText("REMAINING POST: 0");

        jButtonPostAJob.setBackground(new java.awt.Color(0, 102, 102));
        jButtonPostAJob.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPostAJob.setText("POST A JOB ");
        jButtonPostAJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPostAJobActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Jobs Posted");

        jTableForJobPosted.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Industry", "Job Name", "Hired Hunters", "Remaning Slot"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableForJobPosted.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableForJobPosted.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableForJobPosted);

        jButtonDeleteJob.setForeground(new java.awt.Color(204, 0, 0));
        jButtonDeleteJob.setText("DELETE");

        jButtonViewJob.setText("View");
        jButtonViewJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewJobActionPerformed(evt);
            }
        });

        jLabelRefresh.setForeground(new java.awt.Color(0, 102, 102));
        jLabelRefresh.setText("Refresh");
        jLabelRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRefreshMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelRemainingPost, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonPostAJob, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonViewJob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteJob))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelRemainingPost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteJob)
                    .addComponent(jButtonViewJob)
                    .addComponent(jButtonPostAJob))
                .addContainerGap())
        );

        jTabbedPaneMain.addTab("tab1", jPanel4);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelFullName.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabelFullName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFullName.setText("Full name of the Account");
        jPanel11.add(jLabelFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabelFA.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFA.setText("Full Address: ");
        jPanel11.add(jLabelFA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabelBN.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBN.setText("Business Name:");
        jPanel11.add(jLabelBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 80, -1));

        jButtonDeleteAccount.setText("Delete Account");
        jButtonDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccountActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonDeleteAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, -1));

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

        jLabelEA.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEA.setText("Email Address: ");
        jPanel11.add(jLabelEA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        jLabelBusinessName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelBusinessName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBusinessName.setText(" ");
        jPanel11.add(jLabelBusinessName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 230, -1));

        jLabelFullAddress.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelFullAddress.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFullAddress.setText(" ");
        jPanel11.add(jLabelFullAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 380, -1));

        jLabelEmailAddress.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelEmailAddress.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEmailAddress.setText(" ");
        jPanel11.add(jLabelEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 360, -1));

        jLabelCN.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCN.setText("Contact Number:");
        jPanel11.add(jLabelCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
        );

        jTabbedPaneMain.addTab("tab2", jPanel5);

        jButtonDeleteAccountRecruiteres.setText("Delete Invitation");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Job Invitation sent ");

        jButtonViewRecruiters.setText("View");

        jTableForJobInvitation.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableForJobInvitation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableForJobInvitation.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableForJobInvitation);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                        .addComponent(jButtonViewRecruiters)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteAccountRecruiteres)))
                .addGap(128, 128, 128))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jButtonViewRecruiters)
                    .addComponent(jButtonDeleteAccountRecruiteres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPaneMain.addTab("tab3", jPanel6);

        jButtonDeleteAccountRecruiteres1.setText("Remove from inbox");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Job Requests ");

        jButtonViewRecruiters1.setText("View");
        jButtonViewRecruiters1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewRecruiters1ActionPerformed(evt);
            }
        });

        jButtonViewRecruiters2.setText("Accept Request");
        jButtonViewRecruiters2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewRecruiters2ActionPerformed(evt);
            }
        });

        jLabelRefreshJobRequest.setForeground(new java.awt.Color(0, 102, 102));
        jLabelRefreshJobRequest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
                "Job Title", "Industry", "Employee IDs", "Date Sent"
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRefreshJobRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                        .addComponent(jButtonViewRecruiters1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonViewRecruiters2)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonDeleteAccountRecruiteres1)))
                .addGap(128, 128, 128))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelRefreshJobRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        jTabbedPaneMain.addTab("tab4", jPanel7);

        jPanel3.add(jTabbedPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1020, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 393, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 119, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 12, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabeLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabeLogOutMouseClicked

    }//GEN-LAST:event_jLabeLogOutMouseClicked

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

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed

        SemiInfoEditRecruiter sr = new SemiInfoEditRecruiter(mainIndex);
        sr.setVisible(true);

    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccountActionPerformed
        try {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Account deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (choice == 0) {
                PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT password FROM recruiters_account WHERE id = " + mainIndex);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String passwordToCheck = JOptionPane.showInputDialog("TO CONFIRM PLEASE ENTER YOUR PASSWORD");
                    if (passwordToCheck.equals(rs.getString("password"))) {

//                        PreparedStatement delAdmin = setAllConnections.getConAdmin().prepareStatement("DELETE FROM recruiters_account WHERE id = " + mainIndex);
//                        delAdmin.executeUpdate();
//
//                        PreparedStatement delJobPosted = setAllConnections.getConRecruiter().prepareStatement("DELETE FROM job_posted WHERE id = " + mainIndex);
//                        delJobPosted.executeUpdate();
//
//                        PreparedStatement delPersoInfo = setAllConnections.getConRecruiter().prepareStatement("DELETE FROM personalinformation WHERE id = " + mainIndex);
//                        delPersoInfo.executeUpdate();
//
//                        PreparedStatement delHiredEmployees = setAllConnections.getConAdmin().prepareStatement("DELETE FROM hired_employees WHERE recruiters_id = " + mainIndex);
//                        delHiredEmployees.executeUpdate();
//
//                        PreparedStatement removeHiredInHunter = setAllConnections.getConAdmin().prepareStatement("UPDATE hunters_account SET status = 0, job_hired = DEFAULT, job_industry = DEFAULT, recruiter_id = DEFAULT WHERE recruiter_id = " + mainIndex);
//                        removeHiredInHunter.executeUpdate();
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
    }//GEN-LAST:event_jButtonDeleteAccountActionPerformed

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
//              
                jLabelForProfile.setIcon(icon);
                jLabelForProfile.setText("");

                try {
                    PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("UPDATE recruiters_account SET profile_picture = ? WHERE id = " + mainIndex);
                    InputStream is = new FileInputStream(selectedFile);
                    ps.setBlob(1, is);
                    ps.executeUpdate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

                setIconImages();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading image.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        RecruitersAddInformation ha = new RecruitersAddInformation(mainIndex);
        ha.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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

        try {

            String idOfEmployee = jTableForJobRequest.getValueAt(jTableForJobRequest.getSelectedRow(), 2).toString();
            String jobHired = jTableForJobRequest.getValueAt(jTableForJobRequest.getSelectedRow(), 0).toString();
            String jobIndustry = jTableForJobRequest.getValueAt(jTableForJobRequest.getSelectedRow(), 1).toString();

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("UPDATE hunters_account SET status = ?, job_hired = ?, job_industry = ?, recruiter_id = ? WHERE id = ? ");
            ps.setInt(1, 1);
            ps.setString(2, jobHired);
            ps.setString(3, jobIndustry);
            ps.setString(4, mainIndex);
            ps.setString(5, idOfEmployee);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "This hunter is Now Employee :)");

            setTableOfJobRequest();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jButtonViewRecruiters2ActionPerformed

    private void jMenuItemLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemLogOutMouseClicked

    }//GEN-LAST:event_jMenuItemLogOutMouseClicked

    private void jMenuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLogOutActionPerformed
        this.dispose();
        MainPanel mp = new MainPanel();
        mp.setVisible(true);
    }//GEN-LAST:event_jMenuItemLogOutActionPerformed

    private void jButtonPostAJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPostAJobActionPerformed

//        if (listOfRecruiters.get(mainIndex).getJobPostRemaining() == 0) {
//            JOptionPane.showMessageDialog(this, "You Have used All of your chances to Post a Job");
//            int choice = JOptionPane.showConfirmDialog(this, "Pay 100 Pesos to add 2 chances to Post");
//            jLabelRemainingPost.setText("REMAINING POST: " + listOfRecruiters.get(mainIndex).getJobPostRemaining());
//            if (choice == 0) {
//                AccountHolders.getRecruiterByIndex(mainIndex).addJobPostRemaining(2);
//            }
//        } else {
//            CheckJobToPost checkJobToPost = new CheckJobToPost(mainIndex);
//            checkJobToPost.setVisible(true);
//        }
        try {
            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT remaining_post FROM recruiters_account WHERE id = " + mainIndex);
            ResultSet rem_post = ps.executeQuery();
            if (rem_post.next()) {
                if (rem_post.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(this, "You Have used All of your chances to Post a Job", "Insufficient post chance", JOptionPane.ERROR_MESSAGE);
                    int choice = JOptionPane.showConfirmDialog(this, "Pay 100 Pesos to add 2 chances to Post", "Payment", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (choice == 0) {
                        PreparedStatement addJobPostRemaining = setAllConnections.getConAdmin().prepareStatement("UPDATE recruiters_account SET remaining_post = 2 WHERE id = " + mainIndex);
                        addJobPostRemaining.executeUpdate();
                        ResultSet getRem_Post = ps.executeQuery();
                        if (getRem_Post.next()) {
                            jLabelRemainingPost.setText("REMAINING POST: " + getRem_Post.getInt(1));
                        }
                    }
//            }
                } else {
                    CheckJobToPost jtp = new CheckJobToPost(mainIndex, jLabelRemainingPost.getText().replaceAll("REMAINING POST: ", ""));
                    jtp.setVisible(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButtonPostAJobActionPerformed

    private void jLabelRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefreshMouseClicked
        setTablesForJobPosted();
        setAccount();

//        jLabelRemainingPost.setText("REMAINING POST: " + listOfRecruiters.get(mainIndex).getJobPostRemaining());
    }//GEN-LAST:event_jLabelRefreshMouseClicked

    private void jButtonViewJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewJobActionPerformed
        if (jTableForJobPosted.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Select A Job To View First");
        } else {
//            ShowJob showJob = new ShowJob(mainIndex, jTableForJobPosted.getSelectedRow());
//            showJob.setVisible(true);
        }
    }//GEN-LAST:event_jButtonViewJobActionPerformed

    private void jLabelRefreshJobRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRefreshJobRequestMouseClicked
        setTableOfJobRequest();
    }//GEN-LAST:event_jLabelRefreshJobRequestMouseClicked

    private void jButtonViewRecruiters1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewRecruiters1ActionPerformed

//        String[] split = jTableForJobRequest.getValueAt(jTableForJobRequest.getSelectedRow(), 2).toString().split(", ");
//
//        String LastName = split[0];
//        String FirstName = split[1].replaceAll("\\s+", "");
//        int index = -1;
////        for (int i = 0; i < AccountHolders.getListOfHunters().size(); i++) {
////            if (FirstName.equals(AccountHolders.getHunterByIndex(i).getFirstName()) && LastName.equals(AccountHolders.getHunterByIndex(i).getLastName())) {
////                index = i;
////                break;
////            }
////        }
//
//        if (index != -1) {
//            ViewHunter vh = new ViewHunter(index);
//            vh.setVisible(true);
//        }

    }//GEN-LAST:event_jButtonViewRecruiters1ActionPerformed

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
            java.util.logging.Logger.getLogger(JobRecruiterPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JobRecruiterPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JobRecruiterPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JobRecruiterPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobRecruiterPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonDeleteAccount;
    private javax.swing.JButton jButtonDeleteAccountRecruiteres;
    private javax.swing.JButton jButtonDeleteAccountRecruiteres1;
    private javax.swing.JButton jButtonDeleteJob;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonPostAJob;
    private javax.swing.JButton jButtonViewJob;
    private javax.swing.JButton jButtonViewRecruiters;
    private javax.swing.JButton jButtonViewRecruiters1;
    private javax.swing.JButton jButtonViewRecruiters2;
    private javax.swing.JLabel jLabeLogOut;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelBN;
    private javax.swing.JLabel jLabelBusinessName;
    private javax.swing.JLabel jLabelCN;
    private javax.swing.JLabel jLabelContactNumber;
    private javax.swing.JLabel jLabelEA;
    private javax.swing.JLabel jLabelEmailAddress;
    private javax.swing.JLabel jLabelFA;
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
    private javax.swing.JLabel jLabelRefreshJobRequest;
    private javax.swing.JLabel jLabelRemainingPost;
    private javax.swing.JLabel jLabelRequest;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenuForLogOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparatorInvi;
    private javax.swing.JSeparator jSeparatorJobSearch;
    private javax.swing.JSeparator jSeparatorProfile;
    private javax.swing.JSeparator jSeparatorRequest;
    private javax.swing.JTabbedPane jTabbedPaneMain;
    private javax.swing.JTable jTableForJobInvitation;
    private javax.swing.JTable jTableForJobPosted;
    private javax.swing.JTable jTableForJobRequest;
    // End of variables declaration//GEN-END:variables
}
