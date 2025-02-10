package telas;

import javax.swing.*;
import java.awt.*;

public class TelaOrientacoes extends JFrame {

    public TelaOrientacoes() {
        super("Orientações sobre o Quiz");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel orientacoesLabel = new JLabel(
                "<html>" +
                        "<div style='text-align: center;'>" +
                        "<p>" +
                        "Jogo de Quiz de POO e SQL<br>" +
                        "<br><br>" +
                        "O jogo consiste em um quiz com 5 perguntas.<br> " +
                        "O objetivo é responder corretamente o maior número possível de questões. " +
                        "Ao final, a pontuação será salva junto com o nome do participante no banco de dados, " +
                        "e um ranking dos melhores jogadores será exibido." +
                        "<br>" +
                        "Cada pergunta tem 4 alternativas.<br>" +
                        "O jogador deve escolher a resposta clicando na alternativa correspondente.<br>" +
                        "Cada resposta correta vale 1 ponto.<br>" +
                        "O jogo exibe a pontuação final após a última pergunta.<br>" +
                        "O nome do jogador e sua pontuação são armazenados no banco de dados.<br>" +
                        "</p>" +
                        "</div>" +
                        "</html>"
        );
        orientacoesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        orientacoesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarButton.addActionListener(e -> {
            this.dispose();
            new TelaInicial();
        });

        panel.add(orientacoesLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(voltarButton);

        this.add(panel);
        this.setVisible(true);
    }
}