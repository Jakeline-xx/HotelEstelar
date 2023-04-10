package br.com.hotelestelar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hotelestelar.models.InformacoesAdicionais;

public interface InformacoesAdicionaisRepository extends JpaRepository <InformacoesAdicionais, Long> {
    
}
