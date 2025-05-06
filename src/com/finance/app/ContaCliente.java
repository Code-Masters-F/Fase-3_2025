package com.finance.app;

import java.util.ArrayList;
import java.util.List;

public class ContaCliente {
    private static int proximoId = 1;
    private int id;
    private String numeroConta;
    private float saldo;
    private String agencia;
    private List<TransacaoCrypto> transacoesCryptos;
    private List<TransacaoConta> transacoesContas;
    private Cliente cliente;

    public ContaCliente(String numeroConta, String agencia, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = 0.0f;
        this.transacoesCryptos = new ArrayList<>();
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

    public boolean transferirContasCorretora(Conta destino, float valor) {
        if (valor > 0 && this.saldo >= valor) {
            destino.receberTransacaoConta(valor, this.numeroConta, destino.getNumeroConta(), this.agencia, destino.getAgencia());
            this.transferirParaOutraConta(valor, this.numeroConta, destino.getNumeroConta(), this.agencia, destino.getAgencia());
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

    private boolean adicionarSaldo(float valor) {
        return depositar(valor);
    }

    private boolean subtrairSaldo(float valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
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

    public List<TransacaoCrypto> getTransacoesCrypto() {
        return transacoesCryptos;
    }

    public List<TransacaoConta> getTransacoesContas() {
        return transacoesContas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void adicionarTransacaoCrypto(TransacaoCrypto transacao) {
        this.transacoesCryptos.add(transacao);
    }

    public void adicionarTransacaoConta(TransacaoConta transacao) {
        this.transacoesContas.add(transacao);
    }

    @Override
    public String toString() {
        return "ContaCliente {" +
                "id=" + id +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + (cliente != null ? cliente.getNome() : "N/A") +
                ", transacoesCryptos=" + transacoesCryptos.size() +
                ", transacoesContas=" + transacoesContas.size() +
                '}';
    }
}

