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

    public void splitChild(Nodos NodoPadre, int childIndex, Nodos newChild) {

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

    public void insert_nonfull(Nodos nodo, Key value) {

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

                splitChild(nodo, i, nodo.getHijos()[i - 1]);

                if (value.getLlave() > nodo.getLlaves()[i - 1].getLlave()) {

                    i++;
                }
            }
            insert_nonfull(nodo.getHijos()[i - 1], value);
        }
    }

    public void insert(Key k) {
        Nodos r = raiz;
        if (r.getNum_hijos() == 3) {

            Nodos s = new Nodos(0, 0, null, true);

            raiz = s;
            s.setNum_hijos(0);

            s.Hoja = false;
            s.getHijos()[0] = r;

            splitChild(s, 1, r);

            insert_nonfull(s, k);
        } else {
            insert_nonfull(r, k);
        }
    }
    
    public void printBtree(Nodos node, String indent) {

        if (node == null) {
            System.out.println(indent + "The B-Tree is Empty");
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

    public boolean delete(Nodos node, Key value) {

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
            return delete(node.getHijos()[i - 1], value);
        }
        return false;
    }
}
