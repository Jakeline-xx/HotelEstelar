package br.com.estelar.hotelestelar.models;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "unidade")
    private String unidade;

    @Column(name = "numero_quarto")
    private String numeroQuarto;

    @Column(name = "data_reserva")
    private LocalDateTime dataReserva;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "acomodacao")
    private String acomodacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_informacoes_adicionais")
    private InformacoesAdicionais informacoesAdicionais;

    @Column(name = "valor_total")
    private double valorTotal;

    public Reserva(Long idReserva, String unidade, LocalDateTime dataReserva, LocalDateTime dataInicio, LocalDateTime dataFim, String acomodacao, String numeroQuarto, InformacoesAdicionais informacoesAdicionais, double valorTotal) {
        this.idReserva = idReserva;
        this.unidade = unidade;
        this.acomodacao = acomodacao;
        this.numeroQuarto = numeroQuarto;
        this.informacoesAdicionais = informacoesAdicionais;
        this.valorTotal = valorTotal;  
        this.dataReserva = dataReserva;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim; 
    }

    //Getters and Setters 
    
    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(String numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(String acomodacao) {
        this.acomodacao = acomodacao;
    }

    public InformacoesAdicionais getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(InformacoesAdicionais informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Optional<Reserva> stream() {
        return null;
    }

    public void add(Reserva reserva) {
    }
    
}
