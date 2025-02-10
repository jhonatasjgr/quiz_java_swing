package telas;

import repositories.ListaDeQuestoes;

import javax.swing.*;
import java.awt.*;

public class TelaSalvar {

    public TelaSalvar(int qtdAcertos) {
        JFrame frame = new JFrame("Salvar Resultado");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel acertosLabel = new JLabel("Quantidade de Acertos: " + qtdAcertos);
        acertosLabel.setFont(new Font("Arial", Font.BOLD, 16));
        acertosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nome = new JTextField();
        nome.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        nome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        salvarButton.addActionListener(e -> {
            String nome2 = nome.getText();
            if (!nome2.isEmpty()) { // O campo não pode estra vazio
                new ListaDeQuestoes().salvarResultado(nome2, qtdAcertos);
                frame.dispose();
                new TelaInicial();
            } else {
                JOptionPane.showMessageDialog(frame, "Insira seu nome", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(acertosLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(new JLabel("Nome:"));
        panel.add(nome);
        panel.add(Box.createVerticalStrut(20));
        panel.add(salvarButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}