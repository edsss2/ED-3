package aula4;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

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
        lblNameJodador = new JTextField();

        botoes = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for(JButton btn : botoes) {
            btn.setPreferredSize(new java.awt.Dimension(50, 50));
            addListenerToBtn(btn);
        }

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(null);
        setResizable(false);

        btnIniciar.setBackground(new java.awt.Color(153, 255, 0));
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(this :: btnIniciarActionPerformed);

        lblRodada.setText("RODADA:");

        lblPontuacao.setText("PONTUAÇÃO:");

        lblDificuldade.setText("DIFICULDADE");

        lblInfo.setText("Memorização - Edson Sanchez da Veiga - 249204");

        jcbDificuldade.setModel(new DefaultComboBoxModel<>(new String[] { "Fácil", "Médio", "Díficil" }));

        jList1.setModel(new AbstractListModel<String>() {
            String[] strings = { "Jogador: Pontuação" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrollPane.setViewportView(jList1);

        lblNameJodador.setText("Nome do Jogador");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jcbDificuldade, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDificuldade, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblRodada, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPontuacao, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNameJodador, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblInfo, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInfo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblRodada)
                            .addComponent(lblDificuldade, GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jcbDificuldade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNameJodador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPontuacao))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(btnIniciar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollPane))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addListenerToBtn (JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btnMouseClicked(evt, btn);
            }
            
        });
    }

    private void btnMouseClicked(MouseEvent evt, JButton btn) {
        btn.setBackground(Color.RED);
    }
    
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
    	// Controla que a rodada está em execução
    	rodadaIniciada(true);
    	// Prepara o array de botões
    	// Chama o método piscarBotoes com um callback para quando terminar
    	PintarBotoes.piscarBotoes(botoes, 500, () -> {
    		// Esta parte será executada quando a animação terminar
    		JOptionPane.showMessageDialog(rootPane, "Agora é sua vez!");
    	});
    }//GEN-LAST:event_btoIniciarActionPerformed
    //Implemente o restante do código para controle de execução da rodada
    private void rodadaIniciada(boolean estado){
    	btnIniciar.setEnabled(!estado);
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
    private JTextField lblNameJodador;
    private JButton[] botoes;
    // End of variables declaration//GEN-END:variables
}
