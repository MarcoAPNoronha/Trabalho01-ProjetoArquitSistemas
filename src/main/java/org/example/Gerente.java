package org.example;

public class Gerente extends Funcionario {

    public Gerente(String nome, String cargo) {
        super(nome, cargo);
    }

    @Override
    public void atribuirResponsabilidade() {
        System.out.println("Gerente: Supervisionar operações e gerenciar a equipe.");
    }
}
