package es.cifpcarlos3.Actividad2_5.util;

import org.mariadb.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    String user = "root";
    String pass = "";
    String url = "jdbc:mariadb://localhost:3306/banco";

    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(url, user, pass);
    }
}
