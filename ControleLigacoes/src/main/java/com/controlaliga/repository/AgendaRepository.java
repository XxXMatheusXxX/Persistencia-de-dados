package com.controlaliga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlaliga.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}