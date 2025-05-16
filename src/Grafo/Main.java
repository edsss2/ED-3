package grafo;

import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);
	static GrafoMapa mapa = new GrafoMapa();
	
	public static void main(String[] args) {
		
		
		menuPrincipal();
		
	}
	
	public static void menuPrincipal() {
		System.out.println("Escolha uma das opções abaixo:");
		System.out.println("1. Cruzamento");
		System.out.println("2. Rua");
		System.out.println("3. Mapa");
		System.out.println("4. Sair");
		System.out.println("");
		System.out.println("Digite o numero da sua escolha");
		int escolha = scn.nextInt();
		
		switch(escolha) {
		case 1 -> cruzamento();
		case 2 -> rua();
		case 3 -> mapa();
		case 4 -> System.exit(0);
		default -> System.exit(0);
		}
	}

	private static void mapa() {
		System.out.println("1. Listar cruzamentos");
		System.out.println("2. Percorrer o mapa por profundidade");
		System.out.println("3. Percorrer o mapa por largura");
		System.out.println("4. Voltar");
		System.out.println("5. Sair");
		System.out.println("");
		System.out.println("Digite o numero da sua escolha");
		int escolha = scn.nextInt();
		
		switch(escolha) {
		case 1 -> mapa.listarCruzamentos();
		case 2 -> { System.out.println("Digite o id do cruzamento inicial:");
			int id = scn.nextInt();
			mapa.percorrer(id, TipoBusca.PROFUNDIDADE);
		}
		case 3 -> { System.out.println("Digite o id do cruzamento inicial:");
			int id = scn.nextInt();
			mapa.percorrer(id, TipoBusca.LARGURA);
		}
		case 4 -> menuPrincipal();
		case 5 -> System.exit(0);
		default -> System.exit(0);
		}
		
		menuPrincipal();
	}

	private static void rua() {
		System.out.println("1. Cadastrar rua direcionada");
		System.out.println("2. Cadastrar rua não direcionada");
		System.out.println("3. Editar rua");
		System.out.println("4. Remover rua");
		System.out.println("5. Voltar");
		System.out.println("6. Sair");
		System.out.println("");
		System.out.println("Digite o numero da sua escolha");
		int escolha = scn.nextInt();
		
		escolhaRua(escolha);
		menuPrincipal();
	}

	private static void cruzamento() {
		System.out.println("1. Cadastrar cruzamento");
		System.out.println("2. Editar Cruzamento");
		System.out.println("3. Remover Cruzamento");
		System.out.println("4. Listar as ruas adjacentes de um cruzamento");
		System.out.println("5. Voltar");
		System.out.println("6. Sair");
		System.out.println("");
		System.out.println("Digite o numero da sua escolha");
		int escolha = scn.nextInt();
		
		escolhaCruzamento(escolha);
		menuPrincipal();
	}
	
	private static void escolhaRua(int escolha) {
		switch (escolha) {
		case 1 -> criarRua(true);
		case 2 -> criarRua(false);
		case 3 -> editarRua();
		case 4 -> {
			System.out.println("Digite o id do cruzamento de origem da rua");
			int idOrigem = scn.nextInt();
			
			System.out.println("Digite o id do cruzamento de destino da rua");
			int idDestino = scn.nextInt();
			mapa.removerRua(idOrigem, idDestino);
		}
		case 5 -> menuPrincipal();
		case 6 -> System.exit(0);
		default -> System.exit(0);
		}
	}
	
	private static void escolhaCruzamento(int escolha) {
		switch (escolha) {
		case 1 -> mapa.cadastrarCruzamento(pegarCoordenadas());
		case 2 -> {
			int id = pegarIdCruzamento();
			System.out.println("Digite agora as novas coordenadas");
			mapa.editarCruzamento(id, pegarCoordenadas());
		}
		case 3 -> mapa.removerCruzamento(pegarIdCruzamento());
		case 4 -> mapa.listarRuasAdjacentes(pegarIdCruzamento());
		case 5 -> menuPrincipal();
		case 6 -> System.exit(0);
		default -> System.exit(0);
		}
	}
	
	private static int pegarIdCruzamento() {
		System.out.println("Digite o id do cruzamento");
		return scn.nextInt();
	}
	
	private static int[] pegarCoordenadas() {
		int[] coordenadas = new int[2];
		System.out.println("Digite a latitude");
		coordenadas[0] = scn.nextInt();
		
		System.out.println("Digite a longitude");
		coordenadas[1] = scn.nextInt();
		return coordenadas;
	}
	
	private static void editarRua() {
		System.out.println("Digite o nome da rua");
		String nomeRua = scn.next();
		
		System.out.println("Digite o tamanho em metros da rua");
		float distanciaRua = scn.nextFloat();
		
		System.out.println("Digite o id do cruzamento de origem da rua");
		int idOrigem = scn.nextInt();
		
		System.out.println("Digite o id do cruzamento de destino da rua");
		int idDestino = scn.nextInt();
		
		System.out.println("A rua editada sera direcionada? Digite 1 para sim e 2 para não");
		int escolha2 = scn.nextInt();
		if(escolha2 == 1) {
			mapa.editarRua(idOrigem, idDestino, nomeRua, distanciaRua, true);
		} else if(escolha2 == 2) {
			mapa.editarRua(idOrigem, idDestino, nomeRua, distanciaRua, false);
		} else {
			System.out.println("Digite um numero válido");
		}
		
	}
	private static void criarRua(boolean direcionada) {
		System.out.println("Digite o nome da rua");
		String nomeRua = scn.next();
		System.out.println("Digite o tamanho em metros da rua");
		float distanciaRua = scn.nextFloat();
		System.out.println("Digite o id do cruzamento de origem da rua");
		int idOrigem = scn.nextInt();
		System.out.println("Digite o id do cruzamento de destino da rua");
		int idDestino = scn.nextInt();
		mapa.addRua(idOrigem, idDestino, nomeRua, distanciaRua, direcionada);
	}
}
