package model;

import java.time.LocalDateTime; //para conseguir armazenar o tempo

public class Operacao {
    private LocalDateTime dataHora;
    private char tipo;          // '+' entrada, '-' saída
    private String moeda;        // "REAL", "BTC", "ETH" ou "XRP"
    private double quantidade;   // quantidade movimentada
    private double cotacao;      // 0.0 em depósito/saque
    private double taxa;         // 0.0 em depósito/saque
    private Carteira carteira;   // saldos DEPOIS da operação

    public Operacao(LocalDateTime dataHora, 
                    char tipo, 
                    String moeda, 
                    double quantidade,
                    double cotacao, 
                    double taxa, 
                    Carteira carteira) {
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.moeda = moeda;
        this.quantidade = quantidade;
        this.cotacao = cotacao;
        this.taxa = taxa;
        this.carteira = carteira;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public char getTipo() {
        return tipo;
    }

    public String getMoeda() {
        return moeda;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getCotacao() {
        return cotacao;
    }

    public double getTaxa() {
        return taxa;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    
}
