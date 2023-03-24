package br.com.estelar.hotelestelar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.estelar.hotelestelar.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
