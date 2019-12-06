/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_2;

/**
 *
 * @author User
 */
public class posiciones {

    private long apunta;
    private long byte_offset;
    private int size;

    public posiciones(long apunta, long byte_offset, int size) {
        this.apunta = apunta;
        this.byte_offset = byte_offset;
        this.size = size;
    }

    public posiciones() {
    }

    public long getApunta() {
        return apunta;
    }

    public void setApunta(long apunta) {
        this.apunta = apunta;
    }

    public long getByte_offset() {
        return byte_offset;
    }

    public void setByte_offset(long byte_offset) {
        this.byte_offset = byte_offset;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "posiciones{" + "apunta=" + apunta + ", byte_offset=" + byte_offset + ", size=" + size + '}';
    }
    
}
