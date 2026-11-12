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

    // ================== Métodos ==================

    // Retorna false se o valor for inválido (<= 0)
    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldoReais = arredondar(saldoReais + valor);
        return true;
    }

    // Retorna false se o valor for inválido ou maior que o saldo (saldo nunca fica negativo)
    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldoReais) {
            return false;
        }
        saldoReais = arredondar(saldoReais - valor);
        return true;
    }


    // simbolos: "BTC", "ETH" ou "XRP"
    // Debita o custo total (já com a taxa) em reais e credita a quantidade da moeda
    public boolean comprar(String simbolo, double quantidade, double custoTotal) {
        if (quantidade <= 0 || custoTotal > saldoReais) {
            return false;
        }
        saldoReais = arredondar(saldoReais - custoTotal);
        setSaldoCripto(simbolo, getSaldoCripto(simbolo) + quantidade);
        return true;
    }

    // Debita a quantidade da moeda e credita o valor recebido (já descontada a taxa) em reais
    public boolean vender(String simbolo, double quantidade, double valorRecebido) {
        if (quantidade <= 0 || quantidade > getSaldoCripto(simbolo)) {
            return false;
        }
        setSaldoCripto(simbolo, getSaldoCripto(simbolo) - quantidade);
        saldoReais = arredondar(saldoReais + valorRecebido);
        return true;
    }

    // Mantém 2 casas decimais em reais (evita sobras como 0.30000000000000004)
    private static double arredondar(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

    private double getSaldoCripto(String simbolo) {
        switch (simbolo) {
            case "BTC": return saldoBitcoin;
            case "ETH": return saldoEthereum;
            case "XRP": return saldoRipple;
        }
        return 0.0;
    }

    private void setSaldoCripto(String simbolo, double valor) {
        valor = Math.round(valor * 1e8) / 1e8;   // 8 casas decimais, como as criptomoedas
        switch (simbolo) {
            case "BTC": saldoBitcoin = valor; break;
            case "ETH": saldoEthereum = valor; break;
            case "XRP": saldoRipple = valor; break;
            default:   break;
        }
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