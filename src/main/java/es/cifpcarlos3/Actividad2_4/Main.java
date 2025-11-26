package es.cifpcarlos3.Actividad2_4;

import es.cifpcarlos3.Actividad2_2.dao.ContinenteDAO;
import es.cifpcarlos3.Actividad2_2.dao.PaisDAO;
import es.cifpcarlos3.Actividad2_4.dao.ClienteDAO;
import es.cifpcarlos3.Actividad2_4.dao.CuentaDAO;
import es.cifpcarlos3.Actividad2_4.dao.impl.ClienteDAOImpl;
import es.cifpcarlos3.Actividad2_4.dao.impl.CuentaDAOImpl;
import es.cifpcarlos3.Actividad2_4.model.Cliente;
import es.cifpcarlos3.Actividad2_4.model.Cuenta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        CuentaDAO cuentaDAO = new CuentaDAO();
        Scanner numero = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("Que quieres hacer:");
            System.out.println("1. Listar todos los clientes");
            System.out.println("2. Listar todas las cuentas con su titular");
            System.out.println("3. Insertar nuevo cliente");
            System.out.println("4. Insertar nueva cuenta para un cliente");
            System.out.println("5. Actualizar saldo de una cuenta");
            System.out.println("6. Transferir saldo entre dos cuentas");
            System.out.println("7. Eliminar cliente (si no tiene cuentas)");
            System.out.println("0. Salir");
            System.out.println("Opcion: ");
            opcion = numero.nextInt();
            switch (opcion) {
                case 1:
                    clienteDAO.consultaall();
                    break;
                case 2:
                    cuentaDAO.consultaCuenta();
                    break;
                case 3:
                    Scanner numero2 = new Scanner(System.in);
                    System.out.println("Ingrese su titular: ");
                    String titular = numero2.next();
                    System.out.println("Ingrese su dni: ");
                    String dni = numero2.next();
                    System.out.println("Ingrese su telefono: ");
                    int telefono = numero2.nextInt();
                    System.out.println("Ingrese su email: ");
                    String email = numero2.next();
                    clienteDAO.insertarCLIente(new Cliente(0, dni, titular, telefono, email));
                    break;
                case 4:
                    Scanner numero3 = new Scanner(System.in);
                    System.out.println("Ingrese su numero de cuenta: ");
                    String numeroCuenta = numero3.next();
                    System.out.println("Ingrese su id de cliente: ");
                    int idCliente = numero3.nextInt();
                    System.out.println("Ingrese su saldo: ");
                    float saldo = numero3.nextFloat();
                    cuentaDAO.insertarCuenta(new Cuenta(0, numeroCuenta, idCliente, saldo));
                    break;
                    case 5:
                        Scanner numero4 = new Scanner(System.in);
                        System.out.println("Ingrese su numero de cuenta: ");
                        String numeroCuenta2 = numero4.next();
                        System.out.println("Ingrese su nuevo saldo: ");
                        float saldo2 = numero4.nextFloat();
                        cuentaDAO.actualizarSaldo(new Cuenta(0, numeroCuenta2, 0, saldo2));
                        break;
                case 6:
                    Scanner numero5 = new Scanner(System.in);
                    System.out.println("Ingrese su numero de cuenta: ");
                    String numeroCuenta3 = numero5.next();
                    System.out.println("Ingrese de la cuenta a intercambiar: ");
                    String numeroCuenta4 = numero5.next();
                    cuentaDAO.intercambiarSaldos(numeroCuenta3, numeroCuenta4);
                    break;

            }
        }while(opcion!=0);

    }
}
