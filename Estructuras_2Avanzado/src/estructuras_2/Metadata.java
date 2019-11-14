package estructuras_2;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Metadata implements Serializable{
    private int num_campos;
    private ArrayList<Campos> lista_campos;
    private boolean registros;
    private int firstavail;

    public Metadata() {
    registros=false;
    }

    public Metadata(int num_campos, ArrayList<Campos> lista_campos, boolean registros) {
        this.num_campos = num_campos;
        this.lista_campos = lista_campos;
        this.registros = registros;
        this.firstavail = -1;
    }

    public Metadata(int num_campos, ArrayList<Campos> lista_campos, boolean registros, int firstavail) {
        this.num_campos = num_campos;
        this.lista_campos = lista_campos;
        this.registros = registros;
        this.firstavail = firstavail;
    }


    

    public int getNum_campos() {
        return num_campos;
    }

    public void setNum_campos(int num_campos) {
        this.num_campos = num_campos;
    }

    public ArrayList<Campos> getLista_campos() {
        return lista_campos;
    }

    public void setLista_campos(ArrayList<Campos> lista_campos) {
        this.lista_campos = lista_campos;
    }

    public boolean isRegistros() {
        return registros;
    }

    public void setRegistros(boolean registros) {
        this.registros = registros;
    }

    public int getFirstavail() {
        return firstavail;
    }

    public void setFirstavail(int firstavail) {
        this.firstavail = firstavail;
    }
    
}