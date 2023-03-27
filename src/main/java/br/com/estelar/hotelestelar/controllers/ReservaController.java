package br.com.estelar.hotelestelar.controllers;

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

import br.com.estelar.hotelestelar.models.Reserva;
import br.com.estelar.hotelestelar.repository.ReservaRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    Logger log = LoggerFactory.getLogger(ReservaController.class);

    List<Reserva> reservas = new ArrayList<>();

    @Autowired //IoD IoC
    ReservaRepository repository;


    @GetMapping("/api/minhas-reservas")
    public List<Reserva> index(){
        return repository.findAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        log.info("cadastrando reserva: " + reserva);
        
       repository.save(reserva);

        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }


    @GetMapping("/detalhes/{idReserva}")
    public ResponseEntity<Reserva> show(@PathVariable Long idReserva) {
        log.info("buscando reserva com id " + idReserva);
        var reservaEncontrada = repository.findById(idReserva);

        if (reservaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(reservaEncontrada.get());

    }


    @DeleteMapping("/api/minha-reserva/apagar/{idReserva}")
    public ResponseEntity<Reserva> destroy(@PathVariable Long idReserva) {
        log.info("apagando reserva com id " + idReserva);
        var reservaEncontrada = repository.findById(idReserva);

        if (reservaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        repository.delete(reservaEncontrada.get());

        return ResponseEntity.noContent().build();

    }

    @PutMapping("/api/minha-reserva/atualizar/{idReserva}")
    public ResponseEntity<Reserva> update(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        log.info("alterando reserva com id " + idReserva);
        var reservaEncontrada = repository.findById(idReserva) ;

        if (reservaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        
        reserva.setId(idReserva);

        repository.save(reserva);

        return ResponseEntity.ok(reserva);

    }

}