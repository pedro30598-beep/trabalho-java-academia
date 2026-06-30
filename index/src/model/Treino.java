package model;

public class Treino {

    public int id;
    public String emailAluno;
    public String descricao;
    public String funcionario;


    public Treino(String emailAluno, String descricao, String funcionario) {

        this.emailAluno = emailAluno;
        this.descricao = descricao;
        this.funcionario = funcionario;

    }


    @Override
    public String toString() {

        return "Aluno: " + emailAluno +
                "\nTreino: " + descricao +
                "\nFuncionário responsável: " + funcionario;

    }

}
