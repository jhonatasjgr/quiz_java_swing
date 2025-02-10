package model;

public class Aluno {
    private String nome;
    private int quantidade_acertos;
    public Aluno(String nome, int quantidade_acertos){
        this.nome = nome;
        this.quantidade_acertos = quantidade_acertos;
    }
    public String getNome(){
        return nome;
    }
    public int getQuantidadeAcertos(){
        return quantidade_acertos;
    }
}
