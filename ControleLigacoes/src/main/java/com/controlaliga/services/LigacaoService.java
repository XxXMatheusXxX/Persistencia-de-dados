package com.controlaliga.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlaliga.entities.Ligacao;
import com.controlaliga.repository.LigacaoRepository;

@Service
public class LigacaoService {
	private final LigacaoRepository ligacaoRepository;


	@Autowired
	public LigacaoService(LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository = ligacaoRepository;
	}

	public List<Ligacao> getAllLigacoes() {
		return ligacaoRepository.findAll();
	}

	public Ligacao getLigacaoById(Long id) {
		Optional<Ligacao> Ligacao = ligacaoRepository.findById(id);
		return Ligacao.orElse(null);
	}

	public Ligacao saveLigacao(Ligacao Ligacao) {
		return ligacaoRepository.save(Ligacao);
	}

	public Ligacao changeLigacao(Long id, Ligacao changeLigc) {
		Optional<Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if (existeLigacao.isPresent()) {
			changeLigc.setId(id);
			return ligacaoRepository.save(changeLigc);
		}
		return null;
	}

	public boolean deleteLigacao(Long id) {
		Optional<Ligacao> existeLigacao= ligacaoRepository.findById(id);
		if (existeLigacao.isPresent()) {
			ligacaoRepository.deleteById(id);
			return true;
		}
		return false;
	}

}