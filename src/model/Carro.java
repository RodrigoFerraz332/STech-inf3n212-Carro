/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 182120050
 */
public class Carro {

    private String marca;
    private String modelo;
    private int anoFab;
    private String anoMod;
    private String cor;
    private String tpCambio;
    private String combustivel;
    private Pessoa proprietario;//agregação da classe model pessoa como carro

    public Carro(String marca, String modelo, int anoFab, String anoMod, String cor, String tpCmabio, String combustivel, Pessoa proprietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.anoMod = anoMod;
        this.cor = cor;
        this.tpCambio = tpCmabio;
        this.combustivel = combustivel;
        this.proprietario = proprietario;

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

    public int getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    public String getAnoMod() {
        return anoMod;
    }

    public void setAnoMod(String anoMod) {
        this.anoMod = anoMod;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTpCambio() {
        return tpCambio;
    }

    public void setTpCambio(String tpCambio) {
        this.tpCambio = tpCambio;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public Carro() {
    }

    @Override
    public String toString() {
        return "\n---" + "\nmarca:t" + marca + "\nmodelo:t" + modelo + "\nanoFab:t" + anoFab + "\nanoMod:t" + anoMod + "\ncor:t" + cor + "\ntpCambio:t" + tpCambio + "\ncombustivel:t" + combustivel + "\nproprietario:t" + proprietario.getNome();
    }

}//fim da classe Carro
