package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    // Lista que simula um banco de dados
    private static List<Cliente> clientes = new ArrayList<>();

    public Cliente(int id, String nome, String email, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // CREATE
    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // READ
    public static Cliente buscarClientePorId(int id) {
        return clientes.stream()
                .filter(c -> c.id == id)
                .findFirst()
                .orElse(null);
    }

    public static List<Cliente> listarClientes() {
        return clientes;
    }

    // UPDATE
    public static void atualizarCliente(int id, String nome, String email, String telefone, String endereco) {
        Cliente c = buscarClientePorId(id);
        if (c != null) {
            c.nome = nome;
            c.email = email;
            c.telefone = telefone;
            c.endereco = endereco;
        }
    }   

    // DELETE
    public static void removerCliente(int id) {
        clientes.removeIf(c -> c.id == id);
    }

    // Getters e toString
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email +
               ", telefone=" + telefone + ", endereco=" + endereco + "]";
    }
}