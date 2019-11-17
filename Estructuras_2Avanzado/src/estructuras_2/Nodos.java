/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Nodos implements Serializable{
    
    private int num_hijos;
    private int num_llaves;
    private Nodos Padre;
    private Nodos[] hijos = new Nodos[4];
    private Key[] llaves = new Key[3];
    public boolean Hoja;

    public Nodos(int num_hijos, int num_llaves, Nodos Padre, boolean Hoja) {
        this.num_hijos = num_hijos;
        this.num_llaves = num_llaves;
        this.Padre = Padre;
        this.Hoja = Hoja;
    }
    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }

    public int getNum_llaves() {
        return num_llaves;
    }

    public void setNum_llaves(int num_llaves) {
        this.num_llaves = num_llaves;
    }

    public Nodos getPadre() {
        return Padre;
    }

    public void setPadre(Nodos Padre) {
        this.Padre = Padre;
    }

    public Nodos[] getHijos() {
        return hijos;
    }

    public void setHijos(Nodos[] hijos) {
        this.hijos = hijos;
    }

    public Key[] getLlaves() {
        return llaves;
    }

    public void setLlaves(Key[] llaves) {
        this.llaves = llaves;
    }

    public boolean isHoja() {
        return Hoja;
    }

    public void setHoja(boolean Hoja) {
        this.Hoja = Hoja;
    }
    public void addLlave(Key Lla, Nodos nodo) {
        if (nodo.getNum_llaves() < 5) {
            llaves[nodo.num_llaves] = Lla;
            num_llaves++;
        } else {
        }
    }

    public void addHijo(Nodos nodo) {
        if (nodo.getNum_hijos() < 5) {
            hijos[nodo.num_hijos] = nodo;
            num_hijos++;
        } else {
        }
    }

    
}
