package aula4;

public class Controle {

    private int rodada;
    private String dificuldade;
    private double pontuacao;

    public Controle(String dificuldade) {
        this.dificuldade = dificuldade;
        this.rodada = 1;
    }

    private int[] rodarCores() {

        return null;
    }

    public int getRodada() {
        return rodada;
    }
    public void setRodada(int rodada) {
        this.rodada = rodada;
    }
    public String getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
    public double getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    

}




