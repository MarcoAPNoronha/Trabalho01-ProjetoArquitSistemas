package org.example;

public class FactoryCliente {

    // Factory para criar clientes
    public static Cliente criarCliente(int id, String nome, String email, String telefone, String endereco) {
        return new Cliente(id, nome, email, telefone, endereco);
    }

}

