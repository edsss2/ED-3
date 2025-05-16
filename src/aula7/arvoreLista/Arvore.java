package aula7.arvoreLista;

public class Arvore {

	private No raiz;
	
	public Arvore(No raiz) {
		this.raiz = raiz;
	}
	
	public int calcularValorTotal() {
		return raiz.calcularValor();
	}
}
