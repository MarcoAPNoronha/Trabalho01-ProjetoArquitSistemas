package org.example;

import java.util.Scanner;

public class Menu {

    public static Empresa empresa;

    private static Empresa criarEmpresa(){
        Scanner scanner = new Scanner(  System.in);

        System.out.println("Digite o nome da empresa:");
        String nomeEmpresa = scanner.nextLine();

        Menu.empresa = new Empresa(nomeEmpresa);

        return empresa;
    }

    public static void exibirMenuInicial() {


        if (Menu.empresa == null) {
            Empresa empresa = criarEmpresa();
        }


        Scanner scanner = new Scanner(  System.in);

        System.out.println("Menu: \n" +
                "1. Adicionar veículos. \n" +
                "2. Exibir detalhes dos veículos. \n" +
                "3. Adicionar funcionários. \n" +
                "4. Atribuir responsabilidade. \n" +
                "5. Adicionar produto. \n" +
                "6. Remover produto. \n" +
                "7. Exibir detalhes dos produtos. \n" +
                "8. Sair.");

        int opcao = scanner.nextInt();


        switch (opcao) {
            case 1 -> {
                System.out.println("------------------------------ \n" +
                        "Informe a placa do veículo:");
                String placa = scanner.nextLine();
                scanner.nextLine(); // Quebra de linha
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
                System.out.println("------------------------------ \n" +
                        "Informe o nome do funcionário:");
                String placa = scanner.nextLine();
                String nomeFuncionario = scanner.nextLine();
                System.out.println("Informe o cargo do funcionário:");
                String cargoFuncionario = scanner.nextLine();
                empresa.adicionarFuncionario(nomeFuncionario, cargoFuncionario);
                System.out.println("Funcionário adicionado com sucesso.");
                exibirMenuInicial();
            }
            case 4 -> {
                System.out.println("------------------------------ \n" +
                        "A atividade é pra qual funcionário (cargo):");
                String cargo = scanner.nextLine();
                empresa.atribuirResposabilidade(cargo);
                exibirMenuInicial();
            }
            case 5 -> {
                System.out.println("------------------------------ \n" +
                        "ID do produto");
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
                exibirMenuInicial();
            }
            case 6 -> {
                System.out.println("------------------------------ \n" +
                        "Qual produto será removido:");
                String nomeProduto = scanner.nextLine();
                empresa.removerProduto(nomeProduto);
                exibirMenuInicial();
            }
            case 7 -> {
                empresa.exibirDetalhesProdutos();
                exibirMenuInicial();
            }
            case 8 -> {
                scanner.close();
            }
            default -> {
                System.out.println("------------------------------ \n" +
                        "Opção inválida. Tente novamente.");
                exibirMenuInicial();
            }
        }

    }
}
