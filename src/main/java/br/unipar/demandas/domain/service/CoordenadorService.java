package br.unipar.demandas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.exception.NegocioException;
import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.model.entities.Event;
import br.unipar.demandas.domain.model.enums.StatusEnum;
import br.unipar.demandas.domain.repository.DemandaRepository;
import br.unipar.demandas.domain.repository.EventRepository;

@Service
public class CoordenadorService {

	@Autowired
	private DemandaService demandaService;
	
	@Autowired
	private DemandaRepository demandaRepository;
	
	public List<Demanda> bucarPorStatus(){
		
		return demandaService.listar();
	}
	
//	public Demanda avaliarDemanda(Event event) {
//		
//		Demanda demandaAvaliacao = demandaRepository.findById(event.getDemanda().getId())
//				.orElseThrow(() -> new NegocioException("Demanda não encontrada"));
//		
//		if (!StatusEnum.PENDENTE.equals(demandaAvaliacao.getEvent().getStatus())) {
//			throw new NegocioException("Demanda não pode ser avaliada");
//		}
//		
//		demandaAvaliacao.getEvent().setStatus(event.getStatus());
//		
//		return demandaRepository.save(demandaAvaliacao);
//	}
}
