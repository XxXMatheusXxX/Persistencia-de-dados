package com.controlaliga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlaliga.entities.Ligacao;

public interface  LigacaoRepository extends JpaRepository<Ligacao, Long> {

}