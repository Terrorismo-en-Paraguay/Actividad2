package es.cifpcarlos3.Actividad2_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner opcion = new Scanner(System.in);

        System.out.println("Que quieres hacer:");
        System.out.println("1. Listar paises sin capital");
        System.out.println("2. Nº de paises por continente");
        System.out.println("3. Paises de Europa");
        System.out.println("4. Capitales que empiezan por 'San'");
        switch (opcion.nextInt()) {
            case 1:
                Listarcapitales();
                break;
            case 2:
                PaisesContinente();
                break;
            case 3:
                PaisesEuropa();
                break;
            case 4:
                San();
                break;

        }
    }

    public static void San(){
        String URL = "jdbc:mariadb://localhost:3306/mapa_mundi"; //MySQL
        String USER = "root";
        String PASSWORD = "";
        String consultaSQL = "SELECT capital FROM t_pais WHERE capital LIKE 'San%'";
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consultaSQL) ) {
            while (resultado.next()) {
                String nombre = resultado.getString("capital");
                // Imprimimos los resultados
                System.out.println("Nombre: " + nombre);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void PaisesContinente(){
        String URL = "jdbc:mariadb://localhost:3306/mapa_mundi"; //MySQL
        String USER = "root";
        String PASSWORD = "";
        String consultaSQL = "SELECT COUNT(*), nombre_continente  FROM t_pais JOIN t_continente WHERE t_pais.cod_continente = t_continente.codigo GROUP BY cod_continente";
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consultaSQL) ) {
            while (resultado.next()) {
                String cod_continente = resultado.getString("COUNT(*)");
                String nombre = resultado.getString("nombre_continente");
                // Imprimimos los resultados
                System.out.println("Cantidad de paises: " + cod_continente + ", Nombre: " + nombre);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void PaisesEuropa(){
        String URL = "jdbc:mariadb://localhost:3306/mapa_mundi"; //MySQL
        String USER = "root";
        String PASSWORD = "";
        String consultaSQL = "SELECT COUNT(*), nombre_continente  FROM t_pais JOIN t_continente WHERE t_pais.cod_continente = t_continente.codigo GROUP BY cod_continente HAVING nombre_continente = 'Europa'";
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consultaSQL) ) {
            while (resultado.next()) {
                String cod_continente = resultado.getString("COUNT(*)");
                String nombre = resultado.getString("nombre_continente");
                // Imprimimos los resultados
                System.out.println("Cantidad de paises: " + cod_continente + ", Nombre: " + nombre);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void Listarcapitales(){
        String URL = "jdbc:mariadb://localhost:3306/mapa_mundi"; //MySQL
        String USER = "root";
        String PASSWORD = "";
        String consultaSQL = "SELECT * FROM t_pais WHERE capital = NULL";
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement sentencia = conexion.createStatement();
             ResultSet resultado = sentencia.executeQuery(consultaSQL) ) {
            while (resultado.next()) {
                String cod_continente = resultado.getString("cod_continente");
                String id = resultado.getString("identificador");
                String nombre = resultado.getString("nombre_pais");
                String capital = resultado.getString("capital");
                // Imprimimos los resultados
                System.out.println("Codigo continente: " + cod_continente + ", Nombre: " + nombre + ", Capital: " + capital);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}