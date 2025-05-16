package aula7.arvoreSimples;

public class ArvoreBinaria {
    No raiz;
    
    public void adicionar(int valor) {
    	if (raiz == null) {
    		raiz = new No(valor);
    	} else {
    		adicionar(raiz, valor);
    	}
    }
    
    private void adicionar(No no, int valor) {
    	if (valor > no.valor) {
    		if (no.direita != null) {
    			adicionar(no.direita, valor);
    		} else {
    			no.direita = new No(valor);
    		}
    	} else {
    		if (no.esquerda != null) {
    			adicionar(no.esquerda, valor);
    		} else {
    			no.esquerda = new No(valor);
    		}
    	}
    }
    
    public int buscaProfundidade(int valor) {
    	if (raiz.valor == valor) {
    		return 0;
    	}
    	return buscaProfundidade(raiz, valor, 0);
    }
    
    private int buscaProfundidade(No no, int valor, int profundidade) {
        if (no == null) {
            return -1;
        }

        if (no.valor == valor) {
            return profundidade;
        }

        int esquerda = buscaProfundidade(no.esquerda, valor, profundidade + 1);
        if (esquerda != -1) {
            return esquerda;
        }

        return buscaProfundidade(no.direita, valor, profundidade + 1);
    }
    
    public void printArvore() { 	
    	printArvore(raiz, 0);
    }
    
    private void printArvore(No no, int pdd) { 
    	if(no.esquerda != null) {
    		printArvore(no.esquerda, pdd + 1);
    	}
    	
    	System.out.println(no.valor + " [Profundidade: " + pdd + " ]");
    	
    	if(no.direita != null) {
        	printArvore(no.direita, pdd + 1);
    	}
    }
    
    
    
    
}
