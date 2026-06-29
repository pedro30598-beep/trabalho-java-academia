import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO {

    public void cadastrar(Pessoa pessoa) {

        String sql = "INSERT INTO pessoas(nome,idade,genero,peso,altura,email,senha) VALUES(?,?,?,?,?,?,?)";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, pessoa.nome);
            stmt.setInt(2, pessoa.idade);
            stmt.setString(3, pessoa.genero);
            stmt.setInt(4, pessoa.peso);
            stmt.setInt(5, pessoa.altura);
            stmt.setString(6, pessoa.email);
            stmt.setString(7, pessoa.senha);

            stmt.executeUpdate();

            stmt.close();
            conexao.close();

            System.out.println("Pessoa cadastrada com sucesso!");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    // Login com o banco de dados ATENÇÂO
    public boolean fazerLogin(String email, String senha) {

        String sql = "SELECT * FROM pessoas WHERE email = ? AND senha = ?";

        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            boolean loginValido = rs.next();

            rs.close();
            stmt.close();
            conexao.close();

            return loginValido;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }
public Pessoa buscarPessoa(String email, String senha) {

    String sql = "SELECT * FROM pessoas WHERE email = ? AND senha = ?";

    try {

        Connection conexao = Conexao.conectar();

        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();


        if (rs.next()) {

            Pessoa pessoa = new Pessoa(
                rs.getString("nome"),
                rs.getInt("idade"),
                rs.getString("genero"),
                rs.getInt("peso"),
                rs.getInt("altura"),
                rs.getString("email"),
                rs.getString("senha")
            );

            rs.close();
            stmt.close();
            conexao.close();

            return pessoa;
        }


    } catch (Exception e) {

        e.printStackTrace();

    }

    return null;
}
public void alterarSenha(String email, String novaSenha) {

    String sql = "UPDATE pessoas SET senha = ? WHERE email = ?";


    try {

        Connection conexao = Conexao.conectar();

        PreparedStatement stmt = conexao.prepareStatement(sql);


        stmt.setString(1, novaSenha);
        stmt.setString(2, email);


        stmt.executeUpdate();


        stmt.close();
        conexao.close();


        System.out.println("Senha alterada com sucesso!");


    } catch (Exception e) {

        e.printStackTrace();

    }

}
}
