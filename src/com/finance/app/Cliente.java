package com.finance.app;

public class Cliente extends Pessoa{

    private static int proximoId = 1;
    private int id;
    Conta conta;
    private String email;

    // Construtor 1
    Cliente(String cpf, String nome, String email, String dataNascimento) {
        super(cpf, nome, dataNascimento); // yyyy-MM-dd

        try {
            this.email = email;
        } catch (Exception e) {
            System.err.println("Erro ao definir email: " + e.getMessage());
            this.email = "email_invalido@placeholder.com";
        }

        this.id = proximoId++;
    }

    // Construtor 2 - agora com tratamento de exceção para o email
    Cliente(Pessoa pessoa, String email) {
        super(pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());

        try {
            this.email = email;
        } catch (Exception e) {
            System.err.println("Erro ao definir email: " + e.getMessage());
            this.email = "email_invalido@placeholder.com";
        }

        this.id = proximoId++;
    }



    public void criarConta(String numeroConta, String agencia) {
        this.conta = new Conta(numeroConta, agencia, this);
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", conta=" + conta +
                "} " +
                super.toString()
                ;
    }
}
