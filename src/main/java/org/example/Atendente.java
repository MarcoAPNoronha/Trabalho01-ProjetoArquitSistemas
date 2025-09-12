package org.example;

public class Atendente extends Funcionario {
    public Atendente(String nome, String cargo) {
        super(nome, cargo);
    }

    @Override
    public void atribuirResponsabilidade() {
        System.out.println("Atendente: Auxiliar clientes no processo de compra e fornecer informações sobre produtos.");
    }

}
