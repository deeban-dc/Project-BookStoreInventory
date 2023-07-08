import java.sql.Connection;
import java.sql.DriverManager;

public class main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Deebandc007@");
            System.out.println(con);
        } catch (Exception e) {

        }
    }
}
