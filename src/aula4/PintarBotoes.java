package aula4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class PintarBotoes {

	static List<Integer> listaOsNumeros = new ArrayList<>();
	/**
	* Método que faz os botões piscarem em sequência, alterando entre as cores
	vermelha e branca
	* @param botoes vetor de JButton que serão destacados
	* @param delayMillis tempo em milissegundos entre cada operação
	* @param rodada numero de vezes que os botões serão pintados
	* @param callback interface para executar uma ação quando a animação terminar
	*/
	public static List<Integer> piscarBotoes(JButton[] botoes, int delayMillis, int rodada, Runnable callback) {
		// Criar uma tarefa em uma thread separada para não bloquear a interface gráfica
		new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				Random random = new Random();
				listaOsNumeros.add(random.nextInt(8) + 0);
				for (int i = 0; i < rodada; i++) {
					publish(listaOsNumeros.get(i));
					Thread.sleep(delayMillis);
					Thread.sleep(delayMillis);
				}	
				
				return null;
			}
			@Override
			protected void process(List<Integer> indices) {
				// Obtém o índice mais recente
				int index = indices.get(indices.size() - 1);
				JButton botaoAtual = botoes[index];
				// Altera a cor do botão para vermelho
				botaoAtual.setBackground(Color.RED);
				// Programa a alteração de volta para branco após o delay
				Timer timer = new Timer(delayMillis, e -> {
					botaoAtual.setBackground(Color.WHITE);
					((Timer) e.getSource()).stop(); // Para o timer após executar uma vez
				});
				timer.setRepeats(false);
				timer.start();
			}
			
			@Override
			protected void done() {
				// Quando terminar, executa o callback
				if (callback != null) {
					callback.run();
				}
			}
			
		}.execute();
	return listaOsNumeros;
	}
	
	
	public static void pintarBotaoComDelay(JButton botao, int delay) {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(delay);
                return null;
            }

            @Override
            protected void done() {
                botao.setBackground(Color.WHITE);
            }
        }.execute();
    }
}
