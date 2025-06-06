/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminsView;

//import Classes.AccountHolders;
//import Classes.Functions;
import Classes.Functions;
import Classes.setAllConnections;
import MainPackage.ForShowAccountHunter;
import java.awt.Image;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ViewHunter extends javax.swing.JFrame {

    private String mainIndex;

    private ResultSet hunterData;

    /**
     * Creates new form ViewHunter
     */
    public ViewHunter() {
        initComponents();
    }

    public ViewHunter(String mainIndex) {
        initComponents();
        this.mainIndex = mainIndex;

        setInformations();
        setImageIcons();
    }

    public void setInformations() {

        try {
            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT * FROM hunters_account WHERE id = ?");
            ps.setString(1, mainIndex);
            hunterData = ps.executeQuery();

            if (hunterData.next()) {
                //                jLabelForProfileIcon

                jLabelNamee.setText(hunterData.getString(5) + " " + hunterData.getString(7));

                try {
                    InputStream inputStream = hunterData.getBinaryStream(14);
                    // Use ImageIO to read the InputStream
                    Image image = ImageIO.read(inputStream);
                    if (image != null) {
                        // Return the ImageIcon
                        jLabelForProfileIcon.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(jLabelForProfileIcon.getWidth(), jLabelForProfileIcon.getHeight(), Image.SCALE_SMOOTH)));
                        jLabelForProfileIcon.setText("");
                    }
                } catch (Exception e) {
                    jLabelForProfileIcon.setIcon(Functions.setIconImage("src\\MainPackage\\profile.jpg", jLabelForProfileIcon.getWidth(), jLabelForProfileIcon.getHeight()));
                    jLabelForProfileIcon.setText("");
                }
                
                jLabelAgee.setText(hunterData.getString(9));

            } else {
                JOptionPane.showMessageDialog(null, "It seems there is a n error loading on your data");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

//        if (AccountHolders.getHunterByIndex(mainIndex).getStatus()) {
//            jLabelStatus.setText("STATUS: HIRED");
////            e butang kung si kinsa ang employer if oks na ang hire^2
//        } else {
//            jLabelStatus.setText("STATUS: NOT HIRED");
//        }
//        jLabelAge.setText("Age: " + String.valueOf(AccountHolders.getHunterByIndex(mainIndex).getAge()));
//        jLabelSex.setText("Sex: : " + AccountHolders.getHunterByIndex(mainIndex).isSex());
//        jLabelBirthDate.setText("Birth Date: " + AccountHolders.getHunterByIndex(mainIndex).getDateOfBirth());
//        jLabelName.setText("Name: " + AccountHolders.getHunterByIndex(mainIndex).getLastName() + ", " + AccountHolders.getHunterByIndex(mainIndex).getFirstName());
//        jLabelFullAddress.setText("Full Address: " + AccountHolders.getHunterByIndex(mainIndex).getFullAddress());
//        jLabelEmailAddress.setText("Email Address: " + AccountHolders.getHunterByIndex(mainIndex).getEmailAddress());
//        jLabelContactNumber.setText("Contact Number: " + AccountHolders.getHunterByIndex(mainIndex).getContactNumber());
    }

    public void setImageIcons() {
//        try {
//            jLabelForProfileIcon.setIcon(Functions.setProfileImageToNewLabel(AccountHolders.getHunterByIndex(mainIndex).getProfileImage(), jLabelForProfileIcon.getWidth(), jLabelForProfileIcon.getHeight()));
//            jLabelForProfileIcon.setText("");
//        } catch (Exception e) {
//            jLabelForProfileIcon.setIcon(Functions.iconImageFit("src\\MainPackage\\profile.jpg", jLabelForProfileIcon.getWidth(), jLabelForProfileIcon.getHeight()));
//            jLabelForProfileIcon.setText("");
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabelForProfileIcon = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelFullAddress = new javax.swing.JLabel();
        jLabelEmailAddress = new javax.swing.JLabel();
        jLabelContactNumber = new javax.swing.JLabel();
        jLabelAge = new javax.swing.JLabel();
        jLabelSex = new javax.swing.JLabel();
        jLabelBirthDate = new javax.swing.JLabel();
        jLabelStatus1 = new javax.swing.JLabel();
        jLabelAgee = new javax.swing.JLabel();
        jLabelSexx = new javax.swing.JLabel();
        jLabelBdate = new javax.swing.JLabel();
        jLabelNamee = new javax.swing.JLabel();
        jLabelFA = new javax.swing.JLabel();
        jLabelEmailA = new javax.swing.JLabel();
        jLabelNo = new javax.swing.JLabel();
        jLabelStatLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText(" Perosnal Info");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(" Career History");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Educational Attainment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("License and Certs");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Skills");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setForeground(new java.awt.Color(204, 0, 0));
        jButton6.setText("Return");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Languages");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Resume");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(15, 15, 15))
        );

        jLabelForProfileIcon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelForProfileIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelForProfileIcon.setText("PROFILE PIC");
        jLabelForProfileIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelName.setText("Name: ");

        jLabelStatus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 102, 102));
        jLabelStatus.setText("STATUS: ");

        jLabelFullAddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelFullAddress.setText("Full Address: ");

        jLabelEmailAddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelEmailAddress.setText("Email Address: ");

        jLabelContactNumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelContactNumber.setText("Contact Number: ");

        jLabelAge.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelAge.setText("Age: ");

        jLabelSex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSex.setText("Sex: ");

        jLabelBirthDate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelBirthDate.setText("Birth Date: ");

        jLabelStatus1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelStatus1.setForeground(new java.awt.Color(0, 102, 102));
        jLabelStatus1.setText("Hunter");

        jLabelBdate.setText(" ");

        jLabelNamee.setText(" ");

        jLabelFA.setText(" ");

        jLabelEmailA.setText(" ");

        jLabelNo.setText(" ");

        jLabelStatLabel.setText("  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelForProfileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelStatLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelBirthDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelBdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStatus1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelSex)
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabelSexx, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelAge)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelAgee, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNamee, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelFullAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFA, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelEmailAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmailA, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelContactNumber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelForProfileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jLabelNamee))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFullAddress)
                    .addComponent(jLabelFA))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmailAddress)
                    .addComponent(jLabelEmailA))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelContactNumber)
                    .addComponent(jLabelNo)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelStatus1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatus)
                    .addComponent(jLabelStatLabel))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAge)
                    .addComponent(jLabelAgee, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSex)
                    .addComponent(jLabelSexx, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBirthDate)
                    .addComponent(jLabelBdate)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ForShowAccountHunter hi = new ForShowAccountHunter(Integer.parseInt(mainIndex));
        hi.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHunter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHunter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelAgee;
    private javax.swing.JLabel jLabelBdate;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelContactNumber;
    private javax.swing.JLabel jLabelEmailA;
    private javax.swing.JLabel jLabelEmailAddress;
    private javax.swing.JLabel jLabelFA;
    private javax.swing.JLabel jLabelForProfileIcon;
    private javax.swing.JLabel jLabelFullAddress;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNamee;
    private javax.swing.JLabel jLabelNo;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JLabel jLabelSexx;
    private javax.swing.JLabel jLabelStatLabel;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelStatus1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
