package aula1;

import java.util.Arrays;

public class Exer4 {

	//Crie um método que receba como parâmetro um número decimal, converta esse
	//número para binário e retorne na forma de um vetor com 8 posições.
	
	//Para obter o resto de uma divisão utilize o operador %. Exemplo: int resto = 9 % 2
	
	public static int[] converteDecimal(int decimal) {
		int[] bin = new int[8];
		int resto = 0;
		
		for (int i = bin.length-1; i > -1; i--) {
			resto = decimal % 2;
			decimal = decimal / 2;
			bin[i] = resto;
		}
		
		return bin;
	}
	
	public static void main(String[] args) {
		int decimal = 45;
		System.out.println(Arrays.toString(converteDecimal(decimal)));
	}
}
