import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        try {

            Connection conexao = Conexao.conectar();

            System.out.println("Conectado ao MySQL com sucesso!");

            conexao.close();

        } catch (Exception e) {

            System.out.println("Erro:");
            e.printStackTrace();

        }

    }

}