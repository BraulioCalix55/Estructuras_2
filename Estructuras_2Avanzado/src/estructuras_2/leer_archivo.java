/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                  //  System.out.println("nombre[1]"+nombre[1]);
                    lista.add(nombre[1]);
                }
                //System.out.println("holi");
                for (int i = 0; i < lista.size(); i++) {
                    lista_campos.add(new Campos(lista.get(i).toString(), lista.get(i+1).toString()));
                    i++;
                }
                System.out.println("asasanum "+num_campos);
                metadata= new Metadata(num_campos, lista_campos, registros, cabeza);
            }
            input.close();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        System.out.println("return");
        
        return metadata;
    }
    
    public static void escribir(Metadata meta,File archivo){
    try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(meta.toString());
            bw.close();

        } catch (IOException ex) {
            //Logger.getLogger(P_Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
