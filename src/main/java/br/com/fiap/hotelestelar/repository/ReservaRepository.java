package br.com.fiap.hotelestelar.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hotelestelar.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    Page<Reserva> findByUnidadeContaining(String unidade, org.springframework.data.domain.Pageable pageable);

   
}
