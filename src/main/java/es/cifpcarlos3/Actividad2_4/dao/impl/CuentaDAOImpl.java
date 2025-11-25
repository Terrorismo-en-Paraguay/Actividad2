package es.cifpcarlos3.Actividad2_4.dao.impl;

import es.cifpcarlos3.Actividad2_4.model.Cuenta;
import es.cifpcarlos3.Actividad2_4.util.DataBaseConnection;
import org.mariadb.jdbc.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAOImpl {
    DataBaseConnection dbc;
    public CuentaDAOImpl() {
        dbc = new DataBaseConnection();
    }

    public List<Cuenta> consulta(String consulta) {
        List<Cuenta> cuentas = new ArrayList<>();
        try(var conexion = dbc.getConnection(); Statement stmt = dbc.getConnection().createStatement(); ResultSet resultado = stmt.executeQuery(consulta)) {
            while(resultado.next()) {
                int id = resultado.getInt("id_cuenta");
                String numero_cuenta = resultado.getString("numero_cuenta");
                int id_cliente = resultado.getInt("id_cliente");
                float saldo = resultado.getFloat("saldo");
                cuentas.add(new Cuenta(id, numero_cuenta, id_cliente, saldo));
            }
        }catch(Exception e){

        }
        return cuentas;
    }
}
