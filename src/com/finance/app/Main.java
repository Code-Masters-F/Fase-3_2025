package com.finance.app;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Main {
    // metodo que verifica se o email está certo ou não
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    // Polimorfismo manual. A classe Cliente pode se passar pela classe Pessoa
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
            System.out.println("CPF inválido. Deve conter 11 dígitos numéricos.");
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
            System.out.println("E-mail inválido. Formato correto: exemplo@dominio.com");
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
                System.out.println("Formato de data inválido. Utilize YYYY-MM-DD.");
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

            Cliente cliente123 = new Cliente(cpf1, nome1, email1, dataNasc1);
            cliente123.criarConta("123123", "0001");

            System.out.println("\nIdade do cliente: " + calcularIdade(cliente123));
            System.out.println(cliente123 + "\n");

            // Exemplos de uso de outras classes e mais funcionalidades em prática
            Pessoa maria = new Pessoa("22222244444", "Maria", "1994-03-03");
            Cliente maria123 = new Cliente(maria, "maria@email.com");

            maria123.criarConta("456456", "0001");
            cliente123.contaCliente.depositar(20.01f);
            cliente123.contaCliente.transferirContasCorretora(maria123.contaCliente, 10.5f);
            System.out.println(maria123.contaCliente);
            System.out.println(cliente123.contaCliente);
            System.out.println(cliente123);

            Crypto ethereum = new Crypto("Ethereum", "ETH");
            ethereum.setAnoLancamento(2015);
            System.out.println(ethereum);

        } catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
/*
    OBS:
    Há funcionalidades que ainda serão polidas com o decorrer do projeto.
    Algumas delas são as funcionalidade de comprar e vender Crypto de ContaCliente. Há a necessidade
    de conhecimento em algumas estruturas de dados que provavelmente devem ser ensinadas na proxima fase.
 */
