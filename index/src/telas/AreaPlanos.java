package telas;

import dao.PessoaDAO;
import java.util.Scanner;
import model.Pessoa;

//limparTela()
public class AreaPlanos {

    public static void abrir(Pessoa pessoa, Scanner sc, PessoaDAO dao) {

        while (true) {

            System.out.println("""
------ PLANOS POWERFIT ------

1 - Plano Básico
2 - Plano Intermediário
3 - Plano Premium
4 - Voltar
""");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1: {

                    pessoa.plano = "Básico";

                    dao.atualizarAluno(pessoa);

                    System.out.println("Plano Básico escolhido com sucesso!");

                    break;

                }


                case 2: {

                    pessoa.plano = "Intermediário";

                    dao.atualizarAluno(pessoa);

                    System.out.println("Plano Intermediário escolhido com sucesso!");

                    break;

                }


                case 3: {

                    pessoa.plano = "Premium";

                    dao.atualizarAluno(pessoa);

                    System.out.println("Plano Premium escolhido com sucesso!");

                    break;

                }


                case 4: {

                    System.out.println("Voltando...");

                    return;

                }


                default: {

                    System.out.println("Opção inválida.");

                    break;

                }

            }

        }

    }

}