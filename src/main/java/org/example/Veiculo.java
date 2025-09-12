package org.example;

public class Veiculo {

    private Veiculo veiculo = criarVeiculo(0, "");

    public Veiculo(){};


    public static Veiculo criarVeiculo(int tipoVeiculo, String placa) {
        return switch (tipoVeiculo) {
            case 1 -> new Moto(1, "Pequena", placa, "Moto");
            case 2 -> new Carro(4, "Média", placa, "Carro");
            case 3 -> new Van(3, "Grande", placa, "Van");
            default -> {
                yield null;
            }

        };
    }


    public void exibirDetalhes(){}


}
