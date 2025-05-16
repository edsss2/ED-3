package aula7.arvoreLista;

import java.util.List;

public class No {

	private int valor;
	private List<No> filhos;
	
	public int calcularValor() {
		if(filhos != null) {
			for(No no : filhos) {
				valor += no.calcularValor();
			}
		}
		return valor;
	}
	
	public No(List<No> filhos) {
		valor = 0;
		this.filhos = filhos;
	}
	
	public No(int valor) {
		this.valor = valor;
		filhos = null;
	}
}
