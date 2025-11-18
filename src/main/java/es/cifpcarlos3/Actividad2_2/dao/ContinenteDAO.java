package es.cifpcarlos3.Actividad2_2.dao;

import es.cifpcarlos3.Actividad2_2.dao.impl.ContinenteDAOMariaDB;
import es.cifpcarlos3.Actividad2_2.model.Continente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContinenteDAO {
    ContinenteDAOMariaDB databas;

    public ContinenteDAO() {
        this.databas = new  ContinenteDAOMariaDB();
    }

    public void ConsultarContinentes(){
        List<String> lista = databas.PaisesContinente("SELECT COUNT(*), nombre_continente  FROM t_pais JOIN t_continente WHERE t_pais.cod_continente = t_continente.codigo GROUP BY cod_continente");
        lista.forEach(System.out::println);
    }
}
