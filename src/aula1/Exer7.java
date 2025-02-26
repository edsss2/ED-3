package aula1;

public class Exer7 {
//	Crie um método que dado uma matriz [3x2] gere sua equivalente [2x3] transposta.
//	Conforme exemplo, utilize o algoritmo do exercício 6 para imprimir a matriz
//	original e a transposta.
	
	public static int[][] imprimeMatriz(int[][] matrizX){
		int linhas = matrizX.length;
		int colunas = matrizX[0].length;

		int[][] matrizY = new int[colunas][linhas];
		
		for (int i = 0; i < matrizY.length; i++) {
			for (int j = 0; j < matrizY[i].length; j++) {
				matrizY[i][j] = matrizX[j][i];
			}
		}
		
		System.out.println("Matriz original: ");
		//Matriz original
		for (int i = 0; i < matrizX.length; i++) {
			for (int j = 0; j < matrizX[i].length; j++) {
				System.out.print( "|" + "\t" + matrizX[i][j] + "\t" + "|");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Matriz transposta: ");
		//Matriz transposta
		for (int i = 0; i < matrizY.length; i++) {
			for (int j = 0; j < matrizY[i].length; j++) {
				System.out.print( "|" + "\t" + matrizY[i][j] + "\t" + "|");
			}
			System.out.println();
		}
		
		
		return matrizY;
	}
	
	
	public static void main(String[] args) {
		int[][] matriz = {{2,1}, {3,5}, {0,9}};
		//System.out.println(matriz[2][0]);
		imprimeMatriz(matriz);
	}
}
