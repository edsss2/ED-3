package aula3.recursao.desafio;

import java.util.ArrayList;
import java.util.List;

public class Desafio {
	
	/*
		Torre de Hanoi
• Consiste de três hastes A (origem), B (destino) e C (auxiliar).
• O objetivo do jogo é transferir todos os discos da origem para o destino.
• Respeitando as seguintes regras:
• Apenas um disco poderá ser movido por vez.
• Um disco maior não pode ser movido em cima de um disco menor.
*/

	static List<Disco> destino = new ArrayList<>();
	static List<Disco> auxiliar = new ArrayList<>();
	
	public static List<Disco> hanoi(List<Disco> origem) {
		System.out.println(origem.size() + " | " + destino.size() + " | " + auxiliar.size());	
		Disco discoOrig;
		if (origem.isEmpty()) {
			if (auxiliar.size() == 1) {
				Disco discoAux = auxiliar.get(auxiliar.size() - 1);
				destino.add(destino.size() - 1, discoAux);
				auxiliar.remove(0);
			} else {
				return destino;	
			}
			
		} else if (auxiliar.isEmpty()) {
			discoOrig = origem.get(origem.size() - 1);
			auxiliar.add(discoOrig);
			origem.remove(origem.size() - 1);
		} else {
			discoOrig = origem.get(origem.size() - 1);
			Disco discoAux = auxiliar.get(auxiliar.size() - 1);
			
			if (discoOrig.tamanho < discoAux.tamanho) {
				auxiliar.add(auxiliar.size()- 1, discoOrig);
				origem.removeLast();
			} else {
				destino.add(discoAux);
				auxiliar.remove(auxiliar.size() - 1);
			}
			
		}
		
		
		return hanoi(origem);
	}
	
	public static void main (String[] args) {
		List<Disco> origem = new ArrayList<>();
		int cont = 0;
		for (int i = 5; i > 0; i--) {
			Disco disco = new Disco(i);
			origem.add(cont, disco);
			cont++;
		}
		
		hanoi(origem);
		
	}
	

}
