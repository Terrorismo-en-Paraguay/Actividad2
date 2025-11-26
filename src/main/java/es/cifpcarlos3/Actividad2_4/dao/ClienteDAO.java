package es.cifpcarlos3.Actividad2_4.dao;

import es.cifpcarlos3.Actividad2_4.dao.impl.ClienteDAOImpl;
import es.cifpcarlos3.Actividad2_4.model.Cliente;

import java.util.List;

public class ClienteDAO {
    ClienteDAOImpl clienteDAO;

    public ClienteDAO(){
        clienteDAO = new ClienteDAOImpl();
    }

    public void consultaall(){
        List<Cliente> lista = clienteDAO.consulta("select * from t_cliente");
        lista.forEach(System.out::println);
    }

    public void insertarCLIente(Cliente cliente){
        clienteDAO.insertarCliente(cliente);
    }
}
