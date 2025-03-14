public class TarefaPrioritaria extends ListaDeTarefas {

    private int topo = 0;

    public TarefaPrioritaria() {
        super();
    }
    
    @Override
    public void add(Tarefa tarefa) {
        conjunto.add(topo, tarefa);
        topo++;
    }

    @Override
    public Tarefa getTarefa() {
        if (topo != 0) {
            int index = topo - 1;
            Tarefa tarefa = conjunto.get(index);
            conjunto.remove(index);
            topo--;
            return tarefa;
        } else {
            Tarefa tarefa = conjunto.get(topo - 1);
            conjunto.remove(topo);
            return tarefa;
        }
    }

    @Override
    protected void exibir() {
        System.out.println("=== Lista de Tarefas Prioritarias ===");
        for(int i = conjunto.size() - 1; i > 0; i--) {
            System.out.println(conjunto.get(i).toString());
        }
        System.out.println("");
    }

    
}
