package telas;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {
    String orientacoesSobreOJogo = "Orientações sobre o Quizz";

    public TelaInicial() {
        super("Quiz POO & SQL");
        this.setSize(800, 600); // Tamanho da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //Centralizar a janela


        String imagePath = "../source/sql-guide-image.jpg";
        ImageIcon backgroundImage = new ImageIcon(imagePath);
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));



        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));//alinhar todos os componentes em (Y)
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);//Jogar tudo para o centro


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


        iniciarButton.addActionListener(e ->{
                    this.dispose();
                TelaQuestao telaQuestao = new TelaQuestao(null,0,0);}
                );

        rankingButoon.addActionListener(e ->
        {
            this.dispose();
            TelaRanking telaRanking = new TelaRanking();
        });
        orientacaoButton.addActionListener(e -> {
            this.dispose();
            TelaOrientacoes telaOrientacoes = new TelaOrientacoes();
        });

        this.setVisible(true);
    }
}