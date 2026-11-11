package model;

public class Ripple extends Moedas implements Tarifacao {

    public Ripple(double cotacaoAtual) {
        super("XRP", cotacaoAtual); // Cotação atual do Ripple quando criar o objeto
    }

    @Override
    public double calcularTaxaCompra(double valor) {
        return valor * 0.01; // Taxa de compra de 1%
    }

    @Override
    public double calcularTaxaVenda(double valor) {
        return valor * 0.01; // Taxa de venda de 1%
    }

}