package com.finance.app;

import java.time.Year;

public class Crypto {
    // Atributos
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String simbolo;
    private int anoLancamento = 0; // Inicializando com valor padrão 0

    // Construtor
    public Crypto(String nome, String simbolo) {
        try {
            validarCampoNaoVazio(nome, "Nome");
            validarCampoNaoVazio(simbolo, "Simbolo");

            this.nome = nome;
            this.simbolo = simbolo;
            this.id = proximoId++;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar Crypto: " + e.getMessage());
        }
    }

    // Método para validação de campos não vazios
    private void validarCampoNaoVazio(String valor, String campo) {
        try {
            if (valor == null || valor.trim().isEmpty()) {
                throw new IllegalArgumentException(campo + " não pode ser nulo ou vazio");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Erro no campo " + campo + ": " + e.getMessage());
            throw e;  // Re-lançando a exceção após o log
        }
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public int getId() {
        return id;
    }

    // Método setter para o ano de lançamento
    public void setAnoLancamento(int anoLancamento) {
        try {
            if (anoLancamento <= 0) {
                throw new IllegalArgumentException("Ano de lançamento deve ser um valor positivo");
            }

            int anoAtual = Year.now().getValue();
            if (anoLancamento > anoAtual) {
                throw new IllegalArgumentException("Ano de lançamento não pode ser no futuro");
            }

            this.anoLancamento = anoLancamento;
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao definir ano de lançamento: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        try {
            return "Crypto{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", simbolo='" + simbolo + '\'' +
                    ", anoLancamento=" + anoLancamento +
                    '}';
        } catch (Exception e) {
            System.err.println("Erro ao gerar representação da criptomoeda: " + e.getMessage());
            return "Erro ao gerar representação da criptomoeda";
        }
    }
}
