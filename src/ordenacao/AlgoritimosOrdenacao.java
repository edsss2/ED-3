package ordenacao;

public class AlgoritimosOrdenacao {
    
    public void buscaLinear(int[] vetor, int valor) {
        for(int i = 0; i< vetor.length; i++) {
            if(valor == vetor[i]){
                System.out.println("Encontrado na posição: " + i);
            }
        }
    }

    public int buscaBinaria(int[] vetor, int valor) {
        int inicio = 0;
        int fim = vetor.length-1;
        if(valor == vetor[fim]) {
            return fim;
        } else  if(valor == vetor[inicio]){
            return inicio;
        }
        return buscaBinaria(vetor, valor, inicio, fim);
    }

    public int buscaBinaria(int[] vetor, int valor, int inicio, int fim) {
        int indice = (inicio + fim) /2;
        if (inicio == fim - 1) {
            return -1;
        }

        if(valor > vetor[indice]) {
            inicio = indice;
        } else if(valor < vetor[indice]) {
            fim = indice;
        } else {
            return indice;
        }

        return buscaBinaria(vetor, valor, inicio, fim);
    }

    public int[] ordenacao(int[] vetor) {
        for(int x = 0; x < vetor.length; x++) {
            for(int y = 0; y < vetor.length - 1; y++) {
                if(vetor[y] > vetor[y + 1]) {
                    int aux = vetor[y + 1];
                    vetor[y + 1] = vetor[y];
                    vetor[y] = aux;
                }
            }
        }

        return vetor;
    }
}
