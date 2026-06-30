package app;

import dao.FuncionarioDAO;
import dao.PessoaDAO;
import dao.TreinoDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Funcionario;
import model.Pessoa;
import telas.AreaCliente;
import telas.AreaFuncionario;
import util.Validacao;

//App.limparTela();
public class App {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        PessoaDAO dao = new PessoaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        TreinoDAO treinoDAO = new TreinoDAO();

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Pessoa> homens = new ArrayList<>();
        ArrayList<Pessoa> mulheres = new ArrayList<>();

        //menu inicial
        String texto = "\n--- BEM-VINDOS ---\n--- ACADEMIA POWERFIT ---\n";

        for (char letra : texto.toCharArray()) {

            System.out.print(letra);
            Thread.sleep(50);

        }


        //logo inicial(Que coisa feia)
        while (true) {

            System.out.println("""
██████╗  ██████╗ ██╗    ██╗███████╗██████╗ ███████╗██╗████████╗
██╔══██╗██╔═══██╗██║    ██║██╔════╝██╔══██╗██╔════╝██║╚══██╔══╝
██████╔╝██║   ██║██║ █╗ ██║█████╗  ██████╔╝█████╗  ██║   ██║
██╔═══╝ ██║   ██║██║███╗██║██╔══╝  ██╔══██╗██╔══╝  ██║   ██║
██║     ╚██████╔╝╚███╔███╔╝███████╗██║  ██║██║     ██║   ██║
╚═╝      ╚═════╝  ╚══╝╚══╝ ╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝   ╚═╝
""");


            //Menu

            System.out.println("----------------------------------------------------------");
            System.out.println("                         MENU");
            System.out.println("----------------------------------------------------------");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastro");
            System.out.println("3 - Planos");
            System.out.println("4 - Login de profissional");
            System.out.println("5 - Cadastro de funcionário");
            System.out.println("6 - Encerrar sistema");
            System.out.println("----------------------------------------------------------");


            //mais para frente isso será repetido muitas vezes mas achei um jeito tao eficiente que nem tinha o pq não usar ctrl c e ctrl v;
            // Por mais que tenha uma maneira de deixar o codigo menos poluido acho esse jeito mais organico por assim dizer;

            int opcao = 0;


            while (true) {

                try {

                    System.out.print("Escolha uma opção: ");

                    opcao = sc.nextInt();
                    sc.nextLine();

                    break;

                } catch (Exception e) {

                    System.out.println("Erro! Digite apenas números.");
                    sc.nextLine();

                }

            }//exagerei nessas execessões, mas não quis arriscar no fato dela pegar a gnt desprevinido nisso

            App.limparTela();
            //escolha de opcoes e seus resultados
            switch (opcao) {


                case 1:


                    System.out.println("\n------ LOGIN ------");


                    System.out.print("E-mail: ");
                    String emailLogin = sc.nextLine();


                    System.out.print("Senha: ");
                    String senhaLogin = sc.nextLine();


                    Pessoa pessoaLogada = dao.buscarPessoa(emailLogin, senhaLogin);


                    if (pessoaLogada != null) {


                        System.out.println("\nLogin realizado com sucesso!");
                        System.out.println("Bem-vindo(a) à Academia PowerFit!");


                        Thread.sleep(1500);


                        limparTela();


                        AreaCliente.abrir(pessoaLogada, sc, dao, treinoDAO);


                    } else {


                        System.out.println("\nE-mail ou senha incorretos.");


                    }


                    break;
                //opcao mais chata(CADASTRO)
                case 2:

                    System.out.println("\n------ CADASTRO ------");


                    String nome;


                    while (true) {

                        System.out.print("Nome: ");

                        nome = sc.nextLine();


                        if (Validacao.validarNome(nome)) {

                            break;

                        }


                        System.out.println("Nome inválido! Digite apenas letras.");

                    }


                    //para que seja possivel colocar somente numeros, onde coloco que a idade deve ser um inteiro(ou seja, um numero)
                    int idade = 0;


                    while (true) {

                        try {

                            System.out.print("Idade: ");

                            idade = sc.nextInt();
                            sc.nextLine();

                            break;

                        } catch (Exception e) {

                            System.out.println("Erro! Digite apenas números.");
                            sc.nextLine();

                        }

                    }


                    //verificação de idade
                    if (idade < 10) {

                        System.out.println("Venha pessoalmente com seu responsável e traga seus documentos.");

                        break;

                    }


                    //mesma lógica mas limitando os caracteres em M ou F na parte de selecionar os gêneros.
                    String genero;


                    while (true) {

                        System.out.print("Gênero [M/F]: ");

                        genero = sc.nextLine().trim().toUpperCase();


                        if (genero.equals("M") || genero.equals("F")) {

                            break;

                        }


                        System.out.println("Opção inválida! Digite apenas M ou F.");

                    }


                    String email;


                    while (true) {

                        System.out.print("E-mail: ");

                        email = sc.nextLine();


                        if (Validacao.validarEmail(email)) {

                            break;

                        }


                        System.out.println("E-mail inválido! Digite um e-mail válido.");

                    }


                    String senha;


                    while (true) {

                        System.out.print("Crie uma senha: ");

                        senha = sc.nextLine();


                        if (Validacao.validarSenha(senha)) {

                            break;

                        }


                        System.out.println("Senha inválida! A senha deve ter pelo menos 6 caracteres e conter letras e números.");

                    }


                    System.out.println("\n------ FICHA ------");


                    //mesma coisa que fizemos com a idade anteriormente
                    int peso = 0;


                    while (true) {

                        try {

                            System.out.print("Peso (Kg): ");

                            peso = sc.nextInt();
                            sc.nextLine();

                            break;

                        } catch (Exception e) {

                            System.out.println("Erro! Seu peso só poderá ser informado com números.");

                            sc.nextLine();

                        }

                    }


                    //mesma coisa que fizemos com a idade anteriormente
                    int altura = 0;


                    while (true) {

                        try {

                            System.out.print("Altura (cm): ");

                            altura = sc.nextInt();   

                            sc.nextLine();

                            break;

                        } catch (Exception e) {

                            System.out.println("Erro! a altura so podera ser calculado em numeros.");

                            sc.nextLine();

                        }

                    }


                    Pessoa pessoa = new Pessoa(nome, idade, genero, peso, altura, email, senha, "Nenhum");


                    dao.cadastrar(pessoa);


                    pessoas.add(pessoa);


                    if (genero.equalsIgnoreCase("M")) {

                        homens.add(pessoa);

                    } else if (genero.equalsIgnoreCase("F")) {

                        mulheres.add(pessoa);

                    }


                    System.out.println("\nCadastro realizado com sucesso!");

                //parte que foi feita por ultima(planos?)
                    break;
                case 3:

                System.out.println("Entre na sua conta para escolher um plano.");

                break;
                //Login de profissonais
                case 4:

                    System.out.println("\n------ LOGIN DE PROFISSIONAL ------");


                    System.out.print("E-mail: ");
                    String emailProfissional = sc.nextLine();


                    System.out.print("Senha: ");
                    String senhaProfissional = sc.nextLine();


                    Funcionario funcionarioLogado = funcionarioDAO.buscarFuncionario(emailProfissional, senhaProfissional);


                    if (funcionarioLogado != null) {


                        System.out.println("\nLogin realizado com sucesso!");


                        Thread.sleep(1500);


                        limparTela();


                        AreaFuncionario.abrir(funcionarioLogado, sc, funcionarioDAO, dao, treinoDAO);


                    } else {


                        System.out.println("\nE-mail ou senha incorretos!");


                    }


                    break;



                //cadastro de funcionarios(junto com as senhas de acesso prestabelecidas e tudo mais)
                case 5:


                    System.out.println("\n------ CADASTRO DE FUNCIONÁRIO ------");


                    int senhaMestre = 0;


                    //chave de acesso funcionario
                    while (true) {


                        try {


                            System.out.print("Digite a senha de autorização: ");

                            senhaMestre = sc.nextInt();

                            sc.nextLine();


                            if (senhaMestre == 39182733) {


                                System.out.println("Senha correta.");

                                break;


                            }


                            System.out.println("Senha incorreta. Tente novamente.");


                        } catch (Exception e) {


                            System.out.println("A senha deve conter apenas números.");

                            sc.nextLine();


                        }

                    }


                    String nomeFuncionario;


                    while (true) {


                        System.out.print("Nome: ");

                        nomeFuncionario = sc.nextLine();


                        if (Validacao.validarNome(nomeFuncionario)) {


                            break;


                        }


                        System.out.println("Nome inválido! Digite apenas letras.");


                    }



                    //dnv kkkkk
                    int idadeFuncionario = 0;


                    while (true) {


                        try {


                            System.out.print("Idade: ");

                            idadeFuncionario = sc.nextInt();

                            sc.nextLine();


                            break;


                        } catch (Exception e) {


                            System.out.println("Erro! Digite apenas números.");

                            sc.nextLine();


                        }

                    }


                    System.out.print("Cargo: ");

                    String cargo = sc.nextLine();



                    String emailFuncionario;


                    while (true) {


                        System.out.print("E-mail: ");

                        emailFuncionario = sc.nextLine();


                        if (Validacao.validarEmail(emailFuncionario)) {


                            break;


                        }


                        System.out.println("E-mail inválido! Digite um e-mail válido.");


                    }



                    String senhaFuncionario;


                    while (true) {


                        System.out.print("Crie uma senha: ");

                        senhaFuncionario = sc.nextLine();


                        if (Validacao.validarSenha(senhaFuncionario)) {


                            break;


                        }


                        System.out.println("Senha inválida! A senha deve ter pelo menos 6 caracteres e conter letras e números.");


                    }



                    Funcionario funcionario = new Funcionario(
                            nomeFuncionario,
                            idadeFuncionario,
                            cargo,
                            emailFuncionario,
                            senhaFuncionario
                    );


                    funcionarioDAO.cadastrar(funcionario);


                    System.out.println("\nFuncionário cadastrado com sucesso!");

                    System.out.println("Cargo: " + cargo);


                    break;



                //encerrando o processo.
                case 6:


                    System.out.println("Sistema encerrado.");


                    sc.close();

                    return;



                //caso o usuario aperte o botão errado.
                default:


                    System.out.println("Opção inválida.");


                    break;


            }


        }


    }


    public static void limparTela() {


        try {


            String sistema = System.getProperty("os.name");


            if (sistema.contains("Windows")) {


                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();


            } else {


                new ProcessBuilder("clear")
                        .inheritIO()
                        .start()
                        .waitFor();


            }


        } catch (Exception e) {


            e.printStackTrace();


        }


    }

}