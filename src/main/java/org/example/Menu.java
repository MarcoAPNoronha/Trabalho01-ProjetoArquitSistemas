package org.example;

import java.util.Scanner;

public class Menu {



    public static void exibirMenuInicial() {
        Scanner scanner = new Scanner(  System.in);

        System.out.println("Digite o nome da empresa:");
        String nomeEmpresa = scanner.nextLine();

        Empresa empresa = new Empresa(nomeEmpresa);


        System.out.println("Menu: \n" +
                "1. Adicionar veículos. \n" +
                "2. Adicionar funcionários. \n" +
                "3. Atribuir responsabilidade. \n" +
                "4. Adicionar produto. \n" +
                "5. Remover produto. \n" +
                "6. Exibir detalhes dos produtos.");

        int opcao = scanner.nextInt();


        switch (opcao) {
            case 1 -> {
                System.out.println("Informe a placa do veículo:");
                String placa = scanner.nextLine();
                System.out.println("Informe o tipo do veículo:");
                int tipo = scanner.nextInt();
                empresa.adicionarVeiculo(tipo, placa);
                System.out.println("Veículo adicionado com sucesso.");
            }
            case 2 -> {
                System.out.println("Informe o nome do funcionário:");
                String nomeFuncionario = scanner.nextLine();
                System.out.println("Informe o cargo do funcionário:");
                String cargoFuncionario = scanner.nextLine();
                empresa.adicionarFuncionario(nomeFuncionario, cargoFuncionario);
                System.out.println("Funcionário adicionado com sucesso.");
            }
            case 3 -> {
                System.out.println("A atividade é pra qual funcionário (cargo):");
                String cargo = scanner.nextLine();
                empresa.atribuirResposabilidade(cargo);
            }
            case 4 -> {
                System.out.println("ID do produto");
                Long idProduto = scanner.nextLong();
                scanner.nextLine(); // Quebra de linha
                System.out.println("Tipo do produto:");
                String tipoProduto = scanner.nextLine();
                System.out.println("Nome do produto:");
                String nomeProduto = scanner.nextLine();
                System.out.println("Preço do produto:");
                double precoProduto = scanner.nextDouble();
                scanner.nextLine(); // Quebra de linha
                System.out.println("Peso do produto (kg):");
                double pesoProduto = scanner.nextDouble();
                scanner.nextLine(); // Quebra de linha
                empresa.adicionarProduto(idProduto, tipoProduto, nomeProduto, precoProduto, pesoProduto);
            }
            case 5 -> {
                System.out.println("Qual produto será removido:");
                String nomeProduto = scanner.nextLine();
                empresa.removerProduto(nomeProduto);
            }
            case 6 -> {
                empresa.exibirDetalhesProdutos();
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
