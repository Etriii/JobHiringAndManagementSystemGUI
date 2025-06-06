package AdminsView;

//import Classes.AccountHolders;
//import Classes.Functions;
import MainPackage.ForShowAccountRecruiter;

public class ViewRecruiter extends javax.swing.JFrame {

    private int mainIndex;

    public ViewRecruiter() {
        initComponents();
    }

    public ViewRecruiter(int mainIndex) {
        initComponents();
        this.mainIndex = mainIndex;
        setAllInformation();
        setImageIcons();
        this.setLocationRelativeTo(null);
    }

    public void setImageIcons() {
//        try {
//            jLabelIcoImage.setText("");
//            jLabelIcoImage.setIcon(Functions.setProfileImageToNewLabel(AccountHolders.getRecruiterByIndex(mainIndex).getProfileImage(), jLabelIcoImage.getWidth(), jLabelIcoImage.getHeight()));
//        } catch (Exception e) {
//            jLabelIcoImage.setIcon(Functions.iconImageFit("src\\MainPackage\\profile.jpg", jLabelIcoImage.getWidth(), jLabelIcoImage.getHeight()));
//            jLabelIcoImage.setText("");
//        }
    }

    public void setAllInformation() {
//        jLabelAge.setText("Age: " + String.valueOf(AccountHolders.getRecruiterByIndex(mainIndex).getAge()));
//        jLabelSex.setText("Sex: : " + AccountHolders.getRecruiterByIndex(mainIndex).isSex());
//        jLabelBirthDate.setText("Birth Date: " + AccountHolders.getRecruiterByIndex(mainIndex).getDateOfBirth());
//        jLabelName.setText("Name: " + AccountHolders.getRecruiterByIndex(mainIndex).getLastName() + ", " + AccountHolders.getRecruiterByIndex(mainIndex).getFirstName());
//        jLabelFullAddress.setText("Full Address: " + AccountHolders.getRecruiterByIndex(mainIndex).getFullAddress());
//        jLabelEmailAddress.setText("Email Address: " + AccountHolders.getRecruiterByIndex(mainIndex).getEmailAddress());
//        jLabelContactNumber.setText("Contact Number: " + AccountHolders.getRecruiterByIndex(mainIndex).getContactNumber());
//        jLabelBName.setText("Business Name: " + AccountHolders.getRecruiterByIndex(mainIndex).getbName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelIcoImage = new javax.swing.JLabel();
        jLabelBirthDate = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelFullAddress = new javax.swing.JLabel();
        jLabelEmailAddress = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabelContactNumber = new javax.swing.JLabel();
        jLabelAge = new javax.swing.JLabel();
        jLabelSex = new javax.swing.JLabel();
        jLabelBName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIcoImage.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelIcoImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcoImage.setText("PROFILE PIC");
        jLabelIcoImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabelIcoImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 34, 161, 153));

        jLabelBirthDate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelBirthDate.setText("Birth Date: ");
        jPanel1.add(jLabelBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 118, -1, -1));

        jLabelName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelName.setText("Name: ");
        jPanel1.add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 205, -1, -1));

        jLabelStatus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(0, 102, 102));
        jLabelStatus.setText("EMPLOYER");
        jPanel1.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 34, -1, -1));

        jLabelFullAddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelFullAddress.setText("Full Address: ");
        jPanel1.add(jLabelFullAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 264, -1, -1));

        jLabelEmailAddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelEmailAddress.setText("Email Address: ");
        jPanel1.add(jLabelEmailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 295, -1, -1));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 6, -1, 360));

        jLabelContactNumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelContactNumber.setText("Contact Number: ");
        jPanel1.add(jLabelContactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 326, -1, -1));

        jLabelAge.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelAge.setText("Age: ");
        jPanel1.add(jLabelAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 61, -1, -1));

        jLabelSex.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelSex.setText("Sex: ");
        jPanel1.add(jLabelSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 90, -1, -1));

        jLabelBName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelBName.setText("Business Name:");
        jPanel1.add(jLabelBName, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 236, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ForShowAccountRecruiter fr = new ForShowAccountRecruiter(mainIndex);
        fr.setVisible(true);
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
            java.util.logging.Logger.getLogger(ViewRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRecruiter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRecruiter().setVisible(true);
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
    private javax.swing.JLabel jLabelBName;
    private javax.swing.JLabel jLabelBirthDate;
    private javax.swing.JLabel jLabelContactNumber;
    private javax.swing.JLabel jLabelEmailAddress;
    private javax.swing.JLabel jLabelFullAddress;
    private javax.swing.JLabel jLabelIcoImage;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
