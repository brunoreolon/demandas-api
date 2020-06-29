package br.unipar.demandas.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.model.Demanda;
import br.unipar.demandas.domain.repository.DemandaRepository;

@Service
public class DemandaService {

	@Autowired
	private DemandaRepository repository;
	
	public Demanda salvar(Demanda demanda) {
		Optional<Demanda> demandaExistente = repository.findById(demanda.getId());
		
		if (demandaExistente != null && !demandaExistente.equals(demanda)) {
//			throw new ;
		}
		
		return repository.save(demanda);
	}

	public void atualizar() {
		
	}
	
	public List<Demanda> listar() {
		return this.repository.findAll();
	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
