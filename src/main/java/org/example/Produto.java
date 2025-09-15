package org.example;

public abstract class Produto {
    private Long id;
    private String tipo;
    private String nome;
    private double precoBase;
    private Double pesoKg;

    protected Produto(Long id, String tipo, String nome, double precoBase, Double pesoKg) {
        this.id = id; 
        this.tipo = tipo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.pesoKg = pesoKg;
    }

    public String getNome() {
      return nome;
    }

    public Long getId() {
      return id;
    }

    public double getPrecoBase() {
      return precoBase;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public void setPrecoBase(double precoBase) {
      this.precoBase = precoBase;
    }

    public String getTipo() {
      return tipo;
    }

    public void setTipo(String tipo) {
      this.tipo = tipo;
    }

    public Double getPesoKg() {
      return pesoKg;
    }

    public void setPesoKg(Double pesoKg) {
      this.pesoKg = pesoKg;
    }

    public abstract double calcularPrecoFinal();

    public static Produto criarProduto(Long id, String tipo, String nome, double precoBase, Double pesoKg) {
      return switch (tipo.toLowerCase()) {
          case "fisico" -> new ProdutoFisico(id, tipo, nome, precoBase, pesoKg != null ? pesoKg : 1.0);
          case "digital" -> new ProdutoDigital(id, tipo, nome, precoBase, pesoKg);
          default -> throw new IllegalArgumentException("Tipo de produto inválido: " + tipo);
      };
    }

    public void aplicarPromocao(double percentualDesconto) {
      if (percentualDesconto <= 0 || percentualDesconto >= 1) {
        throw new IllegalArgumentException("Percentual de desconto deve estar entre 0 e 1");
      }
      this.precoBase = this.precoBase * (1 - percentualDesconto);
      System.out.println("Promoção aplicada em " + this.getNome() + " | novo preço base: " + this.precoBase);
    }
}
