package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Treino;


public class TreinoDAO {


    public void cadastrarTreino(Treino treino) {


        String sql = "INSERT INTO treinos(email_aluno, treino, funcionario) VALUES(?,?,?)";


        try {


            Connection conexao = Conexao.conectar();


            PreparedStatement stmt = conexao.prepareStatement(sql);



            stmt.setString(1, treino.emailAluno);
            stmt.setString(2, treino.descricao);
            stmt.setString(3, treino.funcionario);



            stmt.executeUpdate();



            stmt.close();
            conexao.close();



            System.out.println("Treino cadastrado com sucesso!");



        } catch(Exception e) {


            e.printStackTrace();


        }


    }



    public void mostrarTreinosAluno(String emailAluno) {


        String sql = "SELECT * FROM treinos WHERE email_aluno = ?";


        try {


            Connection conexao = Conexao.conectar();


            PreparedStatement stmt = conexao.prepareStatement(sql);


            stmt.setString(1, emailAluno);


            ResultSet rs = stmt.executeQuery();



            System.out.println("\n------ MEU TREINO ------");


            boolean encontrou = false;



            while (rs.next()) {


                encontrou = true;


                System.out.println(
                        "Treino: " + rs.getString("treino")
                );


                System.out.println(
                        "Funcionário responsável: " + rs.getString("funcionario")
                );


                System.out.println("------------------------");


            }



            if (!encontrou) {


                System.out.println("Nenhum treino cadastrado.");


            }



            rs.close();
            stmt.close();
            conexao.close();



        } catch(Exception e) {


            e.printStackTrace();


        }


    }


}