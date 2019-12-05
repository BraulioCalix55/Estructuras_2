/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

import java.io.Serializable;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author User
 */
public class Arbol_B implements Serializable {

    private Nodos raiz;
    private int altura;

    public Arbol_B() {
        raiz = new Nodos(0, 0, null, true);
        Key o = new Key(-1, -0);
        altura = 0;
    }

    public Nodos getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodos raiz) {
        this.raiz = raiz;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Key search(Nodos Nodo, Key value) {

        int i = 1;
        while (i <= Nodo.getNum_hijos() && value.getLlave() > Nodo.getLlaves()[i - 1].getLlave()) {
            i++;
        }

        if (i <= Nodo.getNum_hijos() && value.getLlave() == Nodo.getLlaves()[i - 1].getLlave()) {
            return Nodo.getLlaves()[i - 1];
        }

        if (!Nodo.isHoja()) {
            return search(Nodo.getHijos()[i - 1], value);
        }

        return null;
    }

    public void Split(Nodos NodoPadre, int childIndex, Nodos newChild) {

        Nodos z = new Nodos(0, 0, null, true);
        z.Hoja = newChild.Hoja;
        z.setNum_hijos(1);
        z.getLlaves()[0] = newChild.getLlaves()[2];

        if (!newChild.Hoja) {
            z.getHijos()[0] = newChild.getHijos()[2];
            z.getHijos()[1] = newChild.getHijos()[3];

        }
        newChild.setNum_hijos(1);

        //corre nodo padre
        for (int j = NodoPadre.getNum_hijos() + 1; j >= childIndex + 1; j--) {
            NodoPadre.getHijos()[j] = NodoPadre.getHijos()[j - 1];
            NodoPadre.getLlaves()[j - 1] = NodoPadre.getLlaves()[j - 2];
        }

        NodoPadre.getHijos()[childIndex] = z;
        NodoPadre.getLlaves()[childIndex - 1] = newChild.getLlaves()[1];

        int y = NodoPadre.getNum_hijos() + 1;
        NodoPadre.setNum_hijos(y);
    }

    public void inserta_nolleno(Nodos nodo, Key value) {

        int i = nodo.getNum_hijos();

        if (nodo.isHoja()) {

            while (i >= 1 && value.getLlave() < nodo.getLlaves()[i - 1].getLlave()) {

                nodo.getLlaves()[i] = nodo.getLlaves()[i - 1];
                i--;
            }
            nodo.getLlaves()[i] = value;
            int y = nodo.getNum_hijos() + 1;
            nodo.setNum_hijos(y);
        } else {

            while (i >= 1 && value.getLlave() < nodo.getLlaves()[i - 1].getLlave()) {
                i--;
            }
            i++;

            if (nodo.getHijos()[i - 1].getNum_hijos() == 3) {

                Split(nodo, i, nodo.getHijos()[i - 1]);

                if (value.getLlave() > nodo.getLlaves()[i - 1].getLlave()) {

                    i++;
                }
            }
            inserta_nolleno(nodo.getHijos()[i - 1], value);
        }
    }

    public  void insert(Key Llave) {
        Nodos nodo_raiz = raiz;
        if (nodo_raiz.getNum_hijos() == 3) {

            Nodos nodo_temp = new Nodos(0, 0, null, true);

            raiz = nodo_temp;
            nodo_temp.setNum_hijos(0);

            nodo_temp.Hoja = false;
            nodo_temp.getHijos()[0] = nodo_raiz;

            Split(nodo_temp, 1, nodo_raiz);

            inserta_nolleno(nodo_temp, Llave);
        } else {
            inserta_nolleno(nodo_raiz, Llave);
        }
    }
    
    public void printBtree(Nodos node, String indent) {

        if (node == null) {
            System.out.println(indent + "El arbol esta vacío...");
        } else {
            System.out.println(indent + " ");

            String childIndent = indent + "\t";

            for (int i = node.getNum_llaves() - 1; i >= 0; i--) {
                if (!node.Hoja) {
                    printBtree(node.getHijos()[i], childIndent);
                }

                if (node.getLlaves()[i].getLlave() > 0) {
                    System.out.println(childIndent + node.getLlaves()[i].getLlave());
                }
            }
            if (!node.Hoja) {
                printBtree(node.getHijos()[node.getNum_llaves()], childIndent);
            }
        }

    }

    public boolean eliminar(Nodos node, Key value) {
        int i = 1;
        while (i <= node.getNum_hijos() && value.getLlave() > node.getLlaves()[i - 1].getLlave()) {
            i++;
        }
        if (node.Hoja) {
            if (i <= node.getNum_hijos() && value.getLlave() == node.getLlaves()[i - 1].getLlave()) {
                node.getLlaves()[i - 1].setLlave(0);

                for (int j = i - 1; j < node.getNum_hijos() - 1; j++) {//mueve el valor que se elimio alfinal
                    node.getLlaves()[j] = node.getLlaves()[j + 1];
                    if (j + 1 == node.getNum_hijos() - 1) {
                        node.setNum_hijos(node.getNum_hijos() - 1);
                    }
                }
                return true;
            }
        } else {
            return eliminar(node.getHijos()[i - 1], value);
        }
        return false;
    }
    public void imprimir_arblo(Nodos nodo_actual, int num) { 
        //se debe iniciar num en 0 a la hora de llamar el metodo
        for (int i = 0; i < nodo_actual.getLlaves().length; i++) {
            if (nodo_actual.getLlaves()[i] != null) {
                System.out.println("llave: " + nodo_actual.getLlaves()[i].getLlave() + ", nivel:" + num);
            }
        }
        //si no es hoja, se llama el metodo recursivo pero ahora con su hijo
        if (nodo_actual.Hoja==false) {
            for (int i = 0; i < nodo_actual.getHijos().length; i++) {
                if (nodo_actual.getHijos()[i] != null) {
                    imprimir_arblo(nodo_actual.getHijos()[i], num + 1);
                }
            }
        }
    }
}