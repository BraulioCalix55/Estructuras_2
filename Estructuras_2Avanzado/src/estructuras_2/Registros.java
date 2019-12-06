/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

/**
 *
 * @author ricky
 */
public class Registros {
    int num_camp;
    String arreglo[];
    int posicion;

    public Registros() {
    }

    public Registros(int num_camp, String[] arreglo, int posicion) {
        this.num_camp = num_camp;
        this.arreglo = arreglo;
        this.posicion = posicion;
    }

    public int getNum_camp() {
        return num_camp;
    }

    public void setNum_camp(int num_camp) {
        this.num_camp = num_camp;
    }

    public String[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(String[] arreglo) {
        this.arreglo = arreglo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void setTama(int tamano){
        arreglo=new String[tamano];
    }

    @Override
    public String toString() {
        return "Registros{" + "num_camp=" + num_camp + ", arreglo=" + arreglo + ", posicion=" + posicion + '}';
    }
    
}
