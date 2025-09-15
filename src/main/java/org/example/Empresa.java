package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nome;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Funcionario> funcionarios;
    private List<Produto> produtos; 

    public Empresa(String nome) {
        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Produto> getProdutos() {
      return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
      this.produtos = produtos;
    }

    public void adicionarVeiculo(int tipo, String placa) {
        Veiculo veiculo = Veiculo.criarVeiculo(tipo, placa);
        this.veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
    }

    public void adicionarFuncionario(String nome, String cargo) {
        Funcionario funcionario = Funcionario.criarFuncionario(nome, cargo);
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        this.funcionarios.remove(funcionario);
    }

    public void exibirDetalhesVeiculos() {
        System.out.println("Veículos da Empresa " + this.nome + ":");
        for (Veiculo veiculo : veiculos) {
            veiculo.exibirDetalhes();
            System.out.println("-----------------------");
        }
    }


    public void exibirDetalhesFuncionarios() {
        System.out.println("Funcionários da Empresa " + this.nome + ":");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("-----------------------");
        }
    }


    public void atribuirResposabilidade(String cargo){
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getCargo().equalsIgnoreCase(cargo)) {
                funcionario.atribuirResponsabilidade();
                return;
            }
        }

        System.out.println("Funcionário não encontrado.");
    }

    public void adicionarProduto(Long id, String tipo, String nome, double precoBase, Double pesoKg) {
        Produto produto = Produto.criarProduto(id, tipo, nome, precoBase, pesoKg);
        this.produtos.add(produto);
    }

public void removerProduto(String nome) {
    for (Produto p : new ArrayList<>(produtos)) { 
        if (p.getNome().equalsIgnoreCase(nome)) {
            produtos.remove(p);
            System.out.println("Produto removido: " + nome);
            return;
        }
    }
    System.out.println("Produto não encontrado: " + nome);
}


    public void exibirDetalhesProdutos() {
        System.out.println("Produtos da Empresa " + this.nome + ":");
        for (Produto p : produtos) {
            System.out.println(
                p.getClass().getSimpleName() + " - " + p.getNome() + " - " + p.getId()
                + " | preço base: " + p.getPrecoBase()
                + " | preço final: " + p.calcularPrecoFinal()
            );
            System.out.println("-----------------------");
        }
    }
public void aplicarPromocaoEmProduto(Long idProduto, double percentualDesconto) {
    for (Produto p : produtos) {
        if (p.getId().equals(idProduto)) {
            p.aplicarPromocao(percentualDesconto);
            return;
        }
    }
    System.out.println("Produto não encontrado para promoção.");
}
}
