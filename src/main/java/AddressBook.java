
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
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
public class AddressBook {

    // Atributos.
    HashMap<String, String> contacts = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);

    // Métodos.
    /*
    Este método cargará la información del archivo al HashMap.
     */
    public void load(String file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                contacts.put(parts[0], parts[1]);
                // System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*
    Esté método guardará un contacto.
     */
    public void save(String file, String phone, String name) {
        BufferedWriter bufferedWriter = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write("\n" + phone + "," + name);
            System.out.println("Contacto guardado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    /*
    Esté método mostrará los contactos de la agenda.
     */
    public void list() {
        System.out.println("Contactos:");
        contacts.forEach((k, v) -> System.out.println("Número: " + k + " : Nombre: " + v));
    }

    /*
    Este método creará un contacto.
     */
    public void create(String file) {
        String name, phone;
        // Solicitando los datos.
        System.out.println("Ingresa nombre del contacto:");
        name = scanner.next();
        System.out.println("Ingresa el número teléfonico del contacto:");
        phone = scanner.next();
        // Instanciamos un objeto AddressBook.
        AddressBook addressBook = new AddressBook();
        // Llamamos al método save para guardar el nuevo contacto creado.
        addressBook.save(file, phone, name);
    }

    /*
    Esté método eliminará un contacto dependiendo del número teléfonico.
     */
    public void delete(String file) {
        String phone;
        int c = 0;
        // Solicitando datos.
        System.out.println("Ingrese el número teléfonico para eliminarlo:");
        phone = scanner.next();
        // Eliminando el contacto del HashMap.
        if (contacts.containsKey(phone)) {
            contacts.remove(phone);
            System.out.println("Contacto borrado");
            BufferedWriter bufferedWriter = null;

            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                // Actualizando la información del archivo.
                for (Map.Entry<String, String> entry : contacts.entrySet()) {
                    if (c == 0) {
                        bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                        c++;
                    } else {
                        bufferedWriter.write("\n" + entry.getKey() + "," + entry.getValue());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("No se ha encontrado algún contacto con ese número teléfonico");
        }

    }
    
    /*
    Método que buscará un contacto dependiendo del número teléfonico.
    */
    public void searchContact() {
        String phone;
        
        System.out.println("Ingrese número teléfonico para buscar el nombre del contacto:");
        phone = scanner.next(); 
        
        if(contacts.containsKey(phone)) {
            System.out.println("Contacto encontrado:");
            System.out.println("Número: " + phone + " : Nombre: " + contacts.get(phone));
        } else {
            System.out.println("Contacto NO encontrado");
        }
    }
}
