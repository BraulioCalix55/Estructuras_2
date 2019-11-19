/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class leer_archivo {
    public static Metadata main(String ruta) {
        ArrayList <Campos>lista_campos= new ArrayList();
        Metadata metadata= null;
        try {
            Scanner input = new Scanner(new File(ruta));
            while (input.hasNextLine()) {
                String line = input.next();
                String []arreglo=line.split(";");
                int num_campos=Integer.parseInt(arreglo[0]);
                boolean registros;
                if (arreglo[1]=="0") {
                    registros=true;
                }else{
                    registros=false;
                }
                int cabeza=Integer.parseInt(arreglo[2]);
                String campos[]=arreglo[3].split(",");
                ArrayList lista= new ArrayList();
                for (int i = 0; i < campos.length; i++) {
                    String nombre[]=campos[i].split("=");
                    System.out.println(nombre[1]);
                    lista.add(nombre[1]);
                }
                for (int i = 0; i < lista.size(); i++) {
                    lista_campos.add(new Campos(lista.get(i).toString(), lista.get(i+1).toString()));
                    i++;
                }
                metadata= new Metadata(num_campos, lista_campos, registros, cabeza);
            }
            input.close();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return metadata;
    }
}
