package model;

import java.time.LocalDateTime;

/** Uma linha do extrato: o que foi feito e como ficou a carteira depois. */
public class Operacao {
    private LocalDateTime dataHora;
    private char sinal;          // '+' entrada, '-' saída
    private String moeda;        // "REAL", "BTC", "ETH" ou "XRP"
    private double valor;        // quantidade movimentada
    private double cotacao;      // 0.0 em depósito/saque
    private double taxa;         // 0.0 em depósito/saque
    private Carteira carteira;   // saldos DEPOIS da operação

    public Operacao(LocalDateTime dataHora, char sinal, String moeda, double valor,
                    double cotacao, double taxa, Carteira carteira) {
        this.dataHora = dataHora;
        this.sinal = sinal;
        this.moeda = moeda;
        this.valor = valor;
        this.cotacao = cotacao;
        this.taxa = taxa;
        this.carteira = carteira;
    }

    public LocalDateTime getDataHora() { return dataHora; }
    public char getSinal() { return sinal; }
    public String getMoeda() { return moeda; }
    public double getValor() { return valor; }
    public double getCotacao() { return cotacao; }
    public double getTaxa() { return taxa; }
    public Carteira getCarteira() { return carteira; }
}
