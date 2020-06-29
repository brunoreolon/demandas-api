package br.unipar.demandas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.model.Demanda;
import br.unipar.demandas.domain.repository.DemandaRepository;

@Service
public class DemandaService {

	@Autowired
	private DemandaRepository repository;
	
	public Demanda salvar(Demanda demanda) {
		return repository.save(demanda);
	}

	public List<Demanda> listar() {
		return this.repository.findAll();
	}
}
