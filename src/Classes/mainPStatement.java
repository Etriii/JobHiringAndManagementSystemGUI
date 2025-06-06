package Classes;

public class mainPStatement {

    public static void addAccountForHunter(String username, String password) {
        adminsQueries.addAccountForHunter(username, password);
    }

    public static void addAccountForRecruiter(String username, String password) {
        adminsQueries.addAccountForRecruiter(username, password);
    }

    public static void getIDofHunter(String username, String password) {
        Validators.getIDofHunter(username, password);
    }

    public static void getIDofRecruiter(String username, String password) {
        Validators.getIDofRecruiter(username, password);
    }

    public static void getAdmin(String username, String password) {
        Validators.checkAdmin(username, password);
    }
    
    

}
