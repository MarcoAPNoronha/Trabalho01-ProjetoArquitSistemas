package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int idPedido;
    private Cliente cliente;
    private List<Produto> produtos;
    private String status; // ex: "Pendente", "Em entrega", "Concluído"

    // Lista de pedidos
    private static List<Pedido> pedidos = new ArrayList<>();

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = "Pendente";
    }

    // CREATE
    public static void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // READ
    public static Pedido buscarPedidoPorId(int idPedido) {
        return pedidos.stream()
                .filter(p -> p.idPedido == idPedido)
                .findFirst()
                .orElse(null);
    }

    public static List<Pedido> listarPedidos() {
        return pedidos;
    }

    // UPDATE
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void atualizarStatus(String status) {
        this.status = status;
    }

    // DELETE
    public static void removerPedido(int idPedido) {
        pedidos.removeIf(p -> p.idPedido == idPedido);
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente.getNome() +
               ", produtos=" + produtos + ", status=" + status + "]";
    }
}

