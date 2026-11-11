package model;

public class Ethereum extends Moedas implements Tarifacao {

    public Ethereum(double cotacaoAtual) {
        super("ETH", cotacaoAtual); // Cotação atual do Ethereum quando criar o objeto
    }

    @Override
    public double calcularTaxaCompra(double valor) {
        return valor * 0.01; // Taxa de compra de 1%
    }

    @Override
    public double calcularTaxaVenda(double valor) {
        return valor * 0.02; // Taxa de venda de 2%
    }

}