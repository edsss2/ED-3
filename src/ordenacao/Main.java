package ordenacao;

public class Main {
    static AlgoritimosOrdenacao ao = new AlgoritimosOrdenacao();

    public static void main(String[] args) {
        int[] vetor = new int[10];
        int a = 0;
        for(int i = 9; i > -1; i--) {
            vetor[a] = i;
            a++;
        }
        int[] outroVetor = ao.ordenacao(vetor);
        for(int i = 0; i < vetor.length; i++) {
            System.out.println(outroVetor[i]);
        }
    }
    
}
