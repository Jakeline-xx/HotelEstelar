package br.com.hotelestelar.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.hotelestelar.exception.RestNotFoundException;
import br.com.hotelestelar.models.Reserva;
import br.com.hotelestelar.repository.ReservaRepository;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    Logger log = LoggerFactory.getLogger(ReservaController.class);

    @Autowired //IoD IoC
    ReservaRepository repository;


    @GetMapping("/minhas-reservas")
    public List<Reserva> index(){
        return repository.findAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> create(@RequestBody @Valid Reserva reserva) {

        log.info("cadastrando reserva: " + reserva);
        
        repository.save(reserva);

        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }


    @GetMapping("/detalhes/{idReserva}")
    public ResponseEntity<Reserva> show(@PathVariable Long idReserva) {
        log.info("buscando reserva com id " + idReserva);
        var reserva = repository.findById(idReserva).orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Reserva não encontrada"));
        return ResponseEntity.ok(reserva);


    }


    @DeleteMapping("/minha-reserva/apagar/{idReserva}")
    public ResponseEntity<Reserva> destroy(@PathVariable Long idReserva) {
        log.info("apagando reserva com id " + idReserva);
        var reserva = repository.findById(idReserva) .orElseThrow(() -> new RestNotFoundException("reserva não encontrada"));
        repository.delete(reserva);

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/minha-reserva/atualizar/{idReserva}")
    public ResponseEntity<Reserva> update(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        log.info("alterando reserva com id " + idReserva);
        repository.findById(idReserva).orElseThrow(() -> new RestNotFoundException("despesa não encontrada"));
        
        reserva.setId(idReserva);

        repository.save(reserva);

        return ResponseEntity.ok(reserva);

    }

}