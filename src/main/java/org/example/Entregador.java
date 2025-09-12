package org.example;

public class Entregador extends Funcionario {


    public Entregador(String nome, String cargo) {
        super(nome, cargo);
    }


    @Override
    public void atribuirResponsabilidade() {
        System.out.println("Entregador: Realizar entregas de produtos aos clientes.");
    }
}
