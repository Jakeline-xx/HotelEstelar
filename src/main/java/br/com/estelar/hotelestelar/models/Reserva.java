package br.com.estelar.hotelestelar.models;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "unidade")
    private String unidade;

    @Column(name = "data_reserva")
    private LocalDate dataReserva;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "acomodacao")
    private String acomodacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_informacoes_adicionais")
    private InformacoesAdicionais informacoesAdicionais;

    @Column(name = "valor_total")
    private double valorTotal;

    public Reserva(Long idReserva, String unidade, LocalDate dataReserva, LocalDate dataInicio, LocalDate dataFim, String acomodacao, InformacoesAdicionais informacoesAdicionais, double valorTotal) {
        this.idReserva = idReserva;
        this.unidade = unidade;
        this.dataReserva = dataReserva;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.acomodacao = acomodacao;
        this.informacoesAdicionais = informacoesAdicionais;
        this.valorTotal = valorTotal;   
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

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
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
