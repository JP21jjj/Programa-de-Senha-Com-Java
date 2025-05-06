import java.util.Scanner;

import java.util.regex.Pattern;


public class ValidadorSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String senha;

        while (true) {
            System.out.print("Digite uma senha: ");
            senha = scanner.nextLine();

            if (senhaValida(senha)) {
                System.out.println("Senha válida!");
                break; // sai do loop quando a senha for válida
            } else {
                System.out.println("Senha inválida! A senha deve conter pelo menos:");
                System.out.println("- 8 caracteres;");
                System.out.println("- 1 letra maiúscula (A-Z);");
                System.out.println("- 1 letra minúscula (a-z);");
                System.out.println("- 1 número (0-9);");
                System.out.println("- 1 caractere especial (!@#$%^&*()-+).");
                System.out.println("Tente novamente.\n");
            }
        }

        scanner.close();
    }

    public static boolean senhaValida(String senha) {
        if (senha.length() < 8) {
            return false;
        }

        if (!Pattern.compile("[A-Z]").matcher(senha).find()) {
            return false;
        }

        if (!Pattern.compile("[a-z]").matcher(senha).find()) {
            return false;
        }

        if (!Pattern.compile("[0-9]").matcher(senha).find()) {
            return false;
        }

        if (!Pattern.compile("[!@#$%^&*()\\-]").matcher(senha).find()) {
            return false;
        }

        return true;

    }
}