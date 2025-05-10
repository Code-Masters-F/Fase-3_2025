package com.finance.app;

public class Main {
    public static void main(String[] args) {



        // Algumas sugestões de teste:


        // Testes Classe Cliente:
        Cliente robson123 = new Cliente("222222-33333", "Robson", "robsone@mail.com", "2000-02-02");
        Pessoa maria = new Pessoa("222222-44444", "Maria", "1994-03-03");
        Cliente maria123 = new Cliente(maria, "maria@email.com");

        System.out.println(robson123.toString());

        robson123.criarConta("123123", "0001");
        maria123.criarConta("456456", "0001");

        robson123.contaCliente.depositar(20.01f);
        robson123.contaCliente.transferirContasCorretora(maria123.contaCliente, 10.5f);
        System.out.println(maria123.contaCliente.toString());
        System.out.println(robson123.contaCliente.toString());
        System.out.println(robson123.toString());

        Crypto ethereum = new Crypto("Ethereum", "ETH");
        ethereum.setAnoLancamento(2015); // definindo o ano de lançamento da criptomoeda
        System.out.println(ethereum.toString());



    }
}
