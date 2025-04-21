package aula7;

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
    
    public int buscaNo(int valor) {
    	if (raiz.valor == valor) {
    		return 0;
    	}
    	return buscaNo(raiz, valor, 0);
    }
    
    private int buscaNo(No no, int valor, int profundidade) {
    	if (valor == no.direita.valor || valor == no.esquerda.valor) {
    		return profundidade++;
    	}
    	if (valor > no.valor) {
    		buscaNo(no.direita, valor, profundidade++);
    	} else {
    		buscaNo(no.esquerda, valor, profundidade++);
    	}
    	return -1;
    }
}
