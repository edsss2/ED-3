package aula6;

public class ListaLigada {

    private NoSimples inicio;
    private NoSimples fim;
    private int tamanho = 0;

    public void add(Object info) {
        NoSimples novoNo = new NoSimples(info);
        if(tamanho == 0) {
            inicio = novoNo;
            fim = novoNo;
        } else {
             novoNo.setAnterior(fim);
             fim.setProxNo(novoNo);
             fim = novoNo;
        }
        tamanho++;
    }

    public String get(int index) {
        return (String)buscaNo(index).getInfo();
    }

    private NoSimples buscaNo(int index) {
        if (tamanho == 0) {
            System.out.println("Lista Vazia");
            return null;
        }
        if (index == 0) {
            return inicio;
        } else if (index == tamanho) {
            return fim;
        } else {
            NoSimples aux = inicio;
            for (int i = 0; i < index; i++) {
                aux = aux.getProxNo();
            }
            return aux;
        }
    }



        
    public NoSimples getInicio() {
        return inicio;
    }

    public void setInicio(NoSimples inicio) {
        this.inicio = inicio;
    }

    public NoSimples getFim() {
        return fim;
    }

    public void setFim(NoSimples fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
