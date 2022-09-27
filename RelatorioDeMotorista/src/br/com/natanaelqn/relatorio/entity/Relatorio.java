package br.com.natanaelqn.relatorio.entity;

import java.time.LocalDate;

public class Relatorio {

    private int id;
    private Motorista motorista;
    private Carro carro;
    private LocalDate dataDoServico;
    private LocalDate dataDoEnvio;
    private int km_percorrido;
    private boolean avariaNoServico;
    private String relato;

    public Relatorio(Motorista motorista, Carro carro, LocalDate dataDoServico, LocalDate dataDoEnvio, int km_percorrido, boolean avariaNoServico, String relato) {
        this.motorista = motorista;
        this.carro = carro;
        this.dataDoServico = dataDoServico;
        this.dataDoEnvio = dataDoEnvio;
        this.km_percorrido = km_percorrido;
        this.avariaNoServico = avariaNoServico;
        this.relato = relato;
    }

    public Relatorio(int id, Motorista motorista, Carro carro, LocalDate dataDoServico, LocalDate dataDoEnvio, int km_percorrido, boolean avariaNoServico, String relato) {
        this.id = id;
        this.motorista = motorista;
        this.carro = carro;
        this.dataDoServico = dataDoServico;
        this.dataDoEnvio = dataDoEnvio;
        this.km_percorrido = km_percorrido;
        this.avariaNoServico = avariaNoServico;
        this.relato = relato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getDataDoServico() {
        return dataDoServico;
    }

    public void setDataDoServico(LocalDate dataDoServico) {
        this.dataDoServico = dataDoServico;
    }

    public LocalDate getDataDoEnvio() {
        return dataDoEnvio;
    }

    public void setDataDoEnvio(LocalDate dataDoEnvio) {
        this.dataDoEnvio = dataDoEnvio;
    }

    public int getKm_percorrido() {
        return km_percorrido;
    }

    public void setKm_percorrido(int km_percorrido) {
        this.km_percorrido = km_percorrido;
    }

    public boolean isAvariaNoServico() {
        return avariaNoServico;
    }

    public void setAvariaNoServico(boolean avariaNoServico) {
        this.avariaNoServico = avariaNoServico;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    
    
}
