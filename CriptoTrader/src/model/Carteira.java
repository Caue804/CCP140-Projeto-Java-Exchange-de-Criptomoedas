package model;

public class Carteira {
    private double saldoReais;
    private double saldoBitcoin;
    private double saldoEthereum;
    private double saldoRipple;

    // ================== Construtores ==================

    // Construtor padrão
    public Carteira() {
        this.saldoReais = 0.0;
        this.saldoBitcoin = 0.0;
        this.saldoEthereum = 0.0;
        this.saldoRipple = 0.0;
    }

    // Construtor completo
    public Carteira(double saldoReais, double saldoBitcoin, double saldoEthereum, double saldoRipple) {
        this.saldoReais = saldoReais;
        this.saldoBitcoin = saldoBitcoin;
        this.saldoEthereum = saldoEthereum;
        this.saldoRipple = saldoRipple;
    }

    // ================== Getters e Setters ==================

    public double getSaldoReais() {
        return saldoReais;
    }

    public void setSaldoReais(double saldoReais) {
        this.saldoReais = saldoReais;
    }

    public double getSaldoBitcoin() {
        return saldoBitcoin;
    }

    public void setSaldoBitcoin(double saldoBitcoin) {
        this.saldoBitcoin = saldoBitcoin;
    }

    public double getSaldoEthereum() {
        return saldoEthereum;
    }

    public void setSaldoEthereum(double saldoEthereum) {
        this.saldoEthereum = saldoEthereum;
    }

    public double getSaldoRipple() {
        return saldoRipple;
    }

    public void setSaldoRipple(double saldoRipple) {
        this.saldoRipple = saldoRipple;
    }

}