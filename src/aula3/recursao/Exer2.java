package aula3.recursao;

public class Exer2 {

	
	//Crie um método recursivo que receba dois números inteiros como parâmetros,
	//o primeiro será o número base e o segundo a potência, e retorne o valor da
	//função.
	
	
	public static int potencia(int base, int expoente) {
		if (expoente == 0) {
			return 1;
		} else {
			return base * potencia(base, expoente - 1);
		}

	}
	
	public static void main(String[] args) {
		int base = 10;
		int expoente = 2;
		System.out.println(potencia(base, expoente));
	}
	
	
	
}
