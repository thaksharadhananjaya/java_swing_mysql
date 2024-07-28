package student.management.Config;

/**
 *
 * @author thakshara
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Thakshara Dhananjaya
 */
public class MySqlConnection {

    static Connection connection = null;

    final static String PASSWORD = "password";
    final static String USER = "root";
    final static String DB_NAME = "student";
    final static String PORT = "3306";
    final static String HOST = "localhost";

    public static Connection connect() {

        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, USER, PASSWORD);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Can't establish database connection!", "Student Management System", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        }

        return connection;
    }
}
