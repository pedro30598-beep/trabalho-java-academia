package model;

public class Funcionario {

public String nome;
public int idade;
public String cargo;
public String email;
public String senha;


    public Funcionario(String nome, int idade, String cargo, String email, String senha) {

        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;

    }


    public String getNome() {
        return nome;
    }


    public int getIdade() {
        return idade;
    }


    public String getCargo() {
        return cargo;
    }


    public String getEmail() {
        return email;
    }


    public String getSenha() {
        return senha;
    }


    @Override
    public String toString() {

        return "Nome: " + nome +
               "\nIdade: " + idade +
               "\nCargo: " + cargo +
               "\nEmail: " + email;

    }

}