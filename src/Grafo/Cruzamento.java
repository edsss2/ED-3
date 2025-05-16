package grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cruzamento {
    List<Rua> ruas = new ArrayList<>();

    private int id = 0;
    private int[] coordenadas;
    boolean isVisitado = false;

    public Cruzamento(int[] coordenadas) {
        this.coordenadas = coordenadas;
        id++;
    }

    public List<Rua> getRuas() { 
        return ruas; 
    }

    public void setRuas(List<Rua> ruas) {
        this.ruas = ruas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(int[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "Cruzamento [ruas=" + ruas + ", id=" + id + ", coordenadas=" + Arrays.toString(coordenadas) + "]";
    }

    

    
}
