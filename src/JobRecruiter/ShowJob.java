/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobRecruiter;

//import Classes.AccountHolders;
import Classes.Functions;
import Classes.setAllConnections;
import java.awt.Image;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

//import Classes.Jobs;
/**
 *
 * @author W I N D O W S 10
 */
public class ShowJob extends javax.swing.JFrame {

    private String jobName;
//    private int indexJobSelected;
//    private Jobs job;

    public ShowJob() {

        initComponents();
    }

    public ShowJob(String jobName) {
        initComponents();
        this.jobName = jobName;
        setAll();
    }

    public void setAll() {
//        job = AccountHolders.getRecruiterByIndex(mainIndex).getJobAtIndex(indexJobSelected);
//        jLabelForCompanyLogo.setIcon(job.getImageIcon());
//        jLabelForCompanyLogo.setText("");
//        jTextFieldJobName.setText(job.getJobName());
//        jTextFieldJobsAddress.setText(job.getJobsAddress());
//        jTextFieldCompanyName.setText(job.getCompanyName());
//
//        jTextFieldEmployeeNeeded.setText(String.valueOf(job.getEmployeeNeeded()));
//        jTextFieldMonthlySalary.setText(String.valueOf(job.getMonthlySalary()));
//        jTextFieldAgeRequirement.setText(String.valueOf(job.getAgeRequirement()));
//        jTextFieldYearsOfExperience.setText(String.valueOf(job.getYearsOfExperienceRequired()));
//        jTextAreaSummary.setText(job.getJobSummary());
//
//        if ("Full Time".equals(job.getFullOrPartTime())) {
//            jComboBoxPartTime.setSelectedIndex(0);
//        } else {
//            jComboBoxPartTime.setSelectedIndex(1);
//
//        }
//
//        if ("Communication and Information technology".equals(job.getIndustry())) {
//            jComboBoxIndustry.setSelectedIndex(0);
//        } else if ("Night Market".equals(job.getIndustry())) {
//            jComboBoxIndustry.setSelectedIndex(1);
//        } else {
//            jComboBoxIndustry.setSelectedIndex(2);
//        }
//
////        None, Elementart Graduate, Junior Highschool Graduate, Senior High School Graduate, College Graduate, Masters Degree Holder, Professional
//        if ("None".equals(job.getHighestEducationalAttainment())) {
//            jComboBoxEducationalAttainment.setSelectedIndex(0);
//        } else if ("Elementart Graduate".equals(job.getHighestEducationalAttainment())) {
//            jComboBoxEducationalAttainment.setSelectedIndex(1);
//        } else if ("Junior Highschool Graduate".equals(job.getHighestEducationalAttainment())) {
//            jComboBoxEducationalAttainment.setSelectedIndex(2);
//        } else if ("Senior High School Graduate".equals(job.getHighestEducationalAttainment())) {
//            jComboBoxEducationalAttainment.setSelectedIndex(3);
//        } else if ("College Graduate".equals(job.getHighestEducationalAttainment())) {
//            jComboBoxEducationalAttainment.setSelectedIndex(4);
//        } else if ("Masters Degree Holder".equals(job.getHighestEducationalAttainment())) {
//            jComboBoxEducationalAttainment.setSelectedIndex(5);
//        } else {
//            jComboBoxEducationalAttainment.setSelectedIndex(6);
//        }
//
//        if ("None".equals(job.getQualifiedSex())) {
//            jComboBoxQualifiedSex.setSelectedIndex(0);
//        } else if ("Male".equals(job.getQualifiedSex())) {
//            jComboBoxQualifiedSex.setSelectedIndex(1);
//        } else {
//            jComboBoxQualifiedSex.setSelectedIndex(2);
//        }

        try {
            PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("SELECT * FROM job_posted WHERE job_name = ?");
            ps.setString(1, jobName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

//                jLabelForCompanyLogo.setIcon();
                try {
                    InputStream inputStream = rs.getBinaryStream(14);
                    // Use ImageIO to read the InputStream
                    Image image = ImageIO.read(inputStream);
                    if (image != null) {
                        // Return the ImageIcon
                        jLabelForCompanyLogo.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(jLabelForCompanyLogo.getWidth(), jLabelForCompanyLogo.getHeight(), Image.SCALE_SMOOTH)));
                        jLabelForCompanyLogo.setText("");
                    }
                } catch (Exception e) {
                    jLabelForCompanyLogo.setIcon(Functions.setIconImage("src\\icons\\yow.png", jLabelForCompanyLogo.getWidth(), jLabelForCompanyLogo.getHeight()));
                    jLabelForCompanyLogo.setText("");
                }

                jLabelForCompanyLogo.setText("");
                jTextFieldJobName.setText(rs.getString(2));
                jTextFieldJobsAddress.setText(rs.getString(3));
                jTextFieldCompanyName.setText(rs.getString(4));
                jComboBoxPartTime.setText(rs.getString(5));
                jComboBoxIndustry.setText(rs.getString(6));
                jTextFieldEmployeeNeeded.setText(rs.getString(7));
                jTextFieldMonthlySalary.setText(rs.getString(8));
                jTextFieldAgeRequirement.setText(rs.getString(9));
                jComboBoxEducationalAttainment.setText(rs.getString(10));
                jTextFieldYearsOfExperience.setText(rs.getString(11));
                jComboBoxQualifiedSex.setText(rs.getString(12));
                jTextAreaSummary.setText(rs.getString(13));

            } else {
                JOptionPane.showMessageDialog(null, "It seems there is an error Loading the said job, Please try Again");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelForCompanyLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSummary = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEmployeeNeeded = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldMonthlySalary = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAgeRequirement = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldYearsOfExperience = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldJobsAddress = new javax.swing.JTextField();
        jTextFieldCompanyName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldJobName = new javax.swing.JTextField();
        jComboBoxPartTime = new javax.swing.JTextField();
        jComboBoxIndustry = new javax.swing.JTextField();
        jComboBoxEducationalAttainment = new javax.swing.JTextField();
        jComboBoxQualifiedSex = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelForCompanyLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelForCompanyLogo.setText("COMPAN LOGO");
        jLabelForCompanyLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabelForCompanyLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 50, 114, 110));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Address for work:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 90, 142, -1));

        jPanel2.setForeground(new java.awt.Color(199, 199, 199));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Job Summary");

        jTextAreaSummary.setColumns(20);
        jTextAreaSummary.setLineWrap(true);
        jTextAreaSummary.setRows(5);
        jTextAreaSummary.setFocusable(false);
        jTextAreaSummary.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        jScrollPane1.setViewportView(jTextAreaSummary);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 6, -1, -1));

        jLabel7.setText("Employee needed: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 220, -1, -1));

        jTextFieldEmployeeNeeded.setFocusable(false);
        jPanel1.add(jTextFieldEmployeeNeeded, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 216, 115, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 194, 530, 10));

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 378, 114, -1));

        jLabel1.setText("INDUSTRY:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 225, -1, -1));

        jLabel9.setText("Month Salary:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 260, -1, -1));

        jTextFieldMonthlySalary.setFocusable(false);
        jPanel1.add(jTextFieldMonthlySalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 256, 210, -1));

        jLabel10.setText("Age Requirement:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 260, -1, -1));

        jTextFieldAgeRequirement.setFocusable(false);
        jPanel1.add(jTextFieldAgeRequirement, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 256, 102, -1));

        jLabel11.setText("Highest Educational Attainment:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 301, -1, -1));

        jLabel12.setText("Years Of Experience Required: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 340, -1, -1));

        jTextFieldYearsOfExperience.setFocusable(false);
        jPanel1.add(jTextFieldYearsOfExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 336, 108, -1));

        jLabel13.setText("Qualified Sex:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Companys Name: ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 122, 142, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Part Time/Full Time:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 155, 142, -1));

        jTextFieldJobsAddress.setFocusable(false);
        jPanel1.add(jTextFieldJobsAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 88, 229, -1));

        jTextFieldCompanyName.setFocusable(false);
        jPanel1.add(jTextFieldCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 120, 229, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Jobs Name: ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 52, -1, -1));

        jTextFieldJobName.setFocusable(false);
        jPanel1.add(jTextFieldJobName, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 50, 318, -1));

        jComboBoxPartTime.setFocusable(false);
        jPanel1.add(jComboBoxPartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 152, 229, -1));

        jComboBoxIndustry.setFocusable(false);
        jPanel1.add(jComboBoxIndustry, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 220, 210, -1));

        jComboBoxEducationalAttainment.setFocusable(false);
        jPanel1.add(jComboBoxEducationalAttainment, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 296, 361, -1));

        jComboBoxQualifiedSex.setFocusable(false);
        jPanel1.add(jComboBoxQualifiedSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 335, 137, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(ShowJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JTextField jComboBoxEducationalAttainment;
    private javax.swing.JTextField jComboBoxIndustry;
    private javax.swing.JTextField jComboBoxPartTime;
    private javax.swing.JTextField jComboBoxQualifiedSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelForCompanyLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaSummary;
    private javax.swing.JTextField jTextFieldAgeRequirement;
    private javax.swing.JTextField jTextFieldCompanyName;
    private javax.swing.JTextField jTextFieldEmployeeNeeded;
    private javax.swing.JTextField jTextFieldJobName;
    private javax.swing.JTextField jTextFieldJobsAddress;
    private javax.swing.JTextField jTextFieldMonthlySalary;
    private javax.swing.JTextField jTextFieldYearsOfExperience;
    // End of variables declaration//GEN-END:variables
}
