package aula3.ED;

public class GerenciadorTarefas {
    
    private TarefaPrioritaria tfPrior = new TarefaPrioritaria();
    private TarefaNumerica tfNum = new TarefaNumerica();
    private TarefaRegular tfReg = new TarefaRegular();

    public void addTarefaRegular(Tarefa tarefa) {
        tfReg.add(tarefa);
    }

    public void addTarefaPrioritaria(Tarefa tarefa) {
        tfPrior.add(tarefa);
    }

    public void addTarefaComPrioridade(Tarefa tarefa) {
        tfNum.add(tarefa);
    }

    public void processarProximaTarefa(){
        if (!tfPrior.getConjunto().isEmpty()) {
            tfPrior.getTarefa().toString();

        } else if (!tfNum.getConjunto().isEmpty()) {

            tfNum.getTarefa().toString();
        } else {
            tfReg.getTarefa().toString();
        }
    }

    public void exibir() {
        tfPrior.exibir();
        tfNum.exibir();
        tfReg.exibir();
    }
}
