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
public class Key implements Serializable {

    private int llave;
    private long pos;

    public Key(int llave, long pos) {
        this.llave = llave;
        this.pos = pos;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public long getPos() {
        return pos;
    }

    public void setPos(long pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Key{" + "llave=" + llave + ", pos=" + pos + '}';
    }

}
