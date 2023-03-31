package br.com.hotelestelar.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "informacoes_adicionais")
public class InformacoesAdicionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacoes_adicionais")
    private Long idInformacoesAdicionais;

    @Column(name = "aceita_pet")
    private boolean aceitaPet;

    @Column(name = "possui_wifi")
    private boolean possuiWifi;

    @Column(name = "possui_escritorio")
    private boolean possuiEscritorio;

    @Column(name = "possui_ar_condicionado")
    private boolean possuiArCondicionado;

    @Column(name = "eh_beira_mar")
    private boolean ehBeiraMar;

    @Column(name = "possui_maquina_de_lavar")
    private boolean possuiMaquinaDeLavar;

    @Column(name = "possui_ferro_de_passar")
    private boolean possuiFerroDePassar;

    @Column(name = "possui_tv")
    private boolean possuiTv;

    @Column(name = "possui_secadora")
    private boolean possuiSecadora;

    @Column(name = "possui_terraco")
    private boolean possuiTerraco;

    @Column(name = "possui_berco")
    private boolean possuiBerco;

    @Column(name = "possui_lareira")
    private boolean possuiLareira;


    public InformacoesAdicionais(boolean aceitaPet, boolean possuiWifi, boolean possuiEscritorio, boolean possuiArCondicionado, boolean ehBeiraMar, boolean possuiMaquinaDeLavar, boolean possuiFerroDePassar, boolean possuiTv, boolean possuiSecadora, boolean possuiTerraco, boolean possuiBerco, boolean possuiLareira) {
        this.aceitaPet = aceitaPet;
        this.possuiWifi = possuiWifi;
        this.possuiEscritorio = possuiEscritorio;
        this.possuiArCondicionado = possuiArCondicionado;
        this.ehBeiraMar = ehBeiraMar;
        this.possuiMaquinaDeLavar = possuiMaquinaDeLavar;
        this.possuiFerroDePassar = possuiFerroDePassar;
        this.possuiTv = possuiTv;
        this.possuiSecadora = possuiSecadora;
        this.possuiTerraco = possuiTerraco;
        this.possuiBerco = possuiBerco;
        this.possuiLareira = possuiLareira;
    }

    //Getters and Setters 

    public Long getIdInformacoesAdicionais() {
        return idInformacoesAdicionais;
    }

    public void setIdInformacoesAdicionais(Long idInformacoesAdicionais) {
        this.idInformacoesAdicionais = idInformacoesAdicionais;
    }

    public boolean isAceitaPet() {
        return aceitaPet;
    }

    public void setAceitaPet(boolean aceitaPet) {
        this.aceitaPet = aceitaPet;
    }

    public boolean isPossuiWifi() {
        return possuiWifi;
    }

    public void setPossuiWifi(boolean possuiWifi) {
        this.possuiWifi = possuiWifi;
    }

    public boolean isPossuiEscritorio() {
        return possuiEscritorio;
    }

    public void setPossuiEscritorio(boolean possuiEscritorio) {
        this.possuiEscritorio = possuiEscritorio;
    }

    public boolean isPossuiArCondicionado() {
        return possuiArCondicionado;
    }

    public void setPossuiArCondicionado(boolean possuiArCondicionado) {
        this.possuiArCondicionado = possuiArCondicionado;
    }

    public boolean isEhBeiraMar() {
        return ehBeiraMar;
    }

    public void setEhBeiraMar(boolean ehBeiraMar) {
        this.ehBeiraMar = ehBeiraMar;
    }

    public boolean isPossuiMaquinaDeLavar() {
        return possuiMaquinaDeLavar;
    }

    public void setPossuiMaquinaDeLavar(boolean possuiMaquinaDeLavar) {
        this.possuiMaquinaDeLavar = possuiMaquinaDeLavar;
    }

    public boolean isPossuiFerroDePassar() {
        return possuiFerroDePassar;
    }

    public void setPossuiFerroDePassar(boolean possuiFerroDePassar) {
        this.possuiFerroDePassar = possuiFerroDePassar;
    }

    public boolean isPossuiTv() {
        return possuiTv;
    }

    public void setPossuiTv(boolean possuiTv) {
        this.possuiTv = possuiTv;
    }

    public boolean isPossuiSecadora() {
        return possuiSecadora;
    }

    public void setPossuiSecadora(boolean possuiSecadora) {
        this.possuiSecadora = possuiSecadora;
    }

    public boolean isPossuiTerraco() {
        return possuiTerraco;
    }

    public void setPossuiTerraco(boolean possuiTerraco) {
        this.possuiTerraco = possuiTerraco;
    }

    public boolean isPossuiBerco() {
        return possuiBerco;
    }

    public void setPossuiBerco(boolean possuiBerco) {
        this.possuiBerco = possuiBerco;
    }

    public boolean isPossuiLareira() {
        return possuiLareira;
    }

    public void setPossuiLareira(boolean possuiLareira) {
        this.possuiLareira = possuiLareira;
    }
}