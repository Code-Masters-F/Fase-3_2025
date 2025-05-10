package com.finance.app;

public class Cliente extends Pessoa{

    private static int proximoId = 1;
    private int id;
    ContaCliente contaCliente;
    private String email;

    // Construtor 1
    Cliente(String cpf, String nome, String email, String dataNascimento) {
        super(cpf, nome, dataNascimento); // yyyy-MM-dd
        this.email = email;
        // this.conta = criarConta(...);

        this.id = proximoId++;
    }

    // Construtor 2
    Cliente(Pessoa pessoa, String email) {
        super(pessoa.getCpf(), pessoa.getNome(), pessoa.getDataNascimento());
        this.email = email;
        this.id = proximoId++;
    }


    public void criarConta(String numeroConta, String agencia) {
        this.contaCliente = new ContaCliente(numeroConta, agencia, this);
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", conta=" + contaCliente +
                "} " +
                super.toString()
                ;
    }
}
