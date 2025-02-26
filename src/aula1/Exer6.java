package aula1;

public class Exer6 {

	
//	Escreva um método para imprimir no console uma matriz de 2 dimensões. Utilize
//	o seguinte padrão.
//	| X | X | X |
//	| Y | Y | Y |
//	| Z | Z | Z |
//	Utilize System.out.print( “|” + ”\t” + variável + “\t” + “|”) para imprimir no console os
//	marcadores com o espaço TAB entre eles.
	
	public static String[][] imprimeMatriz (String[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print( "|" + "\t" + matriz[i][j] + "\t" + "|");
			}
			System.out.println();
		}
		
		return matriz;
	}
	
	public static void main(String[] args) {
		String[][] matriz = {{"A", "B", "C"}, {"H", "I", "J"}, {"X", "Y", "Z"}};
		imprimeMatriz(matriz);
	}
}
