package org.example;

public class Van extends Veiculo {

    private int capacidadePassaeiros;
    private String capacidadeCarga;
    private String placa;
    private String tipo;


    //---------------------------------------------------

    public Van(int capacidadePassaeiros, String capacidadeCarga, String placa, String tipo) {
        this.capacidadePassaeiros = capacidadePassaeiros;
        this.capacidadeCarga = capacidadeCarga;
        this.placa = placa;
        this.tipo = tipo;
    }


    public Van() {
    }

    //---------------------------------------------------


    public int getCapacidadePassaeiros() {
        return capacidadePassaeiros;
    }

    public void setCapacidadePassaeiros(int capacidadePassaeiros) {
        this.capacidadePassaeiros = capacidadePassaeiros;
    }

    public String getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(String capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Detalhes da Van:");
        System.out.println("Tipo: " + tipo);
        System.out.println("Placa: " + placa);
        System.out.println("Capacidade de Passageiros: " + capacidadePassaeiros);
        System.out.println("Capacidade de Carga: " + capacidadeCarga);
    }
}
