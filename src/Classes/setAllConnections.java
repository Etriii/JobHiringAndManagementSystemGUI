package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class setAllConnections {

    private static Connection conAdmin;
    private static Connection conHunter;
    private static Connection conRecruiter;

    public static Connection getConRecruiter() {
        return conRecruiter;
    }

    public static Connection getConHunter() {
        return conHunter;
    }

    public static Connection getConAdmin() {
        return conAdmin;
    }

    public static void setAllConnection() {
        try {
            
            conAdmin = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_admin", "root", "");
            conHunter = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_hunter", "root", "");
            conRecruiter = DriverManager.getConnection("jdbc:mysql://localhost:3306/job_recruiter", "root", "");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
//    public static void main(String[] args) {
//        setAllConnection();
//    }

}
