package aula5;

public class NoDuplo {
    Object valor;
    NoDuplo proximo;
    NoDuplo anterior;

    public NoDuplo (Object valor){
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    
}
