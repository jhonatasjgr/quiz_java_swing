package telas;

import model.Questao;
import repositories.ListaDeQuestoes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TelaQuestao {

    ArrayList<Questao> questoes;

    public TelaQuestao(ArrayList<Questao> questoes, int qtdAcertos, int nQuestao) {
        if (questoes == null) {
            this.questoes = new ListaDeQuestoes().buscarQuestoes();
        } else {
            this.questoes = questoes;
        }
        iniciarQuestao(qtdAcertos, nQuestao);
    }

    public void iniciarQuestao(int qtdAcertos, int nQuestao) {
        AtomicBoolean correta = new AtomicBoolean(false);
        JFrame frame = new JFrame("Quiz Java POO");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Use getResource to load the image
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/sql-guide-image.jpg"));
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setOpaque(false); // Make the panel transparent

        JLabel enunciadoLabel = new JLabel(
                "<html>" +
                        "<div style='text-align: center;'>" +
                        questoes.get(0).enunciado +
                        "</div>" +
                        "</html>"
        );
        enunciadoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        enunciadoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        enunciadoLabel.setOpaque(true); // Make the label opaque
        enunciadoLabel.setBackground(Color.WHITE);


        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(4, 1, 10, 10));
        botoesPanel.setOpaque(false); // Make the panel transparent

        JRadioButton opcaoButton1 = new JRadioButton(questoes.get(0).opcao1);
        JRadioButton opcaoButton2 = new JRadioButton(questoes.get(0).opcao2);
        JRadioButton opcaoButton3 = new JRadioButton(questoes.get(0).opcao3);
        JRadioButton opcaoButton4 = new JRadioButton(questoes.get(0).opcao4);

        ButtonGroup group = new ButtonGroup();
        group.add(opcaoButton1);
        group.add(opcaoButton2);
        group.add(opcaoButton3);
        group.add(opcaoButton4);

        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmarButton.addActionListener(e -> {
            if (opcaoButton1.isSelected() && questaoCorreta(questoes.get(0), questoes.get(0).opcao1)) {
                correta.set(true);
            } else if (opcaoButton2.isSelected() && questaoCorreta(questoes.get(0), questoes.get(0).opcao2)) {
                correta.set(true);
            } else if (opcaoButton3.isSelected() && questaoCorreta(questoes.get(0), questoes.get(0).opcao3)) {
                correta.set(true);
            } else if (opcaoButton4.isSelected() && questaoCorreta(questoes.get(0), questoes.get(0).opcao4)) {
                correta.set(true);
            }
            proximaQuestao(frame, correta, qtdAcertos, nQuestao);
        });

        botoesPanel.add(opcaoButton1);
        botoesPanel.add(opcaoButton2);
        botoesPanel.add(opcaoButton3);
        botoesPanel.add(opcaoButton4);

        panel.add(enunciadoLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(botoesPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(confirmarButton);

        backgroundPanel.add(panel);
        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
    }

    private void proximaQuestao(JFrame frame, AtomicBoolean correta, int qtdAcertos, int nQuestao) {
        frame.dispose();
        if (nQuestao == 4) {
            if (correta.get()) {
                qtdAcertos++;
            }
            new TelaSalvar(qtdAcertos);
        } else {
            questoes.remove(0);
            if (correta.get()) {
                qtdAcertos++;
            }
            new TelaQuestao(questoes, qtdAcertos, nQuestao + 1);
        }
    }

    public boolean questaoCorreta(Questao questao, String alternativaEscolhida) {
        return alternativaEscolhida.equalsIgnoreCase(questao.alternativaCerta);
    }
}