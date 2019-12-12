/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

import java.util.ArrayList;

/**
 *
 * @author ricky
 */
public class Registros {

    int num_camp;
    ArrayList lista;

    long posicion;

    public Registros() {
    }

    public Registros(int num_camp, ArrayList lista, long posicion) {
        this.num_camp = num_camp;
        this.lista = lista;
        this.posicion = posicion;
    }

    public int getNum_camp() {
        return num_camp;
    }

    public void setNum_camp(int num_camp) {
        this.num_camp = num_camp;
    }

    public ArrayList getLista() {
        return lista;
    }

    public void setLista(ArrayList lista) {
        this.lista = lista;
    }

    public long getPosicion() {
        return posicion;
    }

    public void setPosicion(long posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
