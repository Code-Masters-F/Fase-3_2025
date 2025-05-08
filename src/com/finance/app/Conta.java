package com.finance.app;

import java.time.LocalDate;

public abstract class Conta {
    private static int proximoId = 1;
    private final int id;
    private final String numeroConta;
    private final String agencia;
    private final LocalDate dataAbertura;

    public Conta(String numeroConta, String agencia) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.dataAbertura = LocalDate.now();
        this.id = proximoId++;
    }


    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public int getId() {
        return id;
    }

    public abstract float getSaldo();

    public boolean depositar(float valor) {
        try {
            // Validação do valor de depósito
            if (valor <= 0) {
                throw new IllegalArgumentException("Valor de depósito deve ser maior que zero");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Erro no depósito: " + e.getMessage());
            // Dependendo da política da aplicação, podemos retornar false ou relançar
            return false;
        } catch (Exception e) {
            System.err.println("Erro inesperado ao processar depósito: " + e.getMessage());
            return false;
        }
    }
}

