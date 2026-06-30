package model;

public class Plano {

    String nome;
    double preco;
    String beneficios;


    public Plano(String nome, double preco, String beneficios) {

        this.nome = nome;
        this.preco = preco;
        this.beneficios = beneficios;

    }


    @Override
    public String toString() {

        return "Plano: " + nome +
                "\nPreço: R$ " + preco +
                "\nBenefícios: " + beneficios;

    }

}