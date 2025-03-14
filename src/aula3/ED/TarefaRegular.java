public class TarefaRegular extends ListaDeTarefas {

    public TarefaRegular() {
        super();
    }
    @Override
    protected void add(Tarefa tarefa) {
        conjunto.add(tarefa);
    }

    @Override
    protected Tarefa getTarefa() {
        Tarefa tarefa = conjunto.get(0);
        conjunto.remove(0);
        return tarefa;
    }

    protected void exibeDadosDasTarefas() {
        this.conjunto.stream()
        .forEach( tarefa -> {
            System.out.println( tarefa.toString());
        });
    }

    @Override
    public void exibir() {
        System.out.println("=== Lista de Tarefas regulares ===");
        exibeDadosDasTarefas();
        System.out.println("");
    }

}