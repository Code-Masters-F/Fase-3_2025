package com.finance.app;

import java.time.LocalDateTime;


public class TransacaoCrypto {
    private static int proximoId = 1;
    private int id;
    private String tipoOperacao; // Tipo da operação (ex: "compra", "venda")
    private float valorTotal;
    private float quantidadeCrypto;
    private LocalDateTime dataHora;
    private float valorUnitarioCrypto;
    private Conta contaCliente;
    private boolean status;
    private Crypto crypto;

    /**
     * Construtor da transação de criptomoeda.
     * Calcula automaticamente o valor total com base na quantidade e no valor unitário.
     *
     * @param contaCliente Conta vinculada à transação
     * @param quantidadeCrypto Quantidade de criptomoeda
     * @param valorUnitarioCrypto Valor unitário da criptomoeda
     * @param crypto Objeto da criptomoeda
     * @param tipoOperacao Tipo da operação ("compra", "venda")
     */
    public TransacaoCrypto(ContaCliente contaCliente, float quantidadeCrypto, float valorUnitarioCrypto, Crypto crypto,
                           String tipoOperacao) {
        // Validações básicas
        if (quantidadeCrypto <= 0 || valorUnitarioCrypto <= 0) {
            throw new IllegalArgumentException("Quantidade e valor unitário devem ser positivos.");
        }
        if (contaCliente == null || crypto == null || tipoOperacao == null || tipoOperacao.isEmpty()) {
            throw new IllegalArgumentException("Dados obrigatórios não podem ser nulos ou vazios.");
        }

        this.contaCliente = contaCliente;
        this.quantidadeCrypto = quantidadeCrypto;
        this.valorUnitarioCrypto = valorUnitarioCrypto;
        this.crypto = crypto;
        this.tipoOperacao = tipoOperacao;
        this.dataHora = LocalDateTime.now(); // Define a data atual
        this.valorTotal = quantidadeCrypto * valorUnitarioCrypto; // Calcula o valor total comprado/vendido
        this.status = true;
        this.id = proximoId++;
    }

    // Getters

    public int getId() {
        return id;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public float getQuantidadeCrypto() {
        return quantidadeCrypto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public float getValorUnitarioCrypto() {
        return valorUnitarioCrypto;
    }

    public Conta getContaCliente() {
        return contaCliente;
    }

    public boolean getStatus() {
        return status;
    }

    public Crypto getCrypto() {
        return crypto;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    // Setters (métodos para alterar valores)


    /**
     * Altera o status da transação (ativa ou cancelada).
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransacaoCrypto {" +
                "id=" + id +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", valorTotal=" + valorTotal +
                ", quantidadeCrypto=" + quantidadeCrypto +
                ", valorUnitarioCrypto=" + valorUnitarioCrypto +
                ", data=" + dataHora +
                ", conta=" + contaCliente +
                ", crypto=" + crypto +
                ", status=" + status +
                '}';
    }
}

