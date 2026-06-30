package telas;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.TreinoDAO;
import java.util.Scanner;
import model.Funcionario;
import model.Pessoa;
import model.Treino;


public class AreaFuncionario {
    public static void abrir(Funcionario funcionario, Scanner sc,
    FuncionarioDAO funcionarioDAO, PessoaDAO pessoaDAO, TreinoDAO treinoDAO) {


        while (true) {


            System.out.println("""
                    
                    ------ ÁREA DO FUNCIONÁRIO ------
                    
                    1 - Buscar aluno
                    2 - Alterar dados do aluno
                    3 - Cadastrar treino
                    4 - Ver todos os alunos
                    5 - Alterar minha senha
                    6 - Trocar conta
                    7 - Encerrar programa
                    
                    """);



            int opcao = sc.nextInt();
            sc.nextLine();



            switch (opcao) {



                case 1: {


                    System.out.print("Digite o e-mail do aluno: ");
                    String emailAluno = sc.nextLine();



                    Pessoa aluno = pessoaDAO.buscarPorEmail(emailAluno);



                    if (aluno != null) {


                        System.out.println("\n------ DADOS DO ALUNO ------");
                        System.out.println(aluno);



                    } else {


                        System.out.println("Aluno não encontrado.");


                    }



                    break;

                }




                case 2: {


                    System.out.print("Digite o email do aluno: ");
                    String email = sc.nextLine();



                    Pessoa aluno = pessoaDAO.buscarPorEmail(email);



                    if (aluno != null) {



                        System.out.print("Novo nome: ");
                        aluno.nome = sc.nextLine();



                        System.out.print("Nova idade: ");
                        aluno.idade = sc.nextInt();
                        sc.nextLine();



                        System.out.print("Novo gênero: ");
                        aluno.genero = sc.nextLine();



                        System.out.print("Novo peso: ");
                        aluno.peso = sc.nextInt();



                        System.out.print("Nova altura: ");
                        aluno.altura = sc.nextInt();
                        sc.nextLine();



                        pessoaDAO.atualizarAluno(aluno);



                    } else {


                        System.out.println("Aluno não encontrado.");


                    }



                    break;

                }





                case 3: {


    System.out.print("Digite o email do aluno: ");
    String emailAluno = sc.nextLine();


    Pessoa aluno = pessoaDAO.buscarPorEmail(emailAluno);


    if(aluno != null) {


        System.out.println("Digite o treino:");

        String descricao = sc.nextLine();



        Treino treino = new Treino(
                emailAluno,
                descricao,
                funcionario.nome
        );



        treinoDAO.cadastrarTreino(treino);



    } else {


        System.out.println("Aluno não encontrado.");

    }



    break;

}





                case 4: {


                    pessoaDAO.listarPessoas();


                    break;


                }
                case 5: {



                    System.out.print("Digite a nova senha: ");
                    String novaSenha = sc.nextLine();



                    funcionarioDAO.alterarSenha(funcionario.email, novaSenha);



                    funcionario.senha = novaSenha;



                    break;

                }





                case 6: {



                    System.out.println("Saindo da conta...");

                    return;



                }





                case 7: {



                    System.out.println("Programa encerrado.");

                    sc.close();

                    System.exit(0);



                }





                default: {



                    System.out.println("Opção inválida.");

                    break;

                }
            }
        }
   }
}