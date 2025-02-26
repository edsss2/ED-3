package aula1;

public class Exer2 {
	
	//Crie um método que receba 3 vetores com 8 posições cada e retorne uma matriz
	//de 8x3 posições com os respectivos valores armazenados nos vetores

	public static int[][] imprimeMatriz(int[] vet1, int[] vet2, int[] vet3) {
        int[][] matriz = new int[3][8]; 

        for (int i = 0; i < 8; i++) {
            matriz[0][i] = vet1[i]; 
            matriz[1][i] = vet2[i];
            matriz[2][i] = vet3[i]; 
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        return matriz;
    }

    public static void main(String[] args) {
        int[] vet1 = {9, 4, 4, 6, 3, 1, 9, 2};
        int[] vet2 = {5, 6, 7, 3, 7, 1, 0, 8};
        int[] vet3 = {9, 2, 4, 5, 9, 1, 9, 0};
        imprimeMatriz(vet1, vet2, vet3);
    }
}
