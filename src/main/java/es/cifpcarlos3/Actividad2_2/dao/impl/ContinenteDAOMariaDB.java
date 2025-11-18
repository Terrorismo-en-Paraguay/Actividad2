package es.cifpcarlos3.Actividad2_2.dao.impl;

import es.cifpcarlos3.Actividad2_2.model.Continente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContinenteDAOMariaDB {
    private String user;
    private String password;
    private String url;

    public ContinenteDAOMariaDB() {
        this.user = "root";
        this.password = "";
        this.url = "jdbc:mariadb://localhost:3306/mapa_mundi";
    }
    public List<Continente> consulta(String consulta) {
        List<Continente> lista = new ArrayList<>();
        try(Connection conexion = DriverManager.getConnection(this.url, this.user, this.password);
            Statement sentencia = conexion.createStatement();ResultSet resultado = sentencia.executeQuery(consulta)){
            while (resultado.next()) {
                int id = resultado.getInt("codigo");
                String nombre = resultado.getString("nombre_continente");
                lista.add(new Continente(id, nombre));
            }
        }catch (Exception ex){

        }
        return lista;
    }

    public List<String> PaisesContinente(String consulta) {
        List<String> lista = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, user, password);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consulta) ) {
            while (resultado.next()) {
                int cod_continente = resultado.getInt("COUNT(*)");
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
