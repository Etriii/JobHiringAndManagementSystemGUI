package JobRecruiter;

//import Classes.AccountHolders;
//import Classes.Functions;
//import Classes.Jobs;
import Classes.Functions;
import Classes.setAllConnections;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckJobToPost extends javax.swing.JFrame {

    private String mainIndex;
    private File selectedFile;
    private String remainingPost;

    public CheckJobToPost() {
        initComponents();
        this.setTitle("Job Posting");
    }

    public CheckJobToPost(String mainIndex, String remainingPost) {
        initComponents();
        this.mainIndex = mainIndex;
        this.remainingPost = remainingPost;
        this.setTitle("Job Posting | ID = " + mainIndex);
        System.out.println(remainingPost);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelForCompanyLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaSummary = new javax.swing.JTextArea();
        jButtonResetJobSummary = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEmployeeNeeded = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonJobPost = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxIndustry = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldMonthlySalary = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAgeRequirement = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxEducationalAttainment = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldYearsOfExperience = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxQualifiedSex = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldJobsAddress = new javax.swing.JTextField();
        jTextFieldCompanyName = new javax.swing.JTextField();
        jComboBoxPartTime = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldJobName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelForCompanyLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelForCompanyLogo.setText("COMPANY LOGO");
        jLabelForCompanyLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabelForCompanyLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 50, 100, 85));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Address for work:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 88, 142, -1));

        jPanel2.setForeground(new java.awt.Color(199, 199, 199));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Job Summary");

        jTextAreaSummary.setColumns(20);
        jTextAreaSummary.setLineWrap(true);
        jTextAreaSummary.setRows(5);
        jTextAreaSummary.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        jScrollPane1.setViewportView(jTextAreaSummary);

        jButtonResetJobSummary.setForeground(new java.awt.Color(204, 0, 0));
        jButtonResetJobSummary.setText("Reset");
        jButtonResetJobSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetJobSummaryActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonResetJobSummary)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonResetJobSummary)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 6, -1, 408));

        jLabel7.setText("Employee needed: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 214, -1, -1));
        getContentPane().add(jTextFieldEmployeeNeeded, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 210, 102, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 188, 530, 10));

        jButtonJobPost.setBackground(new java.awt.Color(0, 102, 102));
        jButtonJobPost.setForeground(new java.awt.Color(255, 255, 255));
        jButtonJobPost.setText("POST JOB");
        jButtonJobPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJobPostActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonJobPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 365, 290, -1));

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 365, 114, -1));

        jButtonReset.setForeground(new java.awt.Color(204, 0, 0));
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 365, 114, -1));

        jLabel1.setText("INDUSTRY:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 214, -1, -1));

        jComboBoxIndustry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Communication and Information technology", "Night Market", "Sa Akong Heart" }));
        getContentPane().add(jComboBoxIndustry, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 210, 210, 30));

        jLabel9.setText("Month Salary:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 250, -1, -1));
        getContentPane().add(jTextFieldMonthlySalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 246, 210, -1));

        jLabel10.setText("Age Requirement:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 250, -1, -1));
        getContentPane().add(jTextFieldAgeRequirement, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 246, 102, -1));

        jLabel11.setText("Highest Educational Attainment:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 289, -1, -1));

        jComboBoxEducationalAttainment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Elementart Graduate", "Junior Highschool Graduate", "Senior High School Graduate", "College Graduate", "Masters Degree Holder", "Professional" }));
        jComboBoxEducationalAttainment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEducationalAttainmentActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxEducationalAttainment, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 280, 344, 34));

        jButton5.setText("UPLOAD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 141, 100, 29));

        jLabel12.setText("Years Of Experience Required: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 328, -1, -1));
        getContentPane().add(jTextFieldYearsOfExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 324, 108, -1));

        jLabel13.setText("Qualified Sex:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 328, -1, -1));

        jComboBoxQualifiedSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Male", "Female" }));
        getContentPane().add(jComboBoxQualifiedSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 323, 102, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Companys Name: ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 118, 142, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Part Time/Full Time:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 149, 142, -1));
        getContentPane().add(jTextFieldJobsAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 86, 229, -1));
        getContentPane().add(jTextFieldCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 116, 229, -1));

        jComboBoxPartTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Time", "Part Time" }));
        getContentPane().add(jComboBoxPartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 146, 229, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Jobs Name: ");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 52, -1, -1));
        getContentPane().add(jTextFieldJobName, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 50, 318, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEducationalAttainmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEducationalAttainmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEducationalAttainmentActionPerformed

    private void jButtonResetJobSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetJobSummaryActionPerformed
        jTextAreaSummary.setText("");
    }//GEN-LAST:event_jButtonResetJobSummaryActionPerformed

    private void jButtonJobPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJobPostActionPerformed
//         ImageIcon,  jobName,  jobsAddress,  companyName,  fullOrPartTime,  industry,  employeeNeeded,  jobSummary,  
//         monthlySalary,  ageRequirement,  highestEducationalAttainment,  yearsOfExperienceRequired,  qualifiedSex

        try {

//            Jobs job = new Jobs(jLabelForCompanyLogo.getIcon(), jTextFieldJobName.getText(), jTextFieldJobsAddress.getText(), jTextFieldCompanyName.getText(), jComboBoxPartTime.getSelectedItem(), jComboBoxIndustry.getSelectedItem(), Integer.parseInt(jTextFieldEmployeeNeeded.getText()), jTextAreaSummary.getText(),
//                    Double.parseDouble(jTextFieldMonthlySalary.getText()), Integer.parseInt(jTextFieldAgeRequirement.getText()), jComboBoxEducationalAttainment.getSelectedItem(), Integer.parseInt(jTextFieldYearsOfExperience.getText()), jComboBoxQualifiedSex.getSelectedItem(),
//                    AccountHolders.getRecruiterByIndex(mainIndex).getFirstName(), AccountHolders.getRecruiterByIndex(mainIndex).getLastName()
//            );
//            
//            AccountHolders.getRecruiterByIndex(mainIndex).decrementBy1JobPostRemaining();
//            AccountHolders.getRecruiterByIndex(mainIndex).addJob(job);
//            JOptionPane.showMessageDialog(null, "Job Posted Successfully");
//            this.dispose();
            PreparedStatement ps = setAllConnections.getConRecruiter().prepareStatement("INSERT INTO job_posted VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, Integer.parseInt(mainIndex));
            ps.setString(2, jTextFieldJobName.getText());
            ps.setString(3, jTextFieldJobsAddress.getText());
            ps.setString(4, jTextFieldCompanyName.getText());
            ps.setString(5, (String) jComboBoxPartTime.getSelectedItem());
            ps.setString(6, (String) jComboBoxIndustry.getSelectedItem());
            ps.setInt(7, Integer.parseInt(jTextFieldEmployeeNeeded.getText()));
            ps.setString(8, jTextFieldMonthlySalary.getText());
            ps.setInt(9, Integer.parseInt(jTextFieldAgeRequirement.getText()));
            ps.setString(10, (String) jComboBoxEducationalAttainment.getSelectedItem());
            ps.setInt(11, Integer.parseInt(jTextFieldYearsOfExperience.getText()));
            ps.setString(12, (String) jComboBoxQualifiedSex.getSelectedItem());
            ps.setString(13, jTextAreaSummary.getText());
            ps.setBlob(14, new FileInputStream(selectedFile));
            ps.executeUpdate();

            int decrement = Integer.parseInt(remainingPost);

            PreparedStatement ps2 = setAllConnections.getConAdmin().prepareStatement("UPDATE recruiters_account SET remaining_post = ? WHERE id = ?");
            ps2.setString(1, String.valueOf(--decrement));
            ps2.setString(2,mainIndex);
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(null, "Job posted Successfully");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

//        decrement and post remaining
    }//GEN-LAST:event_jButtonJobPostActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed

    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose an Image");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                BufferedImage originalImage = ImageIO.read(selectedFile);
                Image img = originalImage.getScaledInstance(jLabelForCompanyLogo.getWidth(), jLabelForCompanyLogo.getHeight(), Image.SCALE_SMOOTH);

                jLabelForCompanyLogo.setIcon(new ImageIcon(img));
                jLabelForCompanyLogo.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading image.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(CheckJobToPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckJobToPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckJobToPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckJobToPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckJobToPost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonJobPost;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonResetJobSummary;
    private javax.swing.JComboBox<String> jComboBoxEducationalAttainment;
    private javax.swing.JComboBox<String> jComboBoxIndustry;
    private javax.swing.JComboBox<String> jComboBoxPartTime;
    private javax.swing.JComboBox<String> jComboBoxQualifiedSex;
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
