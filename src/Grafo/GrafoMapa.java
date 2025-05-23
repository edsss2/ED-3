package grafo;

import java.util.ArrayList;
import java.util.List;

public class GrafoMapa {

    private List<Cruzamento> cruzamentos = new ArrayList<>();
    
    public Cruzamento cadastrarCruzamento(int[] coordenadas, int id){
        Cruzamento cruzamento = new Cruzamento(coordenadas, id);
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
            } 
            cruzamentos.remove(cruzamento);
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
            System.out.println(rua.toString());
        }

        System.out.println("Ruas que chegam:");
        for(int i = 0; i < 0; i++) {
            Cruzamento cruzamento = cruzamentos.get(i);
            for(int x = 0; x < 0; x++) {
                Rua rua = cruzamento.getRuas().get(i);
                if(rua.getDestino().equals(auxiliar)) {
                	System.out.println(rua.toString());
                }
            }
        }

    }

    public float percorrer(int idOrigem, TipoBusca tipo) {
        Cruzamento origem = acharCruzamento(idOrigem);
        float distanciaTotal = 0f;
        List<Cruzamento> cruzamentosNoMapa = new ArrayList<>();
        cruzamentosNoMapa.add(origem);
        
        
        if(tipo == TipoBusca.LARGURA) {
        	return percorrerLargura(distanciaTotal, cruzamentosNoMapa);
        } else if(tipo == TipoBusca.PROFUNDIDADE) {
        	return percorrerProfundidade(distanciaTotal, cruzamentosNoMapa);
        } else {
        	return distanciaTotal;
        }
        
    }

    private float percorrerProfundidade(float distanciaTotal, List<Cruzamento> cruzamentosNaoVisitados) {
    	//No inicio do método eu tiro o cruzamento origem do final da lista
    	//Altero a variavel visitado para true
    	//E imprimo ele no terminal
    	Cruzamento origem = cruzamentosNaoVisitados.getLast();
        origem.isVisitado = true;
    	System.out.println(origem.toString());
    	
    	//Aqui eu removo a origem para não entrar em looping
    	cruzamentosNaoVisitados.remove(origem);
    	
    	cruzamentosNaoVisitados = addCruzamentosNaoVisitados(origem, cruzamentosNaoVisitados);
    	
    	//If para encerrar a recursão
    	if(cruzamentosNaoVisitados.isEmpty()) {
    		return distanciaTotal;
    	}
    	
        //For para somar a distancia da rua na variavel distancia total e por imprimir o nome da rua
        for(Rua rua : origem.getRuas()) {
        	if(cruzamentosNaoVisitados.getLast().equals(rua.getDestino())) {
        		distanciaTotal += rua.getDistanciaTotal();
        		System.out.println(rua.toString());
        	}
        }
        return percorrerProfundidade(distanciaTotal, cruzamentosNaoVisitados);
    }
    
    private float percorrerLargura(float distanciaTotal, List<Cruzamento> cruzamentosNaoVisitados) {
    	Cruzamento origem = cruzamentosNaoVisitados.getFirst();
    	origem.isVisitado = true;
    	System.out.println(origem.toString());
    	
    	//Aqui eu removo a origem para não entrar em looping
    	cruzamentosNaoVisitados.remove(origem);
    	
    	cruzamentosNaoVisitados = addCruzamentosNaoVisitados(origem, cruzamentosNaoVisitados);
    	
    	//If para encerrar a recursão
    	if(cruzamentosNaoVisitados.isEmpty()) {
    		return distanciaTotal;
    	}
    	
    	for(Rua rua : origem.getRuas()) {
        	if(cruzamentosNaoVisitados.getFirst().equals(rua.getDestino())) {
        		distanciaTotal += rua.getDistanciaTotal();
        		System.out.println(rua.toString());
        	}
        }
    	
    	return percorrerLargura(distanciaTotal, cruzamentosNaoVisitados);
    }
    
    private List<Cruzamento> addCruzamentosNaoVisitados(Cruzamento origem, List<Cruzamento> cruzamentos) {
    	//For para adicionar as ruas ainda não visitadas na lista
        for(Rua rua : origem.getRuas()) {
        	Cruzamento destino = rua.getDestino();
            if(!destino.isVisitado) {
            	cruzamentos.addLast(destino);
            }
        }
        return cruzamentos;
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
