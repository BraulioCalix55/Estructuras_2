
package estructuras_2;
import java.io.Serializable;
/**
 *
 * @author User
 */
public class Campos implements Serializable{
     private String nombre;
    private String tipo;

    public Campos() {
    }

    public Campos(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return " nombre= " + nombre + ", tipo= " + tipo;
    }
    
}
