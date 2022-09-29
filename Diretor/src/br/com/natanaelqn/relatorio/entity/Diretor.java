package br.com.natanaelqn.relatorio.entity;

public class Diretor extends Funcionario {

    public Diretor(int id, String matricula, String nome) {
        super(id, matricula, nome);
    }

    public Diretor(int id, String matricula, String nome, String nomeDeUsuario, String senhaDeUsuario) {
        super(id, matricula, nome, nomeDeUsuario, senhaDeUsuario);
    }
}
