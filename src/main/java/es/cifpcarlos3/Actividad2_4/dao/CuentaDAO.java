package es.cifpcarlos3.Actividad2_4.dao;

import es.cifpcarlos3.Actividad2_4.dao.impl.CuentaDAOImpl;
import es.cifpcarlos3.Actividad2_4.model.Cuenta;

import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {
    CuentaDAOImpl cuentaDAO;

    public CuentaDAO(){
        cuentaDAO = new CuentaDAOImpl();
    }

    public void consultaCuenta(){
        List<List> lists = cuentaDAO.consultaCuenta("SELECT * FROM t_cuenta JOIN t_cliente WHERE t_cuenta.id_cliente = t_cliente.id_cliente");
        for (List cuenta : lists) {
            cuenta.forEach(System.out::println);
        }
    }

    public void insertarCuenta(Cuenta cuenta){
        cuentaDAO.insertarCuenta(cuenta);
    }

    public void actualizarSaldo(Cuenta cuenta){
        cuentaDAO.actualizarSaldo(cuenta);
    }

    public void intercambiarSaldos(String cuenta1,  String cuenta2){
        float saldo = cuentaDAO.obtenerSaldo(cuenta1);
        float saldo2 = cuentaDAO.obtenerSaldo(cuenta2);
        cuentaDAO.actualizarSaldo(new Cuenta(0, cuenta1, 0, saldo2));
        cuentaDAO.actualizarSaldo(new Cuenta(0, cuenta2, 0, saldo));
        System.out.println("Cambio hecho");
    }
}
