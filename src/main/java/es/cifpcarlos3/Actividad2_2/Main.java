package es.cifpcarlos3.Actividad2_2;

import es.cifpcarlos3.Actividad2_2.dao.ContinenteDAO;
import es.cifpcarlos3.Actividad2_2.dao.PaisDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PaisDAO paisDAO = new PaisDAO();
        ContinenteDAO continenteDAO = new ContinenteDAO();
        Scanner opcion = new Scanner(System.in);

        System.out.println("Que quieres hacer:");
        System.out.println("1. Listar paises sin capital");
        System.out.println("2. Nº de paises por continente");
        System.out.println("3. Paises de Europa");
        System.out.println("4. Capitales que empiezan por 'San'");
        switch (opcion.nextInt()) {
            case 1:
                paisDAO.ListarCapitales();
                break;
            case 2:
                paisDAO.ListarPaisesPorContinente();
                break;
            case 3:
                continenteDAO.ConsultarContinentes();
                break;
            case 4:
                paisDAO.sans();
                break;

        }
    }
}
