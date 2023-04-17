package br.com.fiap.hotelestelar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.hotelestelar.models.InformacoesAdicionais;

public interface InformacoesAdicionaisRepository extends JpaRepository <InformacoesAdicionais, Long> {
    
}
