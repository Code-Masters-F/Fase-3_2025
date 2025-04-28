package com.finance.app;

public class Crypto {
    // Atributos
    private static int proximoId = 1;
    private int id;
    private String nome; // nome da cripto
    private String simbolo; // simbolo da cripto
    private int anoLancamento; // ano da cripto

    // Construtor
    public Crypto(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.id = proximoId++;
    }

    // Métodos com tipos de retorno corretos
    public String getNome() {
        return nome;  // Retorna String em vez de void
    }

    public String getSimbolo() {
        return simbolo;  // Retorna String em vez de void
    }

    public int getAnoLancamento() {
        return anoLancamento;  // Retorna int em vez de void
    }

    // para definir o ano de lançamento
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return "Crypto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}