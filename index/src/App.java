import java.util.ArrayList;
import java.util.Scanner;

public class App {

public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    PessoaDAO dao = new PessoaDAO();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    ArrayList<Pessoa> homens = new ArrayList<>();
    ArrayList<Pessoa> mulheres = new ArrayList<>();
    ArrayList<Pessoa> funcionarios = new ArrayList<>();

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

    AreaCliente.abrir(pessoaLogada, sc, dao);

} else {

    System.out.println("\nE-mail ou senha incorretos.");

}

break;

//opcao mais chata(CADASTRO)
case 2:

System.out.println("\n------ CADASTRO ------");

System.out.print("Nome: ");
String nome = sc.nextLine();

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

System.out.print("E-mail: ");
String email = sc.nextLine();

System.out.print("Crie uma senha: ");
String senha = sc.nextLine();

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
        altura = sc.nextInt();   // CORRIGIDO
        sc.nextLine();
        break;
    } catch (Exception e) {
        System.out.println("Erro! a altura so podera ser calculado em numeros.");
        sc.nextLine();
    }
}

Pessoa pessoa = new Pessoa(nome, idade, genero, peso, altura, email, senha);


dao.cadastrar(pessoa);

pessoas.add(pessoa);

if (genero.equalsIgnoreCase("M")) {
    homens.add(pessoa);
} else if (genero.equalsIgnoreCase("F")) {
    mulheres.add(pessoa);
}

System.out.println("\nCadastro realizado com sucesso!");

break;
//parte que foi feita por ultima(planos?)
case 3:

System.out.println("\n------ PLANOS ------");
System.out.println("1 - Plano Básico");
System.out.println("2 - Plano Intermediário");
System.out.println("3 - Plano Premium");

break;


//Login de profissonais
case 4:

    System.out.println("\n------ LOGIN DE PROFISSIONAL ------");

    System.out.print("E-mail: ");
    String emailProfissional = sc.nextLine();

    System.out.print("Senha: ");
    String senhaProfissional = sc.nextLine();


    boolean login = funcionarioDAO.fazerLogin(emailProfissional, senhaProfissional);


    if (login) {

        System.out.println("\nLogin realizado com sucesso!");

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

System.out.print("Nome: ");
String nomeFuncionario = sc.nextLine();

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

System.out.print("E-mail: ");
String emailFuncionario = sc.nextLine();

System.out.print("Crie uma senha: ");
String senhaFuncionario = sc.nextLine();

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