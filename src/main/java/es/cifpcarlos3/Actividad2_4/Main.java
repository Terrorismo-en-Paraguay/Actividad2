package es.cifpcarlos3.Actividad2_4;

import es.cifpcarlos3.Actividad2_2.dao.ContinenteDAO;
import es.cifpcarlos3.Actividad2_2.dao.PaisDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;

            }
        }while(opcion!=0);

    }
}
