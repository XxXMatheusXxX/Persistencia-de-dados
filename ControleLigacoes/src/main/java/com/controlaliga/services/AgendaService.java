package com.controlaliga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlaliga.entities.Agenda;
import com.controlaliga.repository.AgendaRepository;

@Service
public class AgendaService {
	private final AgendaRepository AgendaRepository;


	@Autowired
	public AgendaService(AgendaRepository AgendaRepository) {
		this.AgendaRepository = AgendaRepository;
	}

	public List<Agenda> getAllAgendas() {
		return AgendaRepository.findAll();
	}

	public Agenda getAgendaById(Long id) {
		Optional<Agenda> agenda = AgendaRepository.findById(id);
		return agenda.orElse(null);
	}

	public Agenda saveAgenda(Agenda agenda) {
		return AgendaRepository.save(agenda);
	}

	public Agenda changeAgenda(Long id, Agenda changeAgnd) {
		Optional<Agenda> existeAgenda = AgendaRepository.findById(id);
		if (existeAgenda.isPresent()) {
			changeAgnd.setId(id);
			return AgendaRepository.save(changeAgnd);
		}
		return null;
	}

	public boolean deleteAgenda(Long id) {
		Optional<Agenda> existeAgenda = AgendaRepository.findById(id);
		if (existeAgenda.isPresent()) {
			AgendaRepository.deleteById(id);
			return true;
		}
		return false;
	}

}