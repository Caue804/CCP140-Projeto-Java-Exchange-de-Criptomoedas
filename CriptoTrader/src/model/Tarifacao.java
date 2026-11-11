package model;

public interface Tarifacao {
    //Só declarando os métodos, sem implementação, dps tem override
    double calcularTaxaCompra(double valor); 
    double calcularTaxaVenda(double valor); 

}
