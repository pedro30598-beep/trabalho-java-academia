package util;

public class Validacao {

    public static boolean validarEmail(String email) {

        if (email == null || email.isBlank()) {
            return false;
        }

        email = email.toLowerCase();

        String regex = "^[A-Za-z0-9+_.-]+@(gmail\\.com|hotmail\\.com|outlook\\.com|icloud\\.com|yahoo\\.com|proton\\.me|uol\\.com\\.br|bol\\.com\\.br|terra\\.com\\.br|globo\\.com|ig\\.com\\.br)$";

        return email.matches(regex);

    }

    public static boolean validarNome(String nome) {

        if (nome == null || nome.isBlank()) {
            return false;
        }

        return nome.matches("[a-zA-ZÀ-ÿ ]+");

    }

    public static boolean validarSenha(String senha) {

        if (senha == null || senha.isBlank()) {
            return false;
        }

        String regex = "^(?=.*[A-Za-z])(?=.*[0-9]).{6,}$";

        return senha.matches(regex);

    }

}