package com.finance.app;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    private String cpf;
    private String nome;

    private LocalDate dataNascimento;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private int id;
    private static int proximoId = 1;

    public Pessoa(String cpf, String nome, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = LocalDate.parse(dataNascimento); // yyyy-MM-dd
        this.id = proximoId++;
    }


    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        Period idade = Period.between(dataNascimento, hoje);
        return idade.getYears();
    }

    /**
    * Retorna a data de nascimento no formato yyyy-MM-dd
    * */
    public String getDataNascimento() {
        return dataNascimento.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getCpf() {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento.format(formatter) + '\'' +
                ", idade=" + getIdade() +
                '}';
    }

}
