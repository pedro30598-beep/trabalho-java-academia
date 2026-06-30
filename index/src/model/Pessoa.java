package model;

public class Pessoa {

    public String nome;
    public int idade;
    public String genero;
    public int peso;
    public int altura;
    public String email;
    public String senha;
    public String plano;


    public Pessoa(String nome, int idade, String genero, int peso, int altura, String email, String senha, String plano) {

        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
        this.email = email;
        this.senha = senha;
        this.plano = plano;

    }


    @Override
    public String toString() {

        return "Nome: " + nome +
                " | Idade: " + idade +
                " | Gênero: " + genero +
                " | Peso: " + peso + " kg" +
                " | Altura: " + altura + " cm" +
                " | Email: " + email +
                " | Plano: " + plano;

    }

}