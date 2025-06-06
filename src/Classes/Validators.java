package Classes;

import MainPackage.AdministratorPortal;
import MainPackage.JobHuntersPortal;
import MainPackage.JobRecruiterPortal;
import MainPackage.MainPanel;
import MainPackage.semiProfileForHunter;
import MainPackage.semiProfileForRecruiter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Validators {
//check if naa ba ang account where username == username

    public static void getIDofHunter(String username, String password) {

        try {

            String id = "";

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT id FROM hunters_account WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Logged In Successfully.");

//                JOptionPane.showMessageDialog(null, rs.getString("id"));
                id = rs.getString("id");
                PreparedStatement ps2 = setAllConnections.getConAdmin().prepareStatement("SELECT semi_info FROM hunters_account WHERE ID = " + id);
                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()) {

//                    JOptionPane.showMessageDialog(null, rs2.getString("semi_info"));
                    if ("0".equals(rs2.getString("semi_info"))) {

                        semiProfileForHunter sh = new semiProfileForHunter(id);
                        sh.setVisible(true);

                    } else {
                        JobHuntersPortal jb = new JobHuntersPortal(id);
                        jb.setVisible(true);
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Username or Password is Incorrect");
                MainPanel mp = new MainPanel();
                mp.setVisible(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void checkAdmin(String username, String password) {
        try {

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT * FROM admins_account WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                AdministratorPortal admin = new AdministratorPortal();
                admin.setVisible(true);
                JOptionPane.showMessageDialog(null, "Logged In Successfully");

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Admin Credentials");
                MainPanel mp = new MainPanel();
                mp.setVisible(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "Incorrect Admin Credentials");
            MainPanel mp = new MainPanel();
            mp.setVisible(true);
        }
    }

    public static void getIDofRecruiter(String username, String password) {
        try {

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT id FROM recruiters_account WHERE username =? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Logged In Successfully");
                String id = rs.getString("id");

                PreparedStatement ps2 = setAllConnections.getConAdmin().prepareStatement("Select semi FROM recruiters_account WHERE ID = " + id);
                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()) {

                    if ("0".equals(rs2.getString("semi"))) {
                        semiProfileForRecruiter sr = new semiProfileForRecruiter(id);
                        sr.setVisible(true);

                    } else {
                        JobRecruiterPortal jb = new JobRecruiterPortal(id);
                        jb.setVisible(true);
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Username or Password is Incorrect");
                new MainPanel().setVisible(true);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
