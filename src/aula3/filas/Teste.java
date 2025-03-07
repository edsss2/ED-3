package aula3.filas;


public class Teste {
    public static void main(String[] args){
        Fila filaBanco = new Fila();
        filaBanco.add(new Pessoa("Pedro",15));
        filaBanco.add(new Pessoa("Mario",50));
        filaBanco.add(new Pessoa("Maria",61));
        filaBanco.add(new Pessoa("Jose",20));
        filaBanco.add(new Pessoa("Carlos",70));
        filaBanco.add(new Pessoa("Mauricio",65));

        System.out.println("=== Fila Prioridade ===");

        while (filaBanco.tamanho()>0) {
            Pessoa p=filaBanco.remover();
            System.out.println(p.getNome() + " - " + p.getIdade());
        }
    //Saída Esperada: Maria, Carlos, Mauricio, Pedro, Mario, Jose
    }
}
