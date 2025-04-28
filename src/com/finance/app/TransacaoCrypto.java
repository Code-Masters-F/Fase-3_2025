package com.finance.app;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Classe que representa uma transação de criptomoeda.
 */
public class TransacaoCrypto {
    // Atributos privados
    private int id; // Identificador único da transação
    private String tipoOperacao; // Tipo da operação (ex: "compra", "venda")
    private float valorTotal; // Valor total da transação
    private float quantidadeCrypto; // Quantidade de criptomoeda transacionada
    private LocalDateTime data; // Data da transação
    private float valorUnitarioCrypto; // Valor de cada unidade da cripto
    private Conta conta; // Conta associada à transação
    private boolean status; // Status da transação (ativa ou cancelada)
    private Crypto crypto; // Criptomoeda utilizada na transação

    /**
     * Construtor da transação de criptomoeda.
     * Calcula automaticamente o valor total com base na quantidade e no valor unitário.
     *
     * @param conta Conta vinculada à transação
     * @param quantidadeCrypto Quantidade de criptomoeda
     * @param valorUnitarioCrypto Valor unitário da criptomoeda
     * @param crypto Objeto da criptomoeda
     * @param tipoOperacao Tipo da operação ("compra", "venda", etc)
     */
    public TransacaoCrypto(Conta conta, float quantidadeCrypto, float valorUnitarioCrypto, Crypto crypto, String tipoOperacao) {
        // Validações básicas
        if (quantidadeCrypto <= 0 || valorUnitarioCrypto <= 0) {
            throw new IllegalArgumentException("Quantidade e valor unitário devem ser positivos.");
        }
        if (conta == null || crypto == null || tipoOperacao == null || tipoOperacao.isEmpty()) {
            throw new IllegalArgumentException("Dados obrigatórios não podem ser nulos ou vazios.");
        }

        this.conta = conta;
        this.quantidadeCrypto = quantidadeCrypto;
        this.valorUnitarioCrypto = valorUnitarioCrypto;
        this.crypto = crypto;
        this.tipoOperacao = tipoOperacao;
        this.data = LocalDateTime.now(); // Define a data atual
        this.valorTotal = quantidadeCrypto * valorUnitarioCrypto; // Calcula o valor total
        this.status = true; // Define status inicial como ativo
    }

    // Getters (métodos de acesso)

    public int getId() {
        return id;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public float getQuantidadeCrypto() {
        return quantidadeCrypto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public float getValorUnitarioCrypto() {
        return valorUnitarioCrypto;
    }

    public Conta getConta() {
        return conta;
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
     * Define o ID da transação. Útil se o ID for gerado posteriormente (ex: por um banco de dados).
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Atualiza a quantidade de cripto e recalcula o valor total.
     */
    public void setQuantidadeCrypto(float quantidadeCrypto) {
        if (quantidadeCrypto > 0) {
            this.quantidadeCrypto = quantidadeCrypto;
            this.valorTotal = this.quantidadeCrypto * this.valorUnitarioCrypto;
        }
    }

    /**
     * Atualiza o valor unitário da cripto e recalcula o valor total.
     */
    public void setValorUnitarioCrypto(float valorUnitarioCrypto) {
        if (valorUnitarioCrypto > 0) {
            this.valorUnitarioCrypto = valorUnitarioCrypto;
            this.valorTotal = this.quantidadeCrypto * this.valorUnitarioCrypto;
        }
    }

    /**
     * Altera o status da transação (ativa ou cancelada).
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Altera o tipo da operação (ex: de "compra" para "venda").
     */
    public void setTipoOperacao(String tipoOperacao) {
        if (tipoOperacao != null && !tipoOperacao.isEmpty()) {
            this.tipoOperacao = tipoOperacao;
        }
    }

    /**
     * Retorna uma representação textual da transação para debug ou logs.
     */
    @Override
    public String toString() {
        return "TransacaoCrypto {" +
                "id=" + id +
                ", tipoOperacao='" + tipoOperacao + '\'' +
                ", valorTotal=" + valorTotal +
                ", quantidadeCrypto=" + quantidadeCrypto +
                ", valorUnitarioCrypto=" + valorUnitarioCrypto +
                ", data=" + data +
                ", conta=" + conta +
                ", crypto=" + crypto +
                ", status=" + status +
                '}';
    }
}

