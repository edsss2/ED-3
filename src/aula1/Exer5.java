package aula1;

import java.util.Arrays;

public class Exer5 {

	//Escreva um método que receba dois vetores de 5 números cada, gere um terceiro vetor
	//com os elementos dos outros dois vetores intercalados.
	//Exemplo: vetor 1º ={A,B,C,D,E} | 2º={1,2,3,4,5} | 3º={A,1,B,2,C,3,D,4,E,5}
	
	public static int[] intercalaVetor (int[] vet1, int[] vet2) {
		int[] vetorIntercalado = new int[10];
		
		int cont = 0;
		for (int i = 1; i < 10; i+=2) {
			vetorIntercalado[i - 1] = vet1[cont];
			vetorIntercalado[i] = vet2[cont];
			cont++;
		}

		return vetorIntercalado;
	}
	
	  public static void main(String[] args) {
	        int[] impares = {1, 3, 5, 7, 9};
	        int[] pares = {2, 4, 6, 8, 10};
	        System.out.println(Arrays.toString(intercalaVetor(impares, pares)));
	    }
}
