package com.finance.app;

import java.time.LocalDateTime;

public class TransacaoConta {
    private static int proximoId = 1;
    private int id;
    private float valor;
    private LocalDateTime data;
    private String numeroContaOrigem;
    private String numeroContaDestino;
    private String agenciaOrigem;
    private String agenciaDestino;
    
    public TransacaoConta(float valor, String numeroContaOrigem,
                          String numeroContaDestino, String agenciaOrigem, String agenciaDestino) {
        this.valor = valor;
        this.data = LocalDateTime.now();
        this.numeroContaOrigem = numeroContaOrigem;
        this.numeroContaDestino = numeroContaDestino;
        this.agenciaOrigem = agenciaOrigem;
        this.agenciaDestino = agenciaDestino;
        this.id = proximoId++;
    }
    
    public int getId() {
        return id;
    }
    
    public float getValor() {
        return valor;
    }
    
    public LocalDateTime getData() {
        return data;
    }
    
    public String getNumeroContaOrigem() {
        return numeroContaOrigem;
    }
    
    public String getNumeroContaDestino() {
        return numeroContaDestino;
    }
    
    public String getAgenciaOrigem() {
        return agenciaOrigem;
    }
    
    public String getAgenciaDestino() {
        return agenciaDestino;
    }
    
    @Override
    public String toString() {
        return "TransacaoConta{" +
                "id=" + id +
                ", valor=" + valor +
                ", data=" + data +
                ", numeroContaOrigem='" + numeroContaOrigem + '\'' +
                ", numeroContaDestino='" + numeroContaDestino + '\'' +
                ", agenciaOrigem='" + agenciaOrigem + '\'' +
                ", agenciaDestino='" + agenciaDestino + '\'' +
                '}';
    }
}
