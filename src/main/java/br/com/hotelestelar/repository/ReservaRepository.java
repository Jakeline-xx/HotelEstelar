package br.com.hotelestelar.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelestelar.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
