package br.com.fiap.hotelestelar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.hotelestelar.models.Reserva;
import br.com.fiap.hotelestelar.repository.InformacoesAdicionaisRepository;
import br.com.fiap.hotelestelar.repository.ReservaRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/reserva")
public class ReservaController {


    @Autowired //IoD IoC
    ReservaRepository reservaRepository;

    @Autowired //IoD IoC
    InformacoesAdicionaisRepository informacoesAdiconaisRepository;



    @GetMapping("/minhas-reservas")
    public Page<Reserva> index(@RequestParam(required = false) String unidade, @PageableDefault(size = 5) Pageable pageable){
        if (unidade == null) return reservaRepository.findAll(pageable);
        return reservaRepository.findByUnidadeContaining(unidade, pageable);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> create(@RequestBody @Valid Reserva reserva) {
        log.info("cadastrando reserva: " + reserva);
        reservaRepository.save(reserva);
        reserva.setInformacoesAdicionais(informacoesAdiconaisRepository.findById(reserva.getInformacoesAdicionais().getIdInformacoesAdicionais()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }


    @GetMapping("/detalhes/{idReserva}")
    public ResponseEntity<Reserva> show(@PathVariable Long idReserva) {
        log.info("buscando reserva com id " + idReserva);
        return ResponseEntity.ok(getReserva(idReserva));


    }

    @DeleteMapping("/minha-reserva/apagar/{idReserva}")
    public ResponseEntity<Reserva> destroy(@PathVariable Long idReserva) {
        log.info("apagando reserva com id " + idReserva);
        reservaRepository.delete(getReserva(idReserva));
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/minha-reserva/atualizar/{idReserva}")
    public ResponseEntity<Reserva> update(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        log.info("alterando reserva com id " + idReserva);
        getReserva(idReserva);
        reserva.setId(idReserva);
        reservaRepository.save(reserva);
        return ResponseEntity.ok(reserva);

    }

    private Reserva getReserva(Long idReserva) {
        return reservaRepository.findById(idReserva).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Reserva não encontrada"));
    }


}