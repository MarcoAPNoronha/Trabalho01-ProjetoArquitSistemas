package org.example;

import java.util.Scanner;

public class Menu {

    public static Empresa empresa;

    private static Empresa criarEmpresa(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da empresa:");
        String nomeEmpresa = scanner.nextLine();

        Menu.empresa = new Empresa(nomeEmpresa);

        return empresa;
    }

    public static void exibirMenuInicial() {

        if (Menu.empresa == null) {
            Empresa empresa = criarEmpresa();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu: \n" +
                "1. Adicionar veículos. \n" +
                "2. Exibir detalhes dos veículos. \n" +
                "3. Adicionar funcionários. \n" +
                "4. Atribuir responsabilidade. \n" +
                "5. Adicionar produto. \n" +
                "6. Remover produto. \n" +
                "7. Exibir detalhes dos produtos. \n" +
                "8. Adicionar cliente. \n" +
                "9. Listar clientes. \n" +
                "10. Adicionar pedido. \n" +
                "11. Listar pedidos. \n" +
                "12. Sair.");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        switch (opcao) {
            case 1 -> {
                System.out.println("------------------------------ \nInforme a placa do veículo:");
                String placa = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Informe o tipo do veículo:");
                int tipo = scanner.nextInt();
                empresa.adicionarVeiculo(tipo, placa);
                System.out.println("Veículo adicionado com sucesso.");
                exibirMenuInicial();
            }
            case 2 -> {
                System.out.println("------------------------------");
                empresa.exibirDetalhesVeiculos();
                exibirMenuInicial();
            }
            case 3 -> {
                System.out.println("------------------------------ \nInforme o nome do funcionário:");
                String nomeFuncionario = scanner.nextLine();
                System.out.println("Informe o cargo do funcionário:");
                String cargoFuncionario = scanner.nextLine();
                empresa.adicionarFuncionario(nomeFuncionario, cargoFuncionario);
                System.out.println("Funcionário adicionado com sucesso.");
                exibirMenuInicial();
            }
            case 4 -> {
                System.out.println("------------------------------ \nA atividade é pra qual funcionário (cargo):");
                String cargo = scanner.nextLine();
                empresa.atribuirResposabilidade(cargo);
                exibirMenuInicial();
            }
            case 5 -> {
                System.out.println("------------------------------ \nID do produto");
                Long idProduto = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Tipo do produto:");
                String tipoProduto = scanner.nextLine();
                System.out.println("Nome do produto:");
                String nomeProduto = scanner.nextLine();
                System.out.println("Preço do produto:");
                double precoProduto = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Peso do produto (kg):");
                double pesoProduto = scanner.nextDouble();
                scanner.nextLine();
                empresa.adicionarProduto(idProduto, tipoProduto, nomeProduto, precoProduto, pesoProduto);
                exibirMenuInicial();
            }
            case 6 -> {
                System.out.println("------------------------------ \nQual produto será removido:");
                String nomeProduto = scanner.nextLine();
                empresa.removerProduto(nomeProduto);
                exibirMenuInicial();
            }
            case 7 -> {
                empresa.exibirDetalhesProdutos();
                exibirMenuInicial();
            }
            case 8 -> { // Adicionar cliente
            System.out.println("------------------------------ \nID do cliente:");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nome do cliente:");
            String nome = scanner.nextLine();
            System.out.println("Email do cliente:");
            String email = scanner.nextLine();
            System.out.println("Telefone do cliente:");
            String telefone = scanner.nextLine();
            System.out.println("Endereço do cliente:");
            String endereco = scanner.nextLine();

            Cliente cliente = FactoryCliente.criarCliente(id, nome, email, telefone, endereco);
            Cliente.adicionarCliente(cliente);
            System.out.println("Cliente adicionado com sucesso!");
            exibirMenuInicial();
}
            case 9 -> { // Listar clientes
                System.out.println("------------------------------ \n=== Lista de Clientes ===");
                for (Cliente c : Cliente.listarClientes()) {
                    System.out.println(c);
                }
                exibirMenuInicial();
            }
            case 10 -> { // Adicionar pedido
                System.out.println("------------------------------ \nID do pedido:");
                int idPedido = scanner.nextInt();
                scanner.nextLine();
                System.out.println("ID do cliente:");
                int idCliente = scanner.nextInt();
                scanner.nextLine();

                Cliente cliente = Cliente.buscarClientePorId(idCliente);
                if (cliente == null) {
                    System.out.println("Cliente não encontrado!");
                    exibirMenuInicial();
                }

                Pedido pedido = new Pedido(idPedido, cliente);

                System.out.println("Quantos produtos deseja adicionar?");
                int qtd = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < qtd; i++) {
                    System.out.println("ID do produto:");
                    int idProd = scanner.nextInt();
                    scanner.nextLine();

                    // Procurar produto na lista de produtos da empresa
                    Produto prod = empresa.getProdutos().stream()
                            .filter(p -> p.getId().equals((long) idProd))
                            .findFirst()
                            .orElse(null);

                    if (prod != null) {
                        pedido.adicionarProduto(prod);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                }

                Pedido.adicionarPedido(pedido);
                System.out.println("Pedido adicionado!");
                exibirMenuInicial();
            }
            case 11 -> { // Listar pedidos
                System.out.println("------------------------------ \n=== Lista de Pedidos ===");
                for (Pedido p : Pedido.listarPedidos()) {
                    System.out.println(p);
                }
                exibirMenuInicial();
            }
            case 12 -> {
                scanner.close();
                System.out.println("Saindo...");
            }
            default -> {
                System.out.println("------------------------------ \nOpção inválida. Tente novamente.");
                exibirMenuInicial();
            }
        }
    }
}
