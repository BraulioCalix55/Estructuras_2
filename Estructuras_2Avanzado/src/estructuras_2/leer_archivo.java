/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class leer_archivo {

    public static Metadata main(String ruta) {
        ArrayList<Campos> lista_campos = new ArrayList();
        Metadata metadata = null;
        try {
            Scanner input = new Scanner(new File(ruta));
            while (input.hasNextLine()) {
                String line = input.next();
                String[] arreglo = line.split(";");
                int num_campos = Integer.parseInt(arreglo[0]);
                boolean registros;
                if (arreglo[1] == "false") {
                    registros = false;
                } else {
                    registros = true;
                }
                int cabeza = Integer.parseInt(arreglo[2]);
                String campos[] = arreglo[3].split(",");
                ArrayList lista = new ArrayList();
                for (int i = 0; i < campos.length; i++) {
                    lista_campos.add(new Campos(campos[i], campos[i + 1]));
                    i++;
                }
                int longitud = Integer.parseInt(arreglo[4]);
                metadata = new Metadata(num_campos, lista_campos, registros, cabeza, longitud);
            }
            input.close();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return metadata;
    }

    public static void escribir(Metadata meta, File archivo) {
        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(meta.toString());
            bw.close();

        } catch (IOException ex) {

        }
    }

    public static void Archivo10000(File Archivo) throws IOException {
        ArrayList<String> Nombres = new ArrayList();
        Nombres.add("Leonardo");
        Nombres.add("Daniel");
        Nombres.add("David");
        Nombres.add("Marcelo");
        Nombres.add("Andres");
        Nombres.add("Luis");
        Nombres.add("Raul");
        Nombres.add("Miguel");
        Nombres.add("Carlos");
        Nombres.add("Juan");
        Nombres.add("Ricardo");
        Nombres.add("Andrea");
        Nombres.add("Linda");
        Nombres.add("Fernanda");
        Nombres.add("Dunia");
        Nombres.add("Maria");
        Nombres.add("Renato");
        Nombres.add("Alvaro");
        ArrayList<String> Carrera = new ArrayList();
        Carrera.add("Ing.Sistemas");
        Carrera.add("Ing.Industrial");
        Carrera.add("Ing.Energia");
        Carrera.add("Ing.Teleco");
        Carrera.add("Ing.Civil");
        Carrera.add("Ing.Biomedica");
        Carrera.add("Ing.Meca");
        Carrera.add("Lic.Finanzas");
        Carrera.add("lic.Derecho");
        Carrera.add("lic.Admin");
        Carrera.add("lic.turismo");
        Carrera.add("lic.economia");
        Carrera.add("lic.Periodismo");
        Carrera.add("lic.nutricion");
        Carrera.add("lic.medicina");
        Carrera.add("lic.terapia");
        Carrera.add("Ing.Quimica");
        Carrera.add("lic.Astronomia");
        ArrayList<String> Apellidos = new ArrayList();
        Apellidos.add("Montesinos");
        Apellidos.add("Montalvan");
        Apellidos.add("Gonzalez");
        Apellidos.add("Larios");
        Apellidos.add("Calix");
        Apellidos.add("Romero");
        Apellidos.add("Martinez");
        Apellidos.add("Perez");
        Apellidos.add("Sosa");
        Apellidos.add("Torres");
        Apellidos.add("Acosta");
        Apellidos.add("Mejia");
        Apellidos.add("Flores");
        Apellidos.add("Luna");
        Apellidos.add("Dominguez");
        Apellidos.add("Sagastume");
        Apellidos.add("Castro");
        Apellidos.add("Fernandez");
        RandomAccessFile f = new RandomAccessFile(Archivo, "rw");
        f.seek(0);
        f.writeBytes("5;truee;-1;valor,int,apellido,String,nombre,String,carrera,String,edad,int,;");
        f.seek(400);
        Random r = new Random();
        ArrayList lista = new ArrayList();
        for (int i = 0; i <= 10000; i++) {
            String nombre = Nombres.get((int) Math.floor(Math.random() * 18));
            String apellido = Apellidos.get((int) Math.floor(Math.random() * 18));
            String estudia = Carrera.get((int) Math.floor(Math.random() * 18));
            int edad = 17 + r.nextInt(26);
            String registro = i + 1 + "," + apellido + "," + nombre + "," + estudia + "," + edad + ",;";
            long posicion = f.getFilePointer();
            f.writeBytes(registro);
            String cadena = i + "," + posicion + ";";
            lista.add(cadena);
        }
        f.close();
        RandomAccessFile f2 = new RandomAccessFile("arbol10k.txt", "rw");
        for (int i = 0; i < lista.size(); i++) {
            f2.writeBytes(lista.get(i).toString());
        }
        f2.close();
    }
    public static ArrayList<Registros> leeArchivos(File archivo,Metadata meta){
    ArrayList <Registros> registros = new ArrayList();
        try {
            Scanner input = new Scanner(archivo);
        } catch (FileNotFoundException ex) {
            
        }
    
    
    return registros;
    }
}
