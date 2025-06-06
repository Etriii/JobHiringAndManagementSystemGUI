package MainPackage;

import AdminsView.*;
import Classes.setAllConnections;
import JobRecruiter.ShowJob;
//import Classes.AccountForHunter;
//import Classes.AccountHolders;
//import Classes.AccountForRecruiter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class AdministratorPortal extends javax.swing.JFrame {

//    private ArrayList<AccountForHunter> hunters = AccountHolders.getListOfHunters();
//    private ArrayList<AccountForRecruiter> recruiters = AccountHolders.getLlistOfRecruiters();
    private DefaultComboBoxModel listOFHunters = new DefaultComboBoxModel();
    private DefaultComboBoxModel listOFRecruiters = new DefaultComboBoxModel();

    public AdministratorPortal() {
        initComponents();
        setAllConnections.setAllConnection();
        this.setTitle("Administrators Portal");
        ImageIcon ic = new ImageIcon("src\\profile.jpg");
        this.setIconImage(ic.getImage());
        setImageIconForLabels();
        setAllList();
        jButtonHome.doClick();
    }

    public void setAllList() {

        DefaultTableModel tableHunter = (DefaultTableModel) jTableListOfHunters.getModel();
        tableHunter.setRowCount(0);

        DefaultTableModel tableRecruiter = (DefaultTableModel) jTableRecruiter.getModel();
        tableRecruiter.setRowCount(0);

        DefaultTableModel tableJobLists = (DefaultTableModel) jTableListOfJobs.getModel();
        tableJobLists.setRowCount(0);

        try {
            PreparedStatement psHunter = setAllConnections.getConAdmin().prepareStatement("SELECT * FROM hunters_account");
            ResultSet rsHunter = psHunter.executeQuery();

            while (true) {
                if (rsHunter.next()) {
                    tableHunter.addRow(new Object[]{rsHunter.getString(1), rsHunter.getString(5), rsHunter.getString(6), rsHunter.getString(7)});
                } else {
                    break;
                }
            }

            jTableListOfHunters.setModel(tableHunter);

//            
            PreparedStatement psRecruiter = setAllConnections.getConAdmin().prepareStatement("SELECT * FROM recruiters_account");
            ResultSet rsRecruiter = psRecruiter.executeQuery();

            while (true) {
                if (rsRecruiter.next()) {
                    tableRecruiter.addRow(new Object[]{rsRecruiter.getString(1), rsRecruiter.getString(5), rsRecruiter.getString(6), rsRecruiter.getString(8)});
                } else {
                    break;
                }
            }

            jTableRecruiter.setModel(tableRecruiter);

//            
            PreparedStatement psJobLists = setAllConnections.getConRecruiter().prepareStatement("SELECT * FROM job_posted");
            ResultSet rsJobLists = psJobLists.executeQuery();

            while (true) {
                if (rsJobLists.next()) {

                    PreparedStatement hiredCount = setAllConnections.getConAdmin().prepareStatement("SELECT COUNT(*) AS total FROM hired_employees WHERE job_name = ?");
                    hiredCount.setString(1, rsJobLists.getString(2));
                    ResultSet rsGetHiredCount = hiredCount.executeQuery();

                    Object total = "0";

                    if (rsGetHiredCount.next()) {
                        total = rsGetHiredCount.getString("total");
                    }

                    tableJobLists.addRow(new Object[]{rsJobLists.getString(2), rsJobLists.getString(6), rsJobLists.getString(1), total, rsJobLists.getString(7), rsJobLists.getString(8)});
                } else {
                    break;
                }
            }

            jTableListOfJobs.setModel(tableJobLists);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

//        for (AccountForHunter hunter : hunters) {
//            listOFHunters.addElement("USERNAME: " + hunter.getUsername() + "          PASSWORD: " + hunter.getPassword());
//        }
//        jListOfHunters.setModel(listOFHunters);
//
//        for (AccountForRecruiter rec : recruiters) {
//            listOFRecruiters.addElement("USERNAME: " + rec.getUsername() + "          PASSWORD: " + rec.getPassword());
//        }
//        jListOfRecruiters.setModel(listOFRecruiters);
//
//        if (hunters.size() == 0) {
//            jListOfHunters.setEnabled(false);
//            jButtonView.setEnabled(false);
//            jButtonDeleteAccount.setEnabled(false);
//        }
//
//        if (recruiters.size() == 0) {
//            jListOfRecruiters.setEnabled(false);
//            jButtonViewRecruiters.setEnabled(false);
//            jButtonDeleteAccountRecruiteres.setEnabled(false);
//        }
        if (jTableListOfJobs.getModel().getRowCount() == 0) {
            jTableListOfJobs.setEnabled(false);
            jButtonViewListOfJobs.setEnabled(false);
            jButtonDeleteJobs.setEnabled(false);
        }

    }

    public void setImageIconForLabels() {

        ImageIcon imgIcon = new ImageIcon("src\\MainPackage\\profile.jpg");
        ImageIcon iconForNav = new ImageIcon("src\\icons\\x.jpg");
        ImageIcon iconForAdminHome = new ImageIcon("src\\icons\\adminBackgorundpng.png");
        ImageIcon iconForAdminRight = new ImageIcon("src\\icons\\accountAdmin.png");

        jAdminIcon.setIcon(scaleImg(imgIcon.getImage(), jAdminIcon.getWidth(), jAdminIcon.getHeight()));
        JIconAccount.setIcon(scaleImg(imgIcon.getImage(), JIconAccount.getWidth(), JIconAccount.getHeight()));
        JIconNavBar.setIcon(scaleImg(iconForNav.getImage(), JIconNavBar.getWidth(), JIconNavBar.getHeight()));
        jLabelHomeIcon.setIcon(scaleImg(iconForAdminHome.getImage(), jLabelHomeIcon.getWidth(), jLabelHomeIcon.getHeight()));
        JIconAccount.setIcon(scaleImg(iconForAdminRight.getImage(), JIconAccount.getWidth(), JIconAccount.getHeight()));
        jAdminIcon.setText("");
    }

    public ImageIcon scaleImg(Image img, int width, int height) {
        ImageIcon imgIconForAdmin = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
        return imgIconForAdmin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanelHeading = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jAdminIcon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JIconAccount = new javax.swing.JLabel();
        jPanelMainPanel = new javax.swing.JPanel();
        jPanelNav = new javax.swing.JPanel();
        jButtonHunter = new javax.swing.JButton();
        jButtonRec = new javax.swing.JButton();
        jButtonJobs = new javax.swing.JButton();
        jButtonScan = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButtonHome = new javax.swing.JButton();
        jPanelContent = new javax.swing.JPanel();
        JIconNavBar = new javax.swing.JLabel();
        jTabbedPaneMain2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabelHomeIcon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonView = new javax.swing.JButton();
        jButtonDeleteAccount = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableListOfHunters = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButtonDeleteAccountRecruiteres = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonViewRecruiters = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableRecruiter = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jButtonDeleteJobs = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonViewListOfJobs = new javax.swing.JButton();
        jComboBoxSort = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableListOfJobs = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();

        jButton6.setText("jButton1");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanelHeading.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMINISTRATOR | JOB HIRING AND MANAGEMENT SYSTEM");

        jAdminIcon.setBackground(new java.awt.Color(255, 255, 255));
        jAdminIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jAdminIcon.setText(" ");
        jAdminIcon.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JIconAccount.setText(" ");

        javax.swing.GroupLayout jPanelHeadingLayout = new javax.swing.GroupLayout(jPanelHeading);
        jPanelHeading.setLayout(jPanelHeadingLayout);
        jPanelHeadingLayout.setHorizontalGroup(
            jPanelHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeadingLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jAdminIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                .addComponent(JIconAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(24, 24, 24))
        );
        jPanelHeadingLayout.setVerticalGroup(
            jPanelHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeadingLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanelHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jAdminIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(JIconAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelMainPanel.setBackground(new java.awt.Color(0, 102, 102));

        jPanelNav.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNav.setPreferredSize(new java.awt.Dimension(246, 355));

        jButtonHunter.setText("List of Job Hunters");
        jButtonHunter.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonHunter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonHunterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonHunterMouseExited(evt);
            }
        });
        jButtonHunter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHunterActionPerformed(evt);
            }
        });

        jButtonRec.setText("List of Job Recruiter");
        jButtonRec.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonRec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRecMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRecMouseExited(evt);
            }
        });
        jButtonRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecActionPerformed(evt);
            }
        });

        jButtonJobs.setText("List of Published Jobs");
        jButtonJobs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonJobs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonJobsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonJobsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonJobsMouseExited(evt);
            }
        });
        jButtonJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJobsActionPerformed(evt);
            }
        });

        jButtonScan.setText("Scan Employees");
        jButtonScan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonScan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonScanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonScanMouseExited(evt);
            }
        });
        jButtonScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonScanActionPerformed(evt);
            }
        });

        jButton7.setText("Sign Out");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButtonHome.setText("HOME");
        jButtonHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonHome.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButtonHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonHomeMouseExited(evt);
            }
        });
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNavLayout = new javax.swing.GroupLayout(jPanelNav);
        jPanelNav.setLayout(jPanelNavLayout);
        jPanelNavLayout.setHorizontalGroup(
            jPanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonScan, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonJobs, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRec, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonHunter, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelNavLayout.setVerticalGroup(
            jPanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonHunter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonJobs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonScan)
                .addGap(39, 39, 39)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanelNavLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonHome, jButtonHunter, jButtonJobs, jButtonRec, jButtonScan});

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContent.setPreferredSize(new java.awt.Dimension(924, 355));

        JIconNavBar.setText(" ");
        JIconNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JIconNavBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JIconNavBarMouseClicked(evt);
            }
        });

        jTabbedPaneMain2.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHomeIcon.setText(" ");
        jLabelHomeIcon.setOpaque(true);
        jPanel2.add(jLabelHomeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 330));

        jTabbedPaneMain2.addTab("Home", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("List of Job Hunters");

        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jButtonDeleteAccount.setText("Delete Account");
        jButtonDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccountActionPerformed(evt);
            }
        });

        jTableListOfHunters.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "First Name", "Middle Name", "Last Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListOfHunters.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableListOfHunters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListOfHuntersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableListOfHunters);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(407, 407, 407)
                        .addComponent(jButtonView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteAccount)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonView)
                    .addComponent(jButtonDeleteAccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        jTabbedPaneMain2.addTab("List of Job Hunters", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jButtonDeleteAccountRecruiteres.setText("Delete Account");
        jButtonDeleteAccountRecruiteres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccountRecruiteresActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("List of Job Recruiters");

        jButtonViewRecruiters.setText("View");
        jButtonViewRecruiters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewRecruitersActionPerformed(evt);
            }
        });

        jTableRecruiter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Given Name", "Family Name", "Business Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRecruiter.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRecruiter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecruiterMouseClicked(evt);
            }
        });
        jTableRecruiter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableRecruiterKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jTableRecruiter);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(389, 389, 389)
                        .addComponent(jButtonViewRecruiters)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteAccountRecruiteres)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonViewRecruiters)
                    .addComponent(jButtonDeleteAccountRecruiteres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneMain2.addTab("List of Rec", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jButtonDeleteJobs.setText("Delete Job Posted");
        jButtonDeleteJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteJobsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("List of Jobs");

        jButtonViewListOfJobs.setText("View");
        jButtonViewListOfJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewListOfJobsActionPerformed(evt);
            }
        });

        jComboBoxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Industry", "Alphabetical", "Salaray", "Publisher" }));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sort by");

        jTableListOfJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Name", "Industry", "Recruiters id", "Hired Hunters", "Remaining Slot", "Monthly Salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListOfJobs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableListOfJobs.setSurrendersFocusOnKeystroke(true);
        jTableListOfJobs.getTableHeader().setReorderingAllowed(false);
        jTableListOfJobs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListOfJobsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableListOfJobs);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                        .addComponent(jButtonViewListOfJobs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteJobs)))
                .addGap(31, 31, 31))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonViewListOfJobs)
                        .addComponent(jButtonDeleteJobs))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPaneMain2.addTab("Publised Jobs", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        jTabbedPaneMain2.addTab("Scan", jPanel9);

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(JIconNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jTabbedPaneMain2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(JIconNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPaneMain2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelMainPanelLayout = new javax.swing.GroupLayout(jPanelMainPanel);
        jPanelMainPanel.setLayout(jPanelMainPanelLayout);
        jPanelMainPanelLayout.setHorizontalGroup(
            jPanelMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanelNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMainPanelLayout.setVerticalGroup(
            jPanelMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainPanelLayout.createSequentialGroup()
                .addGroup(jPanelMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelMainPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanelNav, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelHeading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JIconNavBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JIconNavBarMouseClicked

        ImageIcon imgIcon = new ImageIcon("src\\profile.jpg");
        ImageIcon iconForNavOPen = new ImageIcon("src\\icons\\burger.jpg");
        ImageIcon iconForNavClose = new ImageIcon("src\\icons\\x.jpg");

        if (nav) {
            jPanelNav.setVisible(false);
            JIconNavBar.setIcon(scaleImg(iconForNavOPen.getImage(), JIconNavBar.getWidth(), JIconNavBar.getHeight()));
            nav = false;
        } else {
            jPanelNav.setVisible(true);
            jPanelContent.setSize(924, jPanelContent.getHeight());
            JIconNavBar.setIcon(scaleImg(iconForNavClose.getImage(), JIconNavBar.getWidth(), JIconNavBar.getHeight()));
            nav = true;
        }
    }//GEN-LAST:event_JIconNavBarMouseClicked

    private void jButtonHunterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHunterActionPerformed

        jTabbedPaneMain2.setSelectedIndex(1);
        jTableListOfHunters.clearSelection();

        jButtonView.setEnabled(false);
        jButtonDeleteAccount.setEnabled(false);

        jButtonHunter.setBackground(new Color(0, 102, 102));
        jButtonHunter.setForeground(Color.white);
        jButtonHome.setBackground(null);
        jButtonHome.setForeground(null);
        jButtonRec.setBackground(null);
        jButtonRec.setForeground(null);
        jButtonJobs.setBackground(null);
        jButtonJobs.setForeground(null);
        jButtonScan.setBackground(null);
        jButtonScan.setForeground(null);
    }//GEN-LAST:event_jButtonHunterActionPerformed

    private void jButtonRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecActionPerformed
        jTabbedPaneMain2.setSelectedIndex(2);
        jTableRecruiter.clearSelection();

        jButtonViewRecruiters.setEnabled(false);
        jButtonDeleteAccountRecruiteres.setEnabled(false);

//       apilon ang pila na ilang na post tas ang post remaining
        jButtonRec.setBackground(new Color(0, 102, 102));
        jButtonRec.setForeground(Color.white);

        jButtonHunter.setBackground(null);
        jButtonHunter.setForeground(null);
        jButtonHome.setBackground(null);
        jButtonHome.setForeground(null);
        jButtonJobs.setBackground(null);
        jButtonJobs.setForeground(null);
        jButtonScan.setBackground(null);
        jButtonScan.setForeground(null);
    }//GEN-LAST:event_jButtonRecActionPerformed

    private void jButtonJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJobsActionPerformed
        jTabbedPaneMain2.setSelectedIndex(3);
        jTableListOfJobs.clearSelection();
        jButtonJobs.setBackground(new Color(0, 102, 102));
        jButtonJobs.setForeground(Color.white);

        jButtonViewListOfJobs.setEnabled(false);
        jButtonDeleteJobs.setEnabled(false);

        jButtonRec.setBackground(null);
        jButtonRec.setForeground(null);
        jButtonHunter.setBackground(null);
        jButtonHunter.setForeground(null);
        jButtonHome.setBackground(null);
        jButtonHome.setForeground(null);
        jButtonScan.setBackground(null);
        jButtonScan.setForeground(null);

    }//GEN-LAST:event_jButtonJobsActionPerformed

    private void jButtonScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonScanActionPerformed
        jTabbedPaneMain2.setSelectedIndex(4);
        jButtonScan.setBackground(new Color(0, 102, 102));
        jButtonScan.setForeground(Color.white);

        jButtonJobs.setBackground(null);
        jButtonJobs.setForeground(null);
        jButtonRec.setBackground(null);
        jButtonRec.setForeground(null);
        jButtonHunter.setBackground(null);
        jButtonHunter.setForeground(null);
        jButtonHome.setBackground(null);
        jButtonHome.setForeground(null);
    }//GEN-LAST:event_jButtonScanActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTabbedPaneMain2.setSelectedIndex(4);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        MainPanel mp = new MainPanel();
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        jTabbedPaneMain2.setSelectedIndex(0);
        jButtonHome.setBackground(new Color(0, 102, 102));
        jButtonHome.setForeground(Color.white);
        jButtonHunter.setBackground(null);
        jButtonHunter.setForeground(null);
        jButtonRec.setBackground(null);
        jButtonRec.setForeground(null);
        jButtonJobs.setBackground(null);
        jButtonJobs.setForeground(null);
        jButtonScan.setBackground(null);
        jButtonScan.setForeground(null);
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonDeleteJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteJobsActionPerformed
        try {

            PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("DELETE FROM job_posted WHERE job_name = ?");
            ps.setString(1, String.valueOf(jTableListOfJobs.getValueAt(jTableListOfJobs.getSelectedRow(), 0)));
            ps.executeUpdate();

            setAllList();

            jButtonViewListOfJobs.setEnabled(false);
            jButtonDeleteJobs.setEnabled(false);
            jTableListOfJobs.clearSelection();

            JOptionPane.showMessageDialog(null, "Job deleted Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteJobsActionPerformed

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        jButton7.setBackground(new Color(255, 0, 0));
        jButton7.setForeground(Color.white);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        jButton7.setBackground(null);
        jButton7.setForeground(null);
    }//GEN-LAST:event_jButton7MouseExited

    private void jButtonHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHomeMouseEntered

    }//GEN-LAST:event_jButtonHomeMouseEntered

    private void jButtonHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHomeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHomeMouseExited

    private void jButtonHunterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHunterMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHunterMouseEntered

    private void jButtonHunterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHunterMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonHunterMouseExited

    private void jButtonRecMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRecMouseEntered

    private void jButtonRecMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRecMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRecMouseExited

    private void jButtonJobsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonJobsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonJobsMouseClicked

    private void jButtonJobsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonJobsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonJobsMouseEntered

    private void jButtonJobsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonJobsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonJobsMouseExited

    private void jButtonScanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonScanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonScanMouseEntered

    private void jButtonScanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonScanMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonScanMouseExited

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed

        ViewHunter vh = new ViewHunter(jTableListOfHunters.getValueAt(jTableListOfHunters.getSelectedRow(), 0).toString());
        vh.setVisible(true);
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccountActionPerformed

        try {
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Account deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (choice == 0) {

                String mainIndex = jTableListOfHunters.getValueAt(jTableListOfHunters.getSelectedRow(), 0).toString();

                PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT password FROM hunters_account WHERE id = " + mainIndex);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    PreparedStatement delAdmin = setAllConnections.getConAdmin().prepareStatement("DELETE FROM hunters_account WHERE id = " + mainIndex);
                    delAdmin.executeUpdate();

                    PreparedStatement delHiredEmployees = setAllConnections.getConAdmin().prepareStatement("DELETE FROM hired_employees WHERE ID = " + mainIndex);
                    delHiredEmployees.executeUpdate();

                    PreparedStatement delPersoInfo = setAllConnections.getConHunter().prepareStatement("DELETE FROM personalinformation WHERE id = " + mainIndex);
                    delPersoInfo.executeUpdate();

//
//                      ang mga gipnag hired nimo, didto mismo sa account nila
                    JOptionPane.showMessageDialog(null, "Account Deleted Successfully.");
                    setAllList();

                    jButtonDeleteAccount.setEnabled(false);
                    jButtonView.setEnabled(false);
                    jTableListOfHunters.clearSelection();

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jButtonDeleteAccountActionPerformed

    private void jButtonDeleteAccountRecruiteresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccountRecruiteresActionPerformed

        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?");

        if (choice == 0) {
////            AccountHolders.removeRecruiterByIndex(jListOfRecruiters.getSelectedIndex());
//            listOFRecruiters.removeElementAt(jListOfRecruiters.getSelectedIndex());
//            jButtonDeleteAccountRecruiteres.setEnabled(false);
//            jButtonViewRecruiters.setEnabled(false);
//            jListOfRecruiters.clearSelection();
        }


    }//GEN-LAST:event_jButtonDeleteAccountRecruiteresActionPerformed

    private void jButtonViewRecruitersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewRecruitersActionPerformed

//        ViewRecruiter vr = new ViewRecruiter(jListOfRecruiters.getSelectedIndex());
//        vr.setVisible(true);

    }//GEN-LAST:event_jButtonViewRecruitersActionPerformed

    private void jTableListOfHuntersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListOfHuntersMouseClicked

        if (jTableListOfHunters.getRowCount() > 0) {
            jButtonView.setEnabled(true);
            jButtonDeleteAccount.setEnabled(true);
        }

    }//GEN-LAST:event_jTableListOfHuntersMouseClicked


    private void jTableRecruiterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRecruiterKeyPressed

    }//GEN-LAST:event_jTableRecruiterKeyPressed

    private void jTableRecruiterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecruiterMouseClicked
        if (jTableRecruiter.getRowCount() > 0) {
            jButtonViewRecruiters.setEnabled(true);
            jButtonDeleteAccountRecruiteres.setEnabled(true);
        }
    }//GEN-LAST:event_jTableRecruiterMouseClicked

    private void jTableListOfJobsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListOfJobsMouseClicked
        if (jTableListOfJobs.getRowCount() > 0) {
            jButtonViewListOfJobs.setEnabled(true);
            jButtonDeleteJobs.setEnabled(true);
        }
    }//GEN-LAST:event_jTableListOfJobsMouseClicked

    private void jButtonViewListOfJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewListOfJobsActionPerformed
        ShowJob sj = new ShowJob(String.valueOf(jTableListOfJobs.getValueAt(jTableListOfJobs.getSelectedRow(), 0)));
        sj.setVisible(true);

        jButtonViewListOfJobs.setEnabled(false);
        jButtonDeleteJobs.setEnabled(false);

        jTableListOfJobs.clearSelection();

    }//GEN-LAST:event_jButtonViewListOfJobsActionPerformed

    public boolean nav = true;

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
            java.util.logging.Logger.getLogger(AdministratorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JIconAccount;
    private javax.swing.JLabel JIconNavBar;
    private javax.swing.JLabel jAdminIcon;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonDeleteAccount;
    private javax.swing.JButton jButtonDeleteAccountRecruiteres;
    private javax.swing.JButton jButtonDeleteJobs;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonHunter;
    private javax.swing.JButton jButtonJobs;
    private javax.swing.JButton jButtonRec;
    private javax.swing.JButton jButtonScan;
    private javax.swing.JButton jButtonView;
    private javax.swing.JButton jButtonViewListOfJobs;
    private javax.swing.JButton jButtonViewRecruiters;
    private javax.swing.JComboBox<String> jComboBoxSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelHomeIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeading;
    private javax.swing.JPanel jPanelMainPanel;
    private javax.swing.JPanel jPanelNav;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneMain2;
    private javax.swing.JTable jTableListOfHunters;
    private javax.swing.JTable jTableListOfJobs;
    private javax.swing.JTable jTableRecruiter;
    // End of variables declaration//GEN-END:variables
}
