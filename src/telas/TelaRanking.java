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

        ArrayList<Aluno> alunos = new ListaDeQuestoes().buscarRanking();

        String[] columnNames = {"Nome", "Quantidade de Acertos"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Aluno aluno : alunos) {
            Object[] row = {
                    aluno.getNome(),
                    aluno.getQuantidadeAcertos()
            };
            model.addRow(row);
        }//linhas

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);//barra de rolagem
        table.setFillsViewportHeight(true);//para preencher toda a tabela

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarButton.addActionListener(e -> {
            this.dispose();
            new TelaInicial();
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(voltarButton, BorderLayout.SOUTH);

        this.add(panel);
        this.setVisible(true);
    }
}