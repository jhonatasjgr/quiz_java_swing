package repositories;

import model.Aluno;
import model.Questao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListaDeQuestoes {

    public ArrayList<Questao> buscarQuestoes() {
        ArrayList<Questao> questoes = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
            Statement stmt = conn.createStatement();

            // Sortear automaticamente 5 questões
            ResultSet rsIds = stmt.executeQuery("SELECT id FROM questao ORDER BY RAND() LIMIT 5");
            ArrayList<Integer> ids = new ArrayList<>();

            while (rsIds.next()) {
                ids.add(rsIds.getInt("id"));
            }
            for (int id : ids) {
                PreparedStatement pstmt = conn.prepareStatement("SELECT enunciado, alternativa1, alternativa2, alternativa3, alternativa4, alternativa_certa FROM questao WHERE id = ?");
                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    List<String> alternativas = new ArrayList<>();
                    alternativas.add(rs.getString("alternativa1"));
                    alternativas.add(rs.getString("alternativa2"));
                    alternativas.add(rs.getString("alternativa3"));
                    alternativas.add(rs.getString("alternativa4"));
                    Collections.shuffle(alternativas); // embaralhar as alternativas aleatóriamente

                    questoes.add(new Questao(
                            rs.getString("enunciado"),
                            alternativas.get(0),
                            alternativas.get(1),
                            alternativas.get(2),
                            alternativas.get(3),
                            rs.getString("alternativa_certa")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return questoes;
    }

    public void salvarResultado(String nome, int quantidade_acertos) {
        String sql = "INSERT INTO aluno (nome, quantidade_acertos) VALUES (?, ?)";
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, quantidade_acertos);
            stmt.executeUpdate();
            System.out.println("Resultado salvo no banco de dados!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Aluno> buscarRanking(){
        ArrayList<Aluno> alunos = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nome, quantidade_acertos FROM aluno ORDER BY quantidade_acertos DESC");
            while (rs.next()) {
                alunos.add(
                        new Aluno(rs.getString("nome"), rs.getInt("quantidade_acertos")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return alunos;
    }
}
