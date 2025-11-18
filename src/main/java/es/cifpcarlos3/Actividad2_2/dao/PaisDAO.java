package es.cifpcarlos3.Actividad2_2.dao;

import es.cifpcarlos3.Actividad2_2.dao.impl.PaisDAOMariaDB;
import es.cifpcarlos3.Actividad2_2.model.Pais;

import java.util.ArrayList;
import java.util.List;

public class PaisDAO {
    PaisDAOMariaDB paisDAOMariaDB;

    public PaisDAO(){
        paisDAOMariaDB = new PaisDAOMariaDB();
    }

    public void ListarCapitales(){
        List<Pais> lista = paisDAOMariaDB.consulta("SELECT * FROM t_pais WHERE capital = NULL");
        lista.forEach(pais -> System.out.println(pais.toString()));
    }

    public void ListarPaisesPorContinente(){
        List<String> lista = paisDAOMariaDB.PaisesEuropa("SELECT COUNT(*), nombre_continente  FROM t_pais JOIN t_continente WHERE t_pais.cod_continente = t_continente.codigo GROUP BY cod_continente HAVING nombre_continente = 'Europa'");
        lista.forEach(System.out::println);
    }

    public void sans(){
        List<Pais> lista = paisDAOMariaDB.consulta("SELECT * FROM t_pais WHERE capital LIKE 'San%'");
        lista.forEach(pais -> System.out.println(pais.toString()));
    }
}
