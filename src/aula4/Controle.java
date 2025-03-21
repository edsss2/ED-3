package aula4;

import java.util.List;

import javax.swing.JButton;

public class Controle {

	private List<Integer> botoesPiscados;
    private int rodada;
    private int dificuldade;
    private JButton[] botoes;

    public Controle(JButton[] botoes) {
        this.botoes = botoes;
    }
    
    public void iniciar(Runnable message, int rodada){
    	System.out.println(dificuldade);
    	switch(dificuldade) {
    	case(1) :
    		botoesPiscados = PintarBotoes.piscarBotoes(botoes, 500, rodada, message);
    		break;
    	case(2) :
    		botoesPiscados = PintarBotoes.piscarBotoes(botoes, 300, rodada, message);
    		break;
    	case(3) :
    		botoesPiscados = PintarBotoes.piscarBotoes(botoes, 150, rodada, message);
    		break;
    	}
    	
    	this.rodada = rodada;
    }
    
    public int calculaPontuacao() { 
    	return rodada * dificuldade * 20; 
    }

    public boolean comparaBotoesClicados(List<Integer> botoesClicadosUsuario) {
    	for (int i = 0; i < rodada; i++) {
    		if (botoesPiscados.get(i) != botoesClicadosUsuario.get(i)) {
    			return false;
    		}
    	}
        return true;
    }

    public int getRodada() {
        return rodada;
    }
    public void setRodada(int rodada) {
        this.rodada = rodada;
    }
    public int getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
    

}




