package com.controlaliga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlaliga.entities.Agenda;
import com.controlaliga.services.AgendaService;

@RestController
@RequestMapping("/Agenda")
public class AgendaController {

	private final AgendaService AgendaService;

	@Autowired
	public AgendaController(AgendaService AgendaService) {
		this.AgendaService = AgendaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Agenda> buscaAgendaControlId(@PathVariable Long id) {
		Agenda Agenda = AgendaService.getAgendaById(id);
		if (Agenda != null) {
			return ResponseEntity.ok(Agenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Agenda>> buscaTodasLigacoesControl() {
		List<Agenda> Agenda = AgendaService.getAllAgendas();
		return ResponseEntity.ok(Agenda);
	}

	@PostMapping("/")
	public ResponseEntity<Agenda> saveAgendaControl(@RequestBody Agenda Agenda) {
		Agenda saveAgenda = AgendaService.saveAgenda(Agenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAgenda);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Agenda> alteraAgendaControl(@PathVariable Long id, @RequestBody Agenda Agenda) {
		Agenda alteraAgenda = AgendaService.changeAgenda(id, Agenda);

		if (alteraAgenda != null) {
			return ResponseEntity.ok(Agenda);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAgendaControl(@PathVariable Long id) {
		boolean delete = AgendaService.deleteAgenda(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}