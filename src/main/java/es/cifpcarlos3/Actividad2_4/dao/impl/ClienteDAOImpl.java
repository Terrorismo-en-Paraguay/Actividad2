package es.cifpcarlos3.Actividad2_4.dao.impl;

import es.cifpcarlos3.Actividad2_4.model.Cliente;
import es.cifpcarlos3.Actividad2_4.util.DataBaseConnection;
import org.mariadb.jdbc.Statement;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        List<Cliente> clientes = new ArrayList<>();
        try(var conexion = dbc.getConnection(); Statement stmt = dbc.getConnection().createStatement(); ResultSet resultado = stmt.executeQuery(consulta)){
            while (resultado.next()) {
                int id = resultado.getInt("id_cliente");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                int telefono = resultado.getInt("telefono");
                String email = resultado.getString("email");
                clientes.add(new Cliente(id, dni, nombre, telefono, email));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public void insertarCliente(Cliente cliente){
        try(var conexion = dbc.getConnection(); PreparedStatement stmt = conexion.prepareStatement("Insert Into t_cliente (dni,nombre,telefono,email) VALUES (?,?,?,?)");) {
            stmt.setString(1, cliente.getDni());
            stmt.setString(2, cliente.getNombre());
            stmt.setInt(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println("Datos insertados correctamente.");
        }catch (SQLException e){
            System.out.println("No se pudieron insertar los datos");
            throw new RuntimeException(e);
        }
    }

    public void eliminarCliente(Cliente cliente){
        try(var  conexion = dbc.getConnection(); PreparedStatement stmt = conexion.prepareStatement("Delete from t_cliente where id_cliente = ?")){

        }catch (Exception e){
            System.out.println("No se pudieron eliminar los datos");
        }
    }
}
