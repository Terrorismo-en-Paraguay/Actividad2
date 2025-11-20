package es.cifpcarlos3.Actividad2_4.dao.impl;

import es.cifpcarlos3.Actividad2_4.model.Cliente;
import es.cifpcarlos3.Actividad2_4.util.DataBaseConnection;
import org.mariadb.jdbc.Statement;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl {
    DataBaseConnection dbc;
    public ClienteDAOImpl() {
        dbc = new DataBaseConnection();
    }
    public List<Cliente> consulta(String consulta) {
        List<Cliente> cuentas = new ArrayList<>();
        try(var conexion = dbc.getConnection(); Statement stmt = dbc.getConnection().createStatement(); ResultSet resultado = stmt.executeQuery(consulta)){
            while (resultado.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cuentas;
    }
}
