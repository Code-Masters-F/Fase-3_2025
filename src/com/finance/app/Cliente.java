package com.finance.app;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Cliente {

    private static int proximoId = 1; // usado para atribuir IDs únicos para as instancias de objetos
    private int id;
    private String cpf;
    Conta conta;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // data_nascimento deve ser passada no formato yyyy-MM-dd
    Cliente(String cpf, String nome, String email, String data_nascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(data_nascimento);
        this.email = email;
        // this.conta = criarConta(...);

        this.id = proximoId++;
    }



    public void criarConta(String numeroConta, String agencia) {
        this.conta = new Conta(numeroConta, agencia, this);
    }


    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento.format(formatter);
    }


    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(dataNascimento, hoje);
        return idade.getYears(); // Data atual - Data de nascimento
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento='" + getDataNascimento() + '\'' +
                ", idade=" + getIdade() +
                '}';
    }


}
