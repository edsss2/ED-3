package aula3.ED;


public class TarefaNumerica extends TarefaRegular{

    @Override
    protected void add(Tarefa tarefa) {
        if(conjunto.isEmpty()) {
            conjunto.add(tarefa);
        } else {
            for (int i = 0; i < conjunto.size(); i++) {
                if (tarefa.getGraudPrioridade() > conjunto.get(i).getGraudPrioridade()){
                    conjunto.add(i, tarefa);
                    break;
                }
            }
        }
    }

    @Override
    public void exibir() {
        System.out.println("=== Lista de Tarefas com prioridade Numérica ===");
        exibeDadosDasTarefas();
        System.out.println("");
    }

    
}
