package telas;

import model.Aluno;
import repositories.ListaDeQuestoes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TelaRanking extends JFrame {

    public TelaRanking() {
        super("Ranking de Alunos/Acertos");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/sql-guide-image.jpg"));
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        ArrayList<Aluno> alunos = new ListaDeQuestoes().buscarRanking();

        String[] columnNames = {"Nome", "Quantidade de Acertos"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Aluno aluno : alunos) {
            Object[] row = {
                    aluno.getNome(),
                    aluno.getQuantidadeAcertos()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setBackground(Color.WHITE); // Set the background color to white
        JScrollPane scrollPane = new JScrollPane(table);

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarButton.addActionListener(e -> {
            this.dispose();
            new TelaInicial();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Make the panel transparent
        buttonPanel.add(voltarButton);

        backgroundPanel.add(scrollPane, BorderLayout.CENTER);
        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.setContentPane(backgroundPanel);
        this.setVisible(true);
    }
}