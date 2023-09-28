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

import com.controlaliga.entities.Ligacao;
import com.controlaliga.services.LigacaoService;

@RestController
@RequestMapping("/ligacao")
public class LigacaoController {

	private final LigacaoService ligacaoService;

	@Autowired
	public LigacaoController(LigacaoService ligacaoService) {
		this.ligacaoService = ligacaoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ligacao> buscaLigacaoControlId(@PathVariable Long id) {
		Ligacao ligacao = ligacaoService.getLigacaoById(id);
		if (ligacao != null) {
			return ResponseEntity.ok(ligacao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Ligacao>> buscaTodasLigacoesControl() {
		List<Ligacao> ligacao = ligacaoService.getAllLigacoes();
		return ResponseEntity.ok(ligacao);
	}

	@PostMapping("/")
	public ResponseEntity<Ligacao> saveLigacaoControl(@RequestBody Ligacao ligacao) {
		Ligacao saveLigacao = ligacaoService.saveLigacao(ligacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveLigacao);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Ligacao> alteraLigacaoControl(@PathVariable Long id, @RequestBody Ligacao ligacao) {
		Ligacao alteraLigacao = ligacaoService.changeLigacao(id, ligacao);

		if (alteraLigacao != null) {
			return ResponseEntity.ok(ligacao);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLigacaoControl(@PathVariable Long id) {
		boolean delete = ligacaoService.deleteLigacao(id);
		if (delete) {
			return ResponseEntity.ok().body("O produto foi excluido com o sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}