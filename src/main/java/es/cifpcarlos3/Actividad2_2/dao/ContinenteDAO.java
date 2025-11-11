package es.cifpcarlos3.Actividad2_2.dao;

import es.cifpcarlos3.Actividad2_2.dao.impl.ContinenteDAOMariaDB;
import es.cifpcarlos3.Actividad2_2.model.Continente;

public class ContinenteDAO {
    ContinenteDAOMariaDB databas;

    public ContinenteDAO() {
        this.databas = new  ContinenteDAOMariaDB();
    }


}
