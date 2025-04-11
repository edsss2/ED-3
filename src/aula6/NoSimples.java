package aula6;

public class NoSimples {
    
    private Object info;
    private NoSimples proxNo;
    private NoSimples anterior;

    
    public NoSimples(Object info) {
        this.info = info;
    }

    public Object getInfo() {
        return info;
    }
    public void setInfo(Object info) {
        this.info = info;
    }
    public NoSimples getProxNo() {
        return proxNo;
    }
    public void setProxNo(NoSimples proxNo) {
        this.proxNo = proxNo;
    }

    public NoSimples getAnterior() {
        return anterior;
    }

    public void setAnterior(NoSimples anterior) {
        this.anterior = anterior;
    }
}
