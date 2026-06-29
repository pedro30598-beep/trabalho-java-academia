import java.util.Scanner;

public class AreaCliente {


    public static void abrir(Pessoa pessoa, Scanner sc, PessoaDAO dao) {


        while (true) {


            System.out.println("""
            
            ------ ÁREA DO CLIENTE ------

            1 - Ver ficha técnica
            2 - Alterar senha
            3 - Trocar conta
            4 - Encerrar programa

            """);


            int opcao = sc.nextInt();
            sc.nextLine();


            switch (opcao) {


                case 1:

                    System.out.println("\n------ FICHA TÉCNICA ------");
                    System.out.println(pessoa);

                    break;


                case 2:

                    System.out.print("Digite a nova senha: ");
                    String novaSenha = sc.nextLine();


                    dao.alterarSenha(pessoa.email, novaSenha);


                    break;


                case 3:

                    System.out.println("Saindo da conta...");
                    return;


                case 4:

                    System.out.println("Programa encerrado.");
                    sc.close();
                    System.exit(0);


                default:

                    System.out.println("Opção inválida.");

            }

        }

    }

}