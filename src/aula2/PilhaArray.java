package aula2;

public class PilhaArray {

	private Object[] pilha;
	private int topo = 0;
	private int total;
	
	public PilhaArray(int tamanho) {
		pilha = new Object[tamanho];
		this.total = tamanho;
	}
	
	public void empilhar(Object objeto) {
		if (total < topo) {
			System.out.println("pilha cheia");
		} else {
			pilha[topo] = objeto;
			topo++;
		}
	}
	
	public Object desempilhar() {
		if (pilha[topo] == null) {
			String retorno = "pilha vaiza";
			return retorno;
		} else {
			topo--;
			return pilha[topo];
		}
	}
	
	
	
}
