package br.com.natanaelqn.relatorio.entity;

public class Carro {
    private int id;
    private String placa;
    private String marca;
    private String modelo;
    private int km_atual;
    private boolean avariado;
    private String avaria;

    public Carro(String placa, String marca, String modelo, int km_atual, boolean avariado, String avaria) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.km_atual = km_atual;
        this.avariado = avariado;
        this.avaria = avaria;
    }

    public Carro(int id, String placa, String marca, String modelo, int km_atual, boolean avariado, String avaria) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.km_atual = km_atual;
        this.avariado = avariado;
        this.avaria = avaria;
    }

    public int getId() {
        return id;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKm_atual() {
        return km_atual;
    }

    public void setKm_atual(int km_atual) {
        this.km_atual = km_atual;
    }

    public boolean isAvariado() {
        return avariado;
    }

    public void setAvariado(boolean avariado) {
        this.avariado = avariado;
    }

    public String getAvaria() {
        return avaria;
    }

    public void setAvaria(String avaria) {
        this.avaria = avaria;
    }
    
    
}
