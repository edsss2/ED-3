package aula1;

public class Exer3 {

	//Crie um método que receba como parâmetro um número binário na forma de um
	//vetor com 8 posições e retorne esse número convertido para decimal.
	
	
	public static int converteBinario(int[] vetor) {
	    int resultado = 0;
	    int expoente = 1;

	    for (int i = vetor.length - 1; i >= 0; i--) {
	        if (vetor[i] == 1) {
	            resultado += expoente;
	        }
	        expoente *= 2;
	    }

	    return resultado;
	}
	
	
	public static void main(String[] args) {
		int[] vetor = {1, 0, 1, 0};
		System.out.println(converteBinario(vetor));
	}
}
