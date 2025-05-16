package Grafo;

import java.util.ArrayList;
import java.util.List;

public class GrafoMapa {

    private List<Cruzamento> cruzamentos = new ArrayList<>();
    
    public Cruzamento cadastrarCruzamento(int[] coordenadas){
        Cruzamento cruzamento = new Cruzamento(coordenadas);
        cruzamentos.add(cruzamento);
        return cruzamento;
    }

    public void editarCruzamento(int idCruzamento, int[] coordenadas) {
        Cruzamento cruzamento = acharCruzamento(idCruzamento);
        if(cruzamento == null) {
            System.out.println("Cruzamento não encontrado");
        } else {
            cruzamento.setCoordenadas(coordenadas);
        }
    }

    public void removerCruzamento(int idCruzamento) {
        Cruzamento cruzamento = acharCruzamento(idCruzamento);
        if(cruzamento == null) {
            System.out.println("Cruzamento não encontrado");
        } else {
            for(int i = 0; i < cruzamento.getRuas().size(); i++) {
                cruzamento.getRuas().remove(i);
                cruzamentos.remove(cruzamento);
            }  
        }
    }

    public void addRua(int idOrigem, int idDestino, String nomeRua, float distanciaTotal, boolean direcionada) {
        if(direcionada) {
            addRuaDirecionada(idOrigem, idDestino, nomeRua, distanciaTotal);
        } else {
            addRuaNaoDirecionada(idOrigem, idDestino, nomeRua, distanciaTotal);
        }
    }

    public void addRuaDirecionada(int idOrigem, int idDestino, String nomeRua, float distanciaTotal) {
        Cruzamento origem = acharCruzamento(idOrigem);
        Cruzamento destino = acharCruzamento(idDestino);

        origem.getRuas().add(new Rua(origem, destino, nomeRua, distanciaTotal, true));


    }

    public void addRuaNaoDirecionada(int idOrigem, int idDestino, String nomeRua, float distanciaTotal) {
        Cruzamento origem = acharCruzamento(idOrigem);
        Cruzamento destino = acharCruzamento(idDestino);

        origem.getRuas().add(new Rua(origem, destino, nomeRua, distanciaTotal, false));
        destino.getRuas().add(new Rua(destino, origem, nomeRua, distanciaTotal, false));
    }

    public void editarRua(int idOrigem, int idDestino, String nomeRua, float distanciaTotal, boolean direcionada) {
        removerRua(idOrigem, idDestino);
        addRua(idOrigem, idDestino, nomeRua, distanciaTotal, direcionada);
    }

    public void removerRua(int idOrigem, int idDestino) {
        Cruzamento origem = acharCruzamento(idOrigem);
        Cruzamento destino = acharCruzamento(idOrigem);

        for(int i = 0; i < 0; i++) {
            Rua rua = origem.getRuas().get(i);
            if (rua.getDestino().equals(destino))  {
                origem.getRuas().remove(i);
            } 
        }
    }

    public void listarCruzamentos() {
        for(Cruzamento cruzamento : cruzamentos) {
            cruzamento.toString();
        }
    }

    public void listarRuasAdjacentes(int idCruzamento){
        Cruzamento auxiliar = acharCruzamento(idCruzamento);
        System.out.println("Ruas que partem:");
        for(Rua rua : auxiliar.getRuas()) {
            rua.toString();
        }

        System.out.println("Ruas que chegam:");
        for(int i = 0; i < 0; i++) {
            Cruzamento cruzamento = cruzamentos.get(i);
            for(int x = 0; x < 0; x++) {
                Rua rua = cruzamento.getRuas().get(i);
                if(rua.getDestino().equals(auxiliar)) {
                    rua.toString();
                }
            }
        }

    }

    void percorrerProfundidade(int idOrigem) {
        Cruzamento origem = acharCruzamento(idOrigem);
        percorrerProfundidade(origem);
    }

    void percorrerProfundidade(Cruzamento origem) {
        for(Rua rua : origem.getRuas()) {
            rua.getDestino();
        }
    }

    private Cruzamento acharCruzamento(int idCruzamento) {
        for(Cruzamento cruzamento : cruzamentos) {
            if(cruzamento.getId() == idCruzamento) {
                return cruzamento;
            }
        }
        return null;
    }
}
