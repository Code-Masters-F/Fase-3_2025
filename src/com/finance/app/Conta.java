package com.finance.app;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private static int proximoId = 1;
    private int id;
    private String numeroConta;
    private float saldo;
    private String agencia;
    private List<TransacaoConta> transacoesContas;

    public Conta(String numeroConta, String agencia) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = 0.0f;
        this.transacoesContas = new ArrayList<>();
        this.id = proximoId++;
    }

    public boolean depositar(float valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean transferirParaOutraConta(float valor, String numeroContaOrigem,
                                            String numeroContaDestino, String agenciaOrigem, String agenciaDestino) {
        TransacaoConta transacao = new TransacaoConta(valor, numeroContaOrigem, numeroContaDestino, agenciaOrigem, agenciaDestino);
        subtrairSaldo(valor);
        adicionarTransacaoConta(transacao);
        return true;
    }

    public boolean receberTransacaoConta(float valor, String numeroContaOrigem,
                                         String numeroContaDestino, String agenciaOrigem, String agenciaDestino) {
        TransacaoConta transacao = new TransacaoConta(valor, numeroContaOrigem, numeroContaDestino, agenciaOrigem, agenciaDestino);
        adicionarSaldo(valor);
        adicionarTransacaoConta(transacao);
        return true;
    }

    protected boolean adicionarSaldo(float valor) {
        return depositar(valor);
    }

    protected boolean subtrairSaldo(float valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void adicionarTransacaoConta(TransacaoConta transacao) {
        this.transacoesContas.add(transacao);
    }

    public List<TransacaoConta> getTransacoesContas() {
        return transacoesContas;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public float getSaldo() {
        return saldo;
    }

    public int getId() {
        return id;
    }
}


