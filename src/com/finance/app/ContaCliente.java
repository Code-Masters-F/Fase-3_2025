package com.finance.app;

import java.util.ArrayList;
import java.util.List;

public class ContaCliente extends Conta {

    private Cliente cliente;
    private float saldo;
    private List<TransacaoCrypto> transacoesCryptos;
    private List<TransacaoConta> transacoesContas;

    public ContaCliente(String numeroConta, String agencia, Cliente cliente) {
        super(numeroConta, agencia);
        this.cliente = cliente;
        this.saldo = 0.0f;
        this.transacoesCryptos = new ArrayList<>();
        this.transacoesContas = new ArrayList<>();
    }

    @Override
    public float getSaldo() {
        return saldo;
    }

    @Override
    public boolean depositar(float valor) {
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }
        return false;
    }

    public boolean transferirContasCorretora(ContaCliente destino, float valor) {
        if (valor > 0 && saldo >= valor) {
            destino.receberTransacaoConta(valor, getNumeroConta(), destino.getNumeroConta(), getAgencia(), destino.getAgencia());
            this.transferirParaOutraConta(valor, getNumeroConta(), destino.getNumeroConta(), getAgencia(), destino.getAgencia());
            return true;
        }
        return false;
    }

    public boolean transferirParaOutraConta(float valor, String contaOrigem, String contaDestino, String agenciaOrigem, String agenciaDestino) {
        TransacaoConta transacao = new TransacaoConta(valor, contaOrigem, contaDestino, agenciaOrigem, agenciaDestino);
        saldo -= valor;
        transacoesContas.add(transacao);
        return true;
    }

    public boolean receberTransacaoConta(float valor, String contaOrigem, String contaDestino, String agenciaOrigem, String agenciaDestino) {
        TransacaoConta transacao = new TransacaoConta(valor, contaOrigem, contaDestino, agenciaOrigem, agenciaDestino);
        saldo += valor;
        transacoesContas.add(transacao);
        return true;
    }

    public void adicionarTransacaoCrypto(TransacaoCrypto transacao) {
        this.transacoesCryptos.add(transacao);
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

    @Override
    public String toString() {
        return "ContaCliente {" +
                "id=" + getId() +
                ", numeroConta='" + getNumeroConta() + '\'' +
                ", agencia='" + getAgencia() + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + (cliente != null ? cliente.getNome() : "N/A") +
                ", transacoesCryptos=" + transacoesCryptos.size() +
                ", transacoesContas=" + transacoesContas.size() +
                '}';
    }
}


