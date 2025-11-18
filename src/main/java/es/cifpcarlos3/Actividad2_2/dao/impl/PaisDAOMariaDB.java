package es.cifpcarlos3.Actividad2_2.dao.impl;

import es.cifpcarlos3.Actividad2_2.model.Pais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDAOMariaDB {
    private String user;
    private String password;
    private String url;

    public PaisDAOMariaDB() {
        this.user = "root";
        this.password = "";
        this.url = "jdbc:mariadb://localhost:3306/mapa_mundi";
    }

    public List<Pais> consulta(String consulta){
        List<Pais> lista = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, user, password);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consulta) ) {
            while (resultado.next()) {
                int cod_continente = resultado.getInt("cod_continente");
                int id = resultado.getInt("identificador");
                String nombre = resultado.getString("nombre_pais");
                String capital = resultado.getString("capital");
                lista.add(new Pais(cod_continente, id, nombre, capital));
            }
            }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<String> PaisesEuropa(String consulta){
        List<String> lista = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, user, password);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consulta) ) {
            while (resultado.next()) {
                String cod_continente = resultado.getString("COUNT(*)");
                String nombre = resultado.getString("nombre_continente");
                // Imprimimos los resultados
                lista.add("Cantidad de paises: " + cod_continente + ", Nombre: " + nombre);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
