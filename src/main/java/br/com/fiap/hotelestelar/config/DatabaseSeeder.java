package br.com.fiap.hotelestelar.config;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.hotelestelar.models.InformacoesAdicionais;
import br.com.fiap.hotelestelar.models.Reserva;
import br.com.fiap.hotelestelar.repository.ReservaRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner{
    @Autowired
    ReservaRepository reservaRepository;

    @Override
    public void run(String... args) throws Exception {
        reservaRepository.saveAll(List.of(
             Reserva.builder()
                .unidade("Unidade 1")
                .numeroQuarto("101")
                .dataReserva(LocalDate.of(2023, 4, 17).atStartOfDay())
                .dataInicio(LocalDate.of(2023, 4, 20).atStartOfDay())
                .dataFim(LocalDate.of(2023, 4, 22).atStartOfDay())
                .acomodacao("Acomodação 1")
                .valorTotal(new BigDecimal("100"))
                .informacoesAdicionais(new InformacoesAdicionais())
                .build(),
            Reserva.builder()
                .unidade("Unidade 2")
                .numeroQuarto("102")
                .dataReserva(LocalDate.of(2023, 4, 18).atStartOfDay())
                .dataInicio(LocalDate.of(2023, 4, 21).atStartOfDay())
                .dataFim(LocalDate.of(2023, 4, 23).atStartOfDay())
                .acomodacao("Acomodação 2")
                .valorTotal(new BigDecimal("200"))
                .informacoesAdicionais(new InformacoesAdicionais())
                .build(),
            Reserva.builder()
                .unidade("Unidade 1")
                .numeroQuarto("103")
                .dataReserva(LocalDate.of(2023, 4, 19).atStartOfDay())
                .dataInicio(LocalDate.of(2023, 4, 22).atStartOfDay())
                .dataFim(LocalDate.of(2023, 4, 24).atStartOfDay())
                .acomodacao("Acomodação 3")
                .valorTotal(new BigDecimal("300"))
                .informacoesAdicionais(new InformacoesAdicionais())
                .build()
        ));
        
        
    }
    
}
