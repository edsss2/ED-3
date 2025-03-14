import java.util.ArrayList;
import java.util.List;

public abstract class ListaDeTarefas {
    protected List<Tarefa> conjunto;

    protected ListaDeTarefas() {
        conjunto = new ArrayList<>();
    }

    protected abstract void add(Tarefa tarefa);
    protected abstract Tarefa getTarefa();
    protected abstract void exibir();

    public List<Tarefa> getConjunto() {
        return conjunto;
    }

    
}
