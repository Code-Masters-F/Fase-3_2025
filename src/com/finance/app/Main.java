package com.finance.app;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Main {
    // metodo que verifica se o email está certo ou não
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    // Polimorfismo manual: método que retorna a idade de um objeto Pessoa
    private static int calcularIdade(Pessoa pessoa) {
        return pessoa.getIdade();
    }

    // Lê CPF válido (11 dígitos) do Scanner
    private static String lerCPF(Scanner scanner) {
        String cpf;
        while (true) {
            System.out.print("Digite o CPF (11 dígitos): ");
            cpf = scanner.nextLine().replaceAll("\\D", "");
            if (cpf.matches("\\d{11}")) {
                return cpf;
            }
            System.err.println("CPF inválido. Deve conter 11 dígitos numéricos.");
        }
    }

    // Lê e-mail válido do Scanner
    private static String lerEmail(Scanner scanner) {
        String email;
        while (true) {
            System.out.print("Digite o e-mail: ");
            email = scanner.nextLine();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            }
            System.err.println("E-mail inválido. Formato correto: exemplo@dominio.com");
        }
    }

    // Lê data de nascimento válida (YYYY-MM-DD) do Scanner
    private static String lerData(Scanner scanner) {
        String data;
        while (true) {
            System.out.print("Digite a data de nascimento (YYYY-MM-DD): ");
            data = scanner.nextLine();
            try {
                LocalDate.parse(data);
                return data;
            } catch (DateTimeParseException e) {
                System.err.println("Formato de data inválido. Utilize YYYY-MM-DD.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("=== Cadastro de Cliente ===");

            String cpf1 = lerCPF(scanner);
            System.out.print("Digite o nome: ");
            String nome1 = scanner.nextLine();
            String email1 = lerEmail(scanner);
            String dataNasc1 = lerData(scanner);

            Cliente robson123 = new Cliente(cpf1, nome1, email1, dataNasc1);
//
//            // Exemplos de uso de outras classes (sem alterações)
//            Pessoa maria = new Pessoa("22222244444", "Maria", "1994-03-03");
//            Cliente maria123 = new Cliente(maria, "maria@email.com");
//
//            System.out.println(robson123);
//            robson123.criarConta("123123", "0001");
//            maria123.criarConta("456456", "0001");
//            robson123.contaCliente.depositar(20.01f);
//            robson123.contaCliente.transferirContasCorretora(maria123.contaCliente, 10.5f);
//            System.out.println(maria123.contaCliente);
//            System.out.println(robson123.contaCliente);
//            System.out.println(robson123);
//
//            Crypto ethereum = new Crypto("Ethereum", "ETH");
//            ethereum.setAnoLancamento(2015);
//            System.out.println(ethereum);

            System.out.println("Idade do cliente: " + calcularIdade(robson123));

        } catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
