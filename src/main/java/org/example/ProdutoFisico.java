package org.example;

public class ProdutoFisico extends Produto {
    private double pesoKg;

    public ProdutoFisico(Long id, String tipo, String nome, double precoBase, Double pesoKg) {
        super(id, tipo, nome, precoBase, pesoKg); this.pesoKg = pesoKg;
    }

    @Override
    public double calcularPrecoFinal() {
        double imposto = getPrecoBase() * 0.12;
        double frete   = pesoKg * 3.5;
        return getPrecoBase() + imposto + frete;
    }
}
