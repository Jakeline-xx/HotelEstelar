package br.com.hotelestelar.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @NotBlank
    @Column(name = "unidade")
    private String unidade;

    @NotNull
    @Column(name = "numero_quarto")
    private String numeroQuarto;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "data_reserva")
    private LocalDateTime dataReserva;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @NotBlank
    @Column(name = "acomodacao")
    private String acomodacao;

    @NotNull
    @Min(value = 0, message = "O valor da reserva deve ser maior que 0")
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_informacoes_adicionais")
    private InformacoesAdicionais informacoesAdicionais;

}
