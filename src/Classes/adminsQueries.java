package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class adminsQueries {

    private static int idHunter = 0;
    private static int idRecruiter = 0;

    public static int getRowIDByIndex(String from, int x) {

        int id = 0;
        try {

//              if error japun try dawg e sulod sa array list tanang id tas didtu nalang mag isa^2
//              what if after e delete ang ID e store sya sa laing table para didtu nalang mag isa^2 unsay mga available ID naa.
            String getIDIn;
            String query;

            if (x == 0) {
                getIDIn = String.valueOf(x);
                query = "SELECT id FROM " + from + " ORDER BY id ASC LIMIT 1";

            } else {
                getIDIn = String.valueOf(x);
                query = "SELECT id FROM " + from + " ORDER BY id ASC LIMIT 1 OFFSET " + getIDIn;
            }

//          SELECT ID FROM student_information ORDER BY ID LIMIT 3
            PreparedStatement pst = setAllConnections.getConAdmin().prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id");
                System.out.println(id);
            } else {
                System.out.println("No data found.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return id;
    }

    public static void setSQLRowCountHunter() {
        try {
            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT COUNT(*) AS total FROM hunters_account");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idHunter = rs.getInt("total");
                System.out.println("Total number of rows in Hunter: " + idHunter);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
//        return idHunter;
    }

    public static void setSQLRowCountRecruiter() {
        try {
            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("SELECT COUNT(*) AS total FROM recruiters_account");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idRecruiter = rs.getInt("total");
                System.out.println("Total number of rows in Recruiter: " + idRecruiter);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
//        return idHunter;
    }

    public static void addAccountForHunter(String username, String password) {
        try {
            setSQLRowCountHunter();

//           get id per row using loop then check if i == row id then skip, else ang i e id para way laktaw ]
            for (int i = 0; i < idHunter; i++) {
                int rowIdByIndex = getRowIDByIndex("hunters_account", i);

                if (i != rowIdByIndex) {
                    idHunter = i;
                    break;
                }
            }

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("INSERT INTO hunters_account(id, username, password) VALUES(?, ?, ?)");
            ps.setInt(1, idHunter);
            ps.setString(2, username);
            ps.setString(3, password);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account Created Successfully");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public static void addAccountForRecruiter(String username, String password) {
        try {
            setSQLRowCountRecruiter();

//           get id per row using loop then check if i == row id then skip, else ang i e id para way laktaw ]
            for (int i = 0; i < idRecruiter; i++) {
                int rowIdByIndex = getRowIDByIndex("recruiters_account", i);

                if (i != rowIdByIndex) {
                    idRecruiter = i;
                    break;
                }
            }

            PreparedStatement ps = setAllConnections.getConAdmin().prepareStatement("INSERT INTO recruiters_account(id, username, password) VALUES(?, ?, ?)");
            ps.setInt(1, idRecruiter);
            ps.setString(2, username);
            ps.setString(3, password);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Account Created Successfully");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
