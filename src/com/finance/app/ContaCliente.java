package com.finance.app;

import java.util.ArrayList;
import java.util.List;

public class ContaCliente extends Conta {

    private Cliente cliente;
    private List<TransacaoCrypto> transacoesCryptos;

    public ContaCliente(String numeroConta, String agencia, Cliente cliente) {
        super(numeroConta, agencia);
        this.cliente = cliente;
        this.transacoesCryptos = new ArrayList<>();
    }

    public boolean transferirContasCorretora(Conta destino, float valor) {
        if (valor > 0 && getSaldo() >= valor) {
            destino.receberTransacaoConta(valor, getNumeroConta(), destino.getNumeroConta(), getAgencia(), destino.getAgencia());
            this.transferirParaOutraConta(valor, getNumeroConta(), destino.getNumeroConta(), getAgencia(), destino.getAgencia());
            return true;
        }
        return false;
    }

    public void adicionarTransacaoCrypto(TransacaoCrypto transacao) {
        this.transacoesCryptos.add(transacao);
    }

    public List<TransacaoCrypto> getTransacoesCrypto() {
        return transacoesCryptos;
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
                ", saldo=" + getSaldo() +
                ", cliente=" + (cliente != null ? cliente.getNome() : "N/A") +
                ", transacoesCryptos=" + transacoesCryptos.size() +
                ", transacoesContas=" + getTransacoesContas().size() +
                '}';
    }
}

