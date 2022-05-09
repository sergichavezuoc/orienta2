package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mamaroa
 */
// TODO: Aplicaremos refactor clases más adelante
public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/onlinestore?serverTimezone=Europe/Madrid";
    private static final String username = "root";
    private static final String password = "21Jun&01992";
    private static Connection connection;

    public static Connection createConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
