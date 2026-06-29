public class Funcionario {

    String nome;
    int idade;
    String cargo;
    String email;
    String senha;


    public Funcionario(String nome, int idade, String cargo, String email, String senha) {

        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;

    }


    @Override
    public String toString() {

        return "Nome: " + nome +
                " | Idade: " + idade +
                " | Cargo: " + cargo +
                " | Email: " + email;

    }

}