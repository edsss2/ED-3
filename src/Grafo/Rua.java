package Grafo;

public class Rua {

    private Cruzamento origem;
    private Cruzamento destino;
    private String nome;
    private float distanciaTotal;
    private boolean direcionada;

    public Rua(Cruzamento origem, Cruzamento destino, String nome, float distanciaTotal, boolean direcionada) {
        this.origem = origem;
        this.destino = destino;
        this.nome = nome;
        this.distanciaTotal = distanciaTotal;
        this.direcionada = direcionada;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }

    public Cruzamento getOrigem() {
        return origem;
    }

    public void setOrigem(Cruzamento origem) {
        this.origem = origem;
    }

    public Cruzamento getDestino() {
        return destino;
    }

    public void setDestino(Cruzamento destino) {
        this.destino = destino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(float distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }



    public boolean isDirecionada() {
        return direcionada;
    }



    public void setDirecionada(boolean direcionada) {
        this.direcionada = direcionada;
    }

}
