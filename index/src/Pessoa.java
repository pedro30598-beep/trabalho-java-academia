public class Pessoa {

    String nome;
    int idade;
    String genero;
    int peso;
    int altura;
    String email;
    String senha;

    public Pessoa(String nome, int idade, String genero, int peso, int altura, String email, String senha) {

        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {

        return "Nome: " + nome +
                " | Idade: " + idade +
                " | Gênero: " + genero +
                " | Peso: " + peso +
                " | Altura: " + altura +
                " | Email: " + email;
    }
}