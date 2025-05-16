package grafo.GMA;

public class GMA {
	boolean arestas[][];
	String vertices[];
	int indice;

	public GMA(int qtdVertices) {
		this.arestas = new boolean[qtdVertices][qtdVertices];
		this.vertices = new String[qtdVertices];
		indice = 0;
	}

	public void addVertice(String nome) {
		vertices[indice] = nome;
		indice++;
	}

	public void addArestaNaoDirecional(String nomeOrig, String nomeDest) {
		// Receber Origem e Destino e adiciona o relacionamento
		
		
		
		
	}

	public void addArestaDirecional(String nomeOrig, String nomeDest) {// Receber Origem e Destino e adiciona o
																		// relacionamento
	}

	public void removerAresta(String nomeOrig, String nomeDest) {
//Remove o relacionamento de origem para destino.
	}

	public void imprimirMatriz() {
//Imprime a matriz no console
	}

	public void imprimirVizinhos(String nomeOrigem) {
//Imprimir os vertices Vizinhos
	}
	
	private void addAresta(boolean check, String nomeOrig, String nomeDest) {
		int indiceOrig = buscarVertices(nomeOrig);
		int indiceDest = buscarVertices(nomeDest);
		
		for(int x = 0; x < indiceOrig; x++) {
			for(int y = 0; y < arestas[0].length; y++) {
				if()
			}
		}
	}

	private int buscarVertices(String nome) {
		//Busca o Vertice pelo nome e retorna o índice
		for(int i = 0; i < vertices.length; i++) {
			if (vertices[i] == nome) {
				return i;
			}
		}
		return 0;
	}
}
