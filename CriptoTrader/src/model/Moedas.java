package model;
import java.util.Random;

public abstract class Moedas {

    private String nome;
    private double cotacao;

    public Moedas(String nome, double cotacao) {
        this.nome = nome;
        this.cotacao = cotacao;
    }

    // ================== Cotação "Aleatória" ==================

    public void atualizarCotacao() {
        Random r = new Random();
        double variacao = (r.nextDouble() * 0.1) - 0.05; // Variação entre -5% e +5%
        //nextDouble gera entre 0.0 e 1.0 -> Amplitude 0.1 -> intervalo de 10% -> com -5% (fica de -5% a +5%)
        this.cotacao = this.cotacao * (1 + variacao);
    }

    // ================== Getters e Setters ==================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
}