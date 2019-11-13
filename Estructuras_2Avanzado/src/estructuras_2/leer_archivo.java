/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class leer_archivo {

    public static Metadata main(String ruta) throws FileNotFoundException {
        ArrayList<Campos> lista_campos = new ArrayList();
        Metadata metadata = null;
        try {
            Scanner input = new Scanner(new File(ruta));
            while (input.hasNextLine()) {
                String line = input.next();
                String[] arreglo = line.split(";");
                int num_campos = Integer.parseInt(arreglo[0]);
                boolean registros;
                if (arreglo[1] == "0") {
                    registros = false;
                } else {
                    registros = true;
                }
                int cabeza = Integer.parseInt(arreglo[2]);
                String campos[] = arreglo[3].split(",");
                ArrayList lista = new ArrayList();
                for (int i = 0; i < campos.length - 1; i++) {
                    String nombre[] = campos[i].split("=");
                    lista.add(nombre[1]);
                    i++;
                }
                System.out.println("num campos: " + (num_campos) * 2);
                for (int j = 0; j < (lista.size()) / 2; j++) {
                    lista_campos.add(new Campos(lista.get(j).toString(), lista.get(j + 1).toString()));
                    for (int i = 0; i < campos.length; i++) {
                        String nombre[] = campos[i].split("=");
                        lista.add(nombre[1]);
                    }

                    for (int i = 0; i < lista.size(); i++) {
                        lista_campos.add(new Campos(lista.get(i).toString(), lista.get(i + 1).toString()));
                        i++;
                    }
                    metadata = new Metadata(num_campos, lista_campos, registros, cabeza);

                }
                input.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return metadata;
    }
}
