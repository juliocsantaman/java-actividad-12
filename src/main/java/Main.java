
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Julio Cesar Santaman Cruz.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        String file = "contacts.txt";
        String option;
        String res = "";

        do {
            System.out.println("***** Bienvenido a tu Agenda Telefónica *****");
            System.out.println("1. Mostrar los contactos de la agenda.");
            System.out.println("2. Crear un nuevo contacto.");
            System.out.println("3. Borrar un contacto.");
            System.out.println("0. Salir.");
            System.out.println("Elige una opción: ");
            option = scanner.next();
            
            switch(option) {
                case "1":
                    // Mostrar los contactos de la agenda.
                    addressBook.load(file);
                    addressBook.list();
                    break;
                    
                case "2":
                    // Crear un nuevo contacto.
                    addressBook.create(file);
                    break;
                    
                case "3":
                    // Borrar un contacto.
                    addressBook.delete(file);
                    break;
                    
                case "0":
                    // Salir de la app.
                    System.out.println("Aplicación finalizada.");
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
            }
            
            do {
                System.out.println("¿Deseas volver a ejecutar el programa?");
                System.out.println("Escribe si o no: ");
                scanner.nextLine();
                res = scanner.next();
                res = res.toLowerCase();

                if (!res.equals("si") && !res.equals("no")) {
                    System.out.println("No has escrito una respuesta correcta.");
                    System.out.println("Recuerda que solo es si o no.");
                }

            } while (!res.equals("si") && !res.equals("no"));
            
            System.out.println();
            scanner.nextLine();

        } while (res.equals("si"));

        System.out.println("Aplicación finalizada.");
    }

}
