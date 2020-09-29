package br.unipar.demandas.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.exception.NegocioException;
import br.unipar.demandas.domain.model.entities.Coordenador;
import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.model.entities.Event;
import br.unipar.demandas.domain.model.entities.Solicitante;
import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.model.enums.StatusEnum;
import br.unipar.demandas.domain.repository.DemandaRepository;
import br.unipar.demandas.domain.repository.EventRepository;

@Service
public class DemandaService {

	@Autowired
	private DemandaRepository demandaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EventRepository eventRepository;
	
	public Demanda salvar(Demanda demanda) {
		
		Event event = new Event();
		
		Usuario solicitante = usuarioService.encontrarPorId(demanda.getSolicitante().getId())
				.orElseThrow(() -> new NegocioException("Usuário não encontrado"));
		
		Coordenador coordenador = (Coordenador) usuarioService.encontrarPorId(3L /**demanda.getEvent().getCoordenador().getId()**/)
				.orElseThrow(() -> new NegocioException("Coordenador não encontrado"));
		
		demanda.setEvent(event);
		demanda.setSolicitante( (Solicitante) solicitante);
		
		event.setDemanda(demanda);
		event.setDataCadastro(OffsetDateTime.now());
		event.setDataPrazo(demanda.getEvent().getDataPrazo());
		event.setStatus(StatusEnum.PENDENTE);
		event.setCoordenador(coordenador);
		
		return demandaRepository.save(demanda);
	}

	public Demanda atualizar(Demanda demanda) {
		return demandaRepository.save(demanda);
	}
	
	public List<Demanda> listar() {
		return this.demandaRepository.findAll();
	}

	public Optional<Demanda> buscarPorId(Long id) {
		return this.demandaRepository.findById(id);
	}
	
	public Optional<Event> buscarEventPorId(Long id){
		return this.eventRepository.findById(id);
	}
	
//	public List<Demanda> bucarPorStatus() {
//		return this.demandaRepository.findByStatus();
//	}
	
	public void excluir(Long id) {
		demandaRepository.deleteById(id);
	}
}
