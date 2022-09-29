package br.com.natanaelqn.relatorio.entity;

public abstract class Funcionario {
    private int id ;
    private String matricula;
    private String nome;
    private String nomeDeUsuario;
    private String senhaDeUsuario;

    public Funcionario(int id, String matricula, String nome) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
    }

    public Funcionario(String matricula, String nome, String nomeDeUsuario, String senhaDeUsuario) {
        this.matricula = matricula;
        this.nome = nome;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senhaDeUsuario = senhaDeUsuario;
    }

    public Funcionario(int id, String matricula, String nome, String nomeDeUsuario, String senhaDeUsuario) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senhaDeUsuario = senhaDeUsuario;
    }

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenhaDeUsuario() {
        return senhaDeUsuario;
    }

    public void setSenhaDeUsuario(String senhaDeUsuario) {
        this.senhaDeUsuario = senhaDeUsuario;
    }
}
