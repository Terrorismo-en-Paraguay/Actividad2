package es.cifpcarlos3.Actividad2_4.dao.impl;

import es.cifpcarlos3.Actividad2_4.model.Cliente;
import es.cifpcarlos3.Actividad2_4.model.Cuenta;
import es.cifpcarlos3.Actividad2_4.util.DataBaseConnection;
import org.mariadb.jdbc.Statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAOImpl {
    DataBaseConnection dbc;

    public CuentaDAOImpl() {
        dbc = new DataBaseConnection();
    }

    public List<Cuenta> consulta(String consulta) {
        List<Cuenta> cuentas = new ArrayList<>();
        try (var conexion = dbc.getConnection();
                Statement stmt = dbc.getConnection().createStatement();
                ResultSet resultado = stmt.executeQuery(consulta)) {
            while (resultado.next()) {
                int id = resultado.getInt("id_cuenta");
                String numero_cuenta = resultado.getString("numero_cuenta");
                int id_cliente = resultado.getInt("id_cliente");
                float saldo = resultado.getFloat("saldo");
                cuentas.add(new Cuenta(id, numero_cuenta, id_cliente, saldo));
            }
        } catch (Exception e) {

        }
        return cuentas;
    }

    public List<List> consultaCuenta(String consulta) {
        List<List> listas = new ArrayList<>();
        List<Cuenta> cuentas = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        try (var conexion = dbc.getConnection();
                Statement stmt = dbc.getConnection().createStatement();
                ResultSet resultado = stmt.executeQuery(consulta)) {
            while (resultado.next()) {
                int id = resultado.getInt("id_cuenta");
                String numero_cuenta = resultado.getString("numero_cuenta");
                int id_cliente = resultado.getInt("id_cliente");
                float saldo = resultado.getFloat("saldo");
                cuentas.add(new Cuenta(id, numero_cuenta, id_cliente, saldo));
                int id_cliente_1 = resultado.getInt("id_cliente");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                int telefono = resultado.getInt("telefono");
                String email = resultado.getString("email");
                clientes.add(new Cliente(id_cliente_1, dni, nombre, telefono, email));
                listas.add(cuentas);
                listas.add(clientes);
            }
        } catch (Exception e) {

        }
        return listas;
    }

    public void insertarCuenta(Cuenta cuenta) {
        try (var conexion = dbc.getConnection();
                PreparedStatement stmt = conexion.prepareStatement(
                        "Insert Into t_cuenta (numero_cuenta, id_cliente, saldo) VALUES (?, ?, ?)");) {
            stmt.setString(1, cuenta.getNumeroCuenta());
            stmt.setInt(2, cuenta.getIdcliente());
            stmt.setFloat(3, cuenta.getSaldo());
            stmt.executeUpdate();
            System.out.println("Cuenta insertado correctamente");
        } catch (Exception e) {

        }
    }

    public void actualizarSaldo(Cuenta cuenta) {
        try (var conexion = dbc.getConnection();) {
            conexion.setAutoCommit(false);
            System.out.println("Transaccion iniciada");
            try (PreparedStatement stmt = conexion
                    .prepareStatement("UPDATE t_cuenta SET saldo=? where numero_cuenta=?");) {
                stmt.setFloat(1, cuenta.getSaldo());
                stmt.setString(2, cuenta.getNumeroCuenta());
                stmt.executeUpdate();
                System.out.println("Saldo actualizado");
                conexion.commit();
                System.out.println("Transaccion finalizada");
            }catch (Exception e) {
                System.err.println("Ocurrió un error durante la operación SQL. Intentando rollback.");
                if (conexion != null) {
                    try {
                        conexion.rollback();
                        System.err.println("Rollback exitoso. Ningún cambio ha sido guardado.");
                    } catch (SQLException excep) {
                        System.err.println("Error al intentar rollback: " + excep.getMessage());
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    public float obtenerSaldo(String cuenta) {
        float saldo = 0;
        try (var conexion = dbc.getConnection();
                Statement stmt = dbc.getConnection().createStatement();
                ResultSet resultado = stmt
                        .executeQuery("SELECT saldo FROM t_cuenta where numero_cuenta='" + cuenta + "'")) {
            while (resultado.next()) {
                saldo = resultado.getFloat("saldo");
            }
        } catch (Exception e) {

        }
        return saldo;
    }
}
