package br.com.fiap.hotelestelar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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

import br.com.fiap.hotelestelar.exception.RestNotFoundException;
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

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping("/minhas-reservas")
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String unidade, @PageableDefault(size = 5) Pageable pageable){
        Page<Reserva> reservas = (unidade == null)?
            reservaRepository.findAll(pageable):
            reservaRepository.findByUnidadeContaining(unidade, pageable);

        return assembler.toModel(reservas.map(Reserva::toModel));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> create(@RequestBody @Valid Reserva reserva) {
        log.info("cadastrando reserva: " + reserva);
        reservaRepository.save(reserva);
        reserva.setInformacoesAdicionais(informacoesAdiconaisRepository.findById(reserva.getInformacoesAdicionais().getIdInformacoesAdicionais()).get());
        return ResponseEntity
            .created(reserva.toModel().getRequiredLink("self").toUri())
            .body(reserva.toModel());
    }


    @GetMapping("/detalhes/{idReserva}")
    public EntityModel<Reserva> show(@PathVariable Long idReserva) {
        log.info("buscando reserva com id " + idReserva);
        var reserva = reservaRepository.findById(idReserva)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Reserva não encontrada"));
        return reserva.toModel();
    }

    @DeleteMapping("/minha-reserva/apagar/{idReserva}")
    public ResponseEntity<Reserva> destroy(@PathVariable Long idReserva) {
        log.info("apagando reserva com id " + idReserva);
        var reserva = reservaRepository.findById(idReserva)
        .orElseThrow(() -> new RestNotFoundException("reserva não encontrada"));
    reservaRepository.delete(reserva);

    return ResponseEntity.noContent().build();

    }

    @PutMapping("/minha-reserva/atualizar/{idReserva}")
    public EntityModel<Reserva> update(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        log.info("alterando reserva com id " + idReserva);
        reservaRepository.findById(idReserva)
            .orElseThrow(() -> new RestNotFoundException("Reserva não encontrada"));

        reserva.setId(idReserva);
        reservaRepository.save(reserva);

        return reserva.toModel();

    }

}