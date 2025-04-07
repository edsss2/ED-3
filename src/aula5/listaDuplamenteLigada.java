package aula5;

public class listaDuplamenteLigada {
    
    private NoDuplo inicio;
    private NoDuplo fim;
    private int tamanho;
    
    public void addOrdenado(int valor, TipoOrdenacao tipo) {
    	if (tipo == TipoOrdenacao.CRESCENTE) {
    		
    	}
    }

    public void add (Object elemento, int index) {
    	if (index < 0 || index > tamanho) {
            System.out.println("Indice inválido");
            return;
        }
        NoDuplo novoNo = new NoDuplo(elemento);

        if(index == 0) {
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;

        } else if (index == tamanho) {
            novoNo.setAnterior(fim);
            fim.setProximo(novoNo);
            fim = novoNo;
        } else {
            NoDuplo atual = percorreLista(index);

            NoDuplo proximoNo = atual.getProximo();
            atual.setProximo(novoNo);
            novoNo.setAnterior(atual);
            proximoNo.setAnterior(novoNo);
            novoNo.setProximo(proximoNo);

        }
        tamanho++;
    }

    public void add(Object valor) {
        NoDuplo novoNo = new NoDuplo(valor);
        if (tamanho == 0) {
            setInicio(novoNo);
            setFim(novoNo);
        } else{
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
        tamanho++;
    }
    
    public void remove(int index) {
    	if (index < 0 || index >= tamanho) {
    		System.out.println("Indice inválido");
    		return;
    	}
    	NoDuplo atual = percorreLista(index);
    	if(index == 0) {
    		inicio = inicio.getProximo();
    		inicio.setAnterior(null);
    	} else if (index == tamanho - 1) {
    		fim = fim.getAnterior();
    		fim.setProximo(null);
    	} else {
    		NoDuplo proximoNo = atual.getProximo();
    		NoDuplo noAnterior = atual.getAnterior();
    		proximoNo.setAnterior(noAnterior);
    		noAnterior.setProximo(proximoNo);
    	}
    	tamanho--;
    }
    
    public String imprimirLista() {
    	NoDuplo atual = inicio;
    	String imprimir = "";
    	for(int i = 0; i < tamanho; i++) {
    		imprimir += atual.toString() + "+";
    	}
    	return imprimir;
    }
    
    public int tamanhoLista() {
    	return tamanho;
    }

    
    private NoDuplo percorreLista(int index) {
    	NoDuplo atual = inicio;
    	for(int i = 0; i < index - 1; i++) {
    		atual = atual.getProximo();
    	}
    	return atual;
    }


    public listaDuplamenteLigada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public NoDuplo getInicio() {
        return inicio;
    }
    public void setInicio(NoDuplo inicio) {
        this.inicio = inicio;
    }
    public NoDuplo getFim() {
        return fim;
    }
    public void setFim(NoDuplo fim) {
        this.fim = fim;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    
}
