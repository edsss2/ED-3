package aula3.ED;


public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciadorTf = new GerenciadorTarefas();

        Tarefa tf = new Tarefa("Enviar relatório", "05/03/2025");
        Tarefa tf1 = new Tarefa("Resolver um problema", "06/03/2025");
        tf1.setGraudPrioridade(1);
        Tarefa tf2 = new Tarefa("Atualizar banco de dados", "30/01/2025");
        Tarefa tf3 = new Tarefa("Estudar JavaScript", "02/12/2026");
        Tarefa tf4 = new Tarefa("Realizar lição de casa", "27/02/2024");
        tf4.setGraudPrioridade(4);
        Tarefa tf5 = new Tarefa("Ultima tarefa", "02/03/2025");

        gerenciadorTf.addTarefaPrioritaria(tf);
        gerenciadorTf.addTarefaComPrioridade(tf1);
        gerenciadorTf.addTarefaRegular(tf2);
        gerenciadorTf.addTarefaPrioritaria(tf3);
        gerenciadorTf.addTarefaComPrioridade(tf4);
        gerenciadorTf.addTarefaRegular(tf5);

        gerenciadorTf.processarProximaTarefa();
        gerenciadorTf.processarProximaTarefa();
        gerenciadorTf.processarProximaTarefa();
        
        gerenciadorTf.exibir();
    }
}
