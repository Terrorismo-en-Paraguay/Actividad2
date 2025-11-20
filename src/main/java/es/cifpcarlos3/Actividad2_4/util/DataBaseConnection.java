package es.cifpcarlos3.Actividad2_4.util;

import org.mariadb.jdbc.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataBaseConnection {
    String user = "root";
    String pass = "";
    String url = "jdbc:mariadb://localhost:3306/banco";

    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, user, pass);
    }
}
