package org.example;

public class Funcionario {

    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }



    public static Funcionario criarFuncionario(String nome, String cargo) {
        return switch (cargo.toLowerCase()) {
            case "gerente" -> new Gerente(nome, cargo);
            case "atendente" -> new Atendente(nome, cargo);
            case "entregador" -> new Entregador(nome, cargo);
            default -> throw new IllegalArgumentException("Cargo inválido: " + cargo);
        };
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Cargo: " + this.cargo);
    }


    public void atribuirResponsabilidade(){};


}
