package aula3.ED;


public class Tarefa {

    private String tarefa;
    private String dataCriacao;
    private int graudPrioridade;

    
    public Tarefa(String tarefa, String dataCriacao) {
        this.tarefa = tarefa;
        this.dataCriacao = dataCriacao;
    }


    @Override
    public String toString() {
        return "Tarefa [tarefa=" + tarefa + ", dataCriacao=" + dataCriacao + "]";
    }


    public int getGraudPrioridade() {
        return graudPrioridade;
    }


    public void setGraudPrioridade(int graudPrioridade) {
        this.graudPrioridade = graudPrioridade;
    }

    



}