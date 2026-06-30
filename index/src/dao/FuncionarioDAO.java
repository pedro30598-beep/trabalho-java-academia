package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Funcionario;

public class FuncionarioDAO {


    // CADASTRAR FUNCIONÁRIO
    public void cadastrar(Funcionario funcionario) {

        String sql = "INSERT INTO funcionarios(nome, idade, cargo, email, senha) VALUES(?,?,?,?,?)";


        try {

            Connection conexao = Conexao.conectar();

            PreparedStatement stmt = conexao.prepareStatement(sql);


            stmt.setString(1, funcionario.nome);
            stmt.setInt(2, funcionario.idade);
            stmt.setString(3, funcionario.cargo);
            stmt.setString(4, funcionario.email);
            stmt.setString(5, funcionario.senha);


            stmt.executeUpdate();


            stmt.close();
            conexao.close();


            System.out.println("Funcionário cadastrado com sucesso!");


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public boolean fazerLogin(String email, String senha) {


        String sql = "SELECT * FROM funcionarios WHERE email = ? AND senha = ?";


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

    public Funcionario buscarFuncionario(String email, String senha) {


        String sql = "SELECT * FROM funcionarios WHERE email = ? AND senha = ?";



        try {


            Connection conexao = Conexao.conectar();


            PreparedStatement stmt = conexao.prepareStatement(sql);



            stmt.setString(1, email);
            stmt.setString(2, senha);



            ResultSet rs = stmt.executeQuery();



            if (rs.next()) {


                Funcionario funcionario = new Funcionario(

                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("cargo"),
                        rs.getString("email"),
                        rs.getString("senha")

                );



                rs.close();
                stmt.close();
                conexao.close();



                return funcionario;


            }



            rs.close();
            stmt.close();
            conexao.close();



        } catch (Exception e) {


            e.printStackTrace();


        }



        return null;


    }
    public void alterarSenha(String email, String novaSenha) {



        String sql = "UPDATE funcionarios SET senha = ? WHERE email = ?";



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