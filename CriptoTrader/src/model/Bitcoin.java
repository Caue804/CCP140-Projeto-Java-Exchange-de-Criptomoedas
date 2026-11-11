package model;

public class Bitcoin extends Moedas implements Tarifacao {

    public Bitcoin(double cotacaoAtual) {
        super("BTC", cotacaoAtual); // Cotação atual do Bitcoin quando criar o objeto
    }

    @Override
    public double calcularTaxaCompra(double valor) {
        return valor * 0.02; // Taxa de compra de 2%
    }

    @Override
    public double calcularTaxaVenda(double valor) {
        return valor * 0.03; // Taxa de venda de 3%
    }

}