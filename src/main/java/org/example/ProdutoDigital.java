package org.example;

public class ProdutoDigital extends Produto {
    public ProdutoDigital(Long id, String tipo, String nome, double precoBase, Double pesoKg) {
        super(id, tipo, nome, precoBase, pesoKg);
    }
    @Override public double calcularPrecoFinal() {
        double imposto = getPrecoBase() * 0.06;
        return getPrecoBase() + imposto;
    }
}