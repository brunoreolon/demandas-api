package br.unipar.demandas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.exception.NegocioException;
import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.model.enums.StatusEnum;
import br.unipar.demandas.domain.repository.DemandaRepository;

@Service
public class CoordenadorService {

	private final String status = "PENDENTE";
	
	@Autowired
	private DemandaService demandaService;
	
	@Autowired
	private DemandaRepository demandaRepository;
	
	public List<Demanda> bucarPorStatus(){
		
		return demandaService.listarDemandasPendente(status);
	}
	
	public Demanda avaliarDemanda(Demanda demanda) {
		
		Demanda demandaAvaliada = demandaRepository.findById(demanda.getId())
				.orElseThrow(() -> new NegocioException("Demanda não encontrada"));
		
		if (!StatusEnum.PENDENTE.equals(demandaAvaliada.getStatus())) {
			throw new NegocioException("Demanda não pode ser avaliada");
		}
		
		demandaAvaliada.setStatus(demanda.getStatus());
		
		return demandaRepository.save(demandaAvaliada);
	}
}
