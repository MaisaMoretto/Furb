package pilha.q5.validacao.delimitadores;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma expressão aritmética:");
        String expressao = scanner.nextLine();

        ValidadorDelimitadores validador = new ValidadorDelimitadores();

        if (validador.validar(expressao)) {
            System.out.println("O uso de delimitadores está correto.");
        } else {
            System.out.println("O uso de delimitadores está incorreto.");
        }
        scanner.close();
    }
}
