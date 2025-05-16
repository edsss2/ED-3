package aula7.arvoreSimples;

public class Teste {

	public static void main(String[] args) {
		ArvoreBinaria tree = new ArvoreBinaria();
		
		tree.adicionar(12);
		tree.adicionar(20);
		tree.adicionar(17);
		tree.adicionar(10);
		tree.adicionar(11);
		
		int pdd1 = tree.buscaProfundidade(11);
		int pdd2 = tree.buscaProfundidade(17);
		System.out.println("Profundidade do numero 11 = " + pdd1);
		System.out.println("Profundidade do numero 17 = " + pdd2);
		tree.printArvore();
	}
}
