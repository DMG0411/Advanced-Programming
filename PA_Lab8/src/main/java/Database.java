import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.commit();
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
