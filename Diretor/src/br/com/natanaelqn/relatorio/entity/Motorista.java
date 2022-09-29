package br.com.natanaelqn.relatorio.entity;

public class Motorista  extends Funcionario {

    public Motorista(int id, String matricula, String nome) {
        super(id, matricula, nome);
    }

    public Motorista(String matricula, String nome, String nomeDeUsuario, String senhaDeUsuario) {
        super(matricula, nome, nomeDeUsuario, senhaDeUsuario);
    }
    
    public Motorista(int id, String matricula, String nome, String nomeDeUsuario, String senhaDeUsuario) {
        super(id, matricula, nome, nomeDeUsuario, senhaDeUsuario);
    }
}
