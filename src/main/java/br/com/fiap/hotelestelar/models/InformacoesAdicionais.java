package br.com.fiap.hotelestelar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "informacoes_adicionais")
public class InformacoesAdicionais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacoes_adicionais")
    private Long idInformacoesAdicionais;

    @NotNull
    @Column(name = "aceita_pet")
    private boolean aceitaPet;

    @NotNull
    @Column(name = "possui_wifi")
    private boolean possuiWifi;

    @NotNull
    @Column(name = "possui_escritorio")
    private boolean possuiEscritorio;

    @NotNull
    @Column(name = "possui_ar_condicionado")
    private boolean possuiArCondicionado;

    @NotNull
    @Column(name = "eh_beira_mar")
    private boolean ehBeiraMar;

    @NotNull
    @Column(name = "possui_maquina_de_lavar")
    private boolean possuiMaquinaDeLavar;

    @NotNull
    @Column(name = "possui_ferro_de_passar")
    private boolean possuiFerroDePassar;

    @NotNull
    @Column(name = "possui_tv")
    private boolean possuiTv;

    @NotNull
    @Column(name = "possui_secadora")
    private boolean possuiSecadora;

    @NotNull
    @Column(name = "possui_terraco")
    private boolean possuiTerraco;

    @NotNull
    @Column(name = "possui_berco")
    private boolean possuiBerco;

    @NotNull
    @Column(name = "possui_lareira")
    private boolean possuiLareira;

}