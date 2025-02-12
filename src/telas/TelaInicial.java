package telas;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {
    String orientacoesSobreOJogo = "Orientações sobre o Quizz";

    public TelaInicial() {
        super("Quiz POO & SQL");
        this.setSize(800, 600); // Tamanho da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Centralizar a janela
        setResizable(false);

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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Alinhar todos os componentes em (Y)
        panel.setOpaque(false); // Make the panel transparent

        JButton iniciarButton = new JButton("INICIAR");
        JButton rankingButoon = new JButton("Ranking");
        JButton orientacaoButton = new JButton("ORIENTAÇÃO");

        iniciarButton.setMaximumSize(new Dimension(200, 50));
        rankingButoon.setMaximumSize(new Dimension(200, 50));
        orientacaoButton.setMaximumSize(new Dimension(200, 50));

        // Centraliza os botões no painel
        iniciarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rankingButoon.setAlignmentX(Component.CENTER_ALIGNMENT);
        orientacaoButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adiciona espaçamento
        panel.add(Box.createVerticalGlue());
        panel.add(iniciarButton);
        panel.add(Box.createVerticalStrut(20)); // Margin entre os botões
        panel.add(rankingButoon);
        panel.add(Box.createVerticalGlue());
        panel.add(orientacaoButton);
        panel.add(Box.createVerticalGlue());

        backgroundPanel.add(panel);
        this.setContentPane(backgroundPanel);

        iniciarButton.addActionListener(e -> {
            this.dispose();
            new TelaQuestao(null, 0, 0);
        });

        rankingButoon.addActionListener(e -> {
            this.dispose();
            new TelaRanking();
        });

        orientacaoButton.addActionListener(e -> {
            this.dispose();
            new TelaOrientacoes();
        });

        this.setVisible(true);
    }
}