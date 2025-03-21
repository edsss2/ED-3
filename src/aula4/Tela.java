package aula4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Tela extends JFrame {

    public Tela() {
        initComponents();
    }

    private void initComponents() {

        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btnIniciar = new JButton();
        lblRodada = new JLabel();
        lblPontuacao = new JLabel();
        lblDificuldade = new JLabel();
        lblInfo = new JLabel();
        jcbDificuldade = new JComboBox<>();
        scrollPane = new JScrollPane();
        jList1 = new JList<>();
        lblNomeJogador = new JTextField();

        botoes = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for(int i = 0; i < botoes.length; i++) {
        	JButton btn = botoes[i];
            btn.setPreferredSize(new java.awt.Dimension(50, 50));
            btn.setBackground(Color.WHITE);
            addListenerToBtn(btn, i);
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(null);
        setResizable(false);

        btnIniciar.setBackground(new java.awt.Color(153, 255, 0));
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(this :: btnIniciarActionPerformed);

        lblRodada.setText("RODADA: " + rodada);

        lblPontuacao.setText("PONTUAÇÃO:");

        lblDificuldade.setText("DIFICULDADE");

        lblInfo.setText("Memorização - Edson Sanchez da Veiga - 249204");

        jcbDificuldade.setModel(new DefaultComboBoxModel<>(new String[] { "Fácil", "Médio", "Díficil" }));

        listModel = new DefaultListModel<>();
        jList1.setModel(listModel);
        scrollPane.setViewportView(jList1);

        lblNomeJogador.setText("Nome do Jogador");

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jcbDificuldade, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblDificuldade, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblRodada, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblPontuacao, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(lblNomeJogador, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addContainerGap()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
        					.addGap(12)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(0, 249, Short.MAX_VALUE)
        			.addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
        			.addGap(228))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(lblInfo)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblRodada)
        						.addComponent(lblDificuldade, Alignment.TRAILING))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(0, 0, Short.MAX_VALUE)
        							.addComponent(jcbDificuldade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblNomeJogador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblPontuacao))
        							.addGap(0, 0, Short.MAX_VALUE))))
        				.addComponent(btnIniciar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btn1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btn2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
        					.addGap(15)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btn7, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(btn8, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        							.addComponent(btn9, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addListenerToBtn (JButton btn, Integer numeroBotao) {
        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	 btn.setBackground(Color.RED);
            	 botoesClicadosUsuario.add(numeroBotao);
            	 cont++;
            	 
            	 if (cont == rodada) {
            		 acertou = controle.comparaBotoesClicados(botoesClicadosUsuario);
            		 
            		 if (acertou) {
            			 pontuacao += controle.calculaPontuacao();
            			 lblPontuacao.setText("Pontuação: " + pontuacao);
            			 JOptionPane.showMessageDialog(rootPane, "Você acertou!");
            			 
            		 } else {
            			 JOptionPane.showMessageDialog(rootPane, "Você errou!");
            			 String nome = lblNomeJogador.getText();
            			 listModel.addElement(nome + " - " + pontuacao);
            			 PintarBotoes.listaOsNumeros.clear();
            			 rodada = 0;
            			 pontuacao = 0;
                    	 lblPontuacao.setText("Pontuação: " + pontuacao);
            		 }
            	 }
            	 PintarBotoes.pintarBotaoComDelay(btn, 250);
            	 rodadaIniciada(false);
            }
            
        });
    }

    
    private void btnIniciarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
    	rodada++;
    	rodadaIniciada(true);
    	botoesClicadosUsuario = new ArrayList<>();
    	Runnable run = () -> {
    		JOptionPane.showMessageDialog(rootPane, "Agora é sua vez!");
    	};
    	int dificuldadeSelecionada = jcbDificuldade.getSelectedIndex();
    	if (controle == null) {
    		controle = new Controle(botoes);
    		controle.setDificuldade(dificuldadeSelecionada + 1);
    		controle.iniciar(run, rodada);
    		
    	} else {
    		controle.setDificuldade(dificuldadeSelecionada + 1);
    		controle.iniciar(run, rodada);
    	}
    	cont = 0;
    	
    	
    }
    
    private void rodadaIniciada(boolean estado){
    	btnIniciar.setEnabled(!estado);
    	lblRodada.setText("Rodada: " + rodada);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        setNimbusLookAndFeel();

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }
    private static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Aqui você pode tratar todos os tipos de exceção de uma vez
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btn3;
    private JButton btn1;
    private JButton btnIniciar;
    private JButton btn2;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JComboBox<String> jcbDificuldade;
    private JLabel lblRodada;
    private JLabel lblPontuacao;
    private JLabel lblDificuldade;
    private JLabel lblInfo;
    private JList<String> jList1;
    private JScrollPane scrollPane;
    private JTextField lblNomeJogador;
    private JButton[] botoes;
    private Controle controle;
    private Integer rodada = 0;
    private Integer cont;
    private List<Integer> botoesClicadosUsuario;
    private boolean acertou;
    private int pontuacao;
    private DefaultListModel<String> listModel;
    // End of variables declaration//GEN-END:variables
}
