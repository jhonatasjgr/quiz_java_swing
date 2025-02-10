package model;

public class Questao {
    public String enunciado;
    public String opcao1;
    public String opcao2;
    public String opcao3;
    public String opcao4;
    public String alternativaCerta;

    public Questao(String enunciado, String opcao1, String opcao2, String opcao3, String opcao4, String alternativaCerta) {
        this.enunciado = enunciado;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.opcao3 = opcao3;
        this.opcao4 = opcao4;
        this.alternativaCerta = alternativaCerta;
    }



}
