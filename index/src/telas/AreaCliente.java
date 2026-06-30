package telas;

import dao.PessoaDAO;
import dao.TreinoDAO;
import java.util.Scanner;
import model.Pessoa;

public class AreaCliente {

    public static void abrir(Pessoa pessoa, Scanner sc, PessoaDAO dao, TreinoDAO treinoDAO) {

        while (true) {

            System.out.println("""
------ ÁREA DO CLIENTE ------

1 - Ver ficha técnica
2 - Alterar senha
3 - Trocar conta
4 - Escolher plano
5 - Encerrar programa
""");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1: {

                    System.out.println("\n------ FICHA TÉCNICA ------");

                    System.out.println(pessoa);

                    System.out.println("\n------ TREINOS ------");

                    treinoDAO.mostrarTreinosAluno(pessoa.email);

                    break;

                }

                case 2: {

                    System.out.print("Digite a nova senha: ");

                    String novaSenha = sc.nextLine();

                    dao.alterarSenha(pessoa.email, novaSenha);

                    pessoa.senha = novaSenha;

                    break;

                }

                case 3: {

                    System.out.println("Saindo da conta...");

                    return;

                }

                case 4: {

                    AreaPlanos.abrir(pessoa, sc, dao);

                    break;

                }

                case 5: {

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