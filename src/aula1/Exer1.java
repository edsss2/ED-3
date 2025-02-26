package aula1;

import java.util.Arrays;

public class Exer1 {

	
	//Crie um método que receba 1 vetor com 8 posições, inverta a ordem dos itens e retorne o vetor invertido

	public static int[] inverteVetor(int[] vetor) {
		
		for(int i = 0; i < vetor.length / 2; i++) {
			int auxiliar = vetor.length - i - 1;
			int valor = vetor[auxiliar];
			vetor[auxiliar] = vetor[i];
			vetor[i] = valor;
		}
		
		return vetor;
	}
	
	
	public static void main(String[] args) {
		int[] vet = {9, 4, 4, 6, 3, 1, 9, 2, 6};
		int[] outroVetor = inverteVetor(vet);
		System.out.println(Arrays.toString(outroVetor));
		
	}
 }
