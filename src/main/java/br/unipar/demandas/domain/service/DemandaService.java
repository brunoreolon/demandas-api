package br.unipar.demandas.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.model.entities.Event;
import br.unipar.demandas.domain.model.entities.Solicitante;
import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.model.enums.StatusEnum;
import br.unipar.demandas.domain.repository.DemandaRepository;

@Service
public class DemandaService {

	@Autowired
	private DemandaRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Demanda salvar(Demanda demanda) {
		
		Event event = new Event();
		
		Optional<Usuario> solicitanteOptional = usuarioService.encontrarPorId(demanda.getSolicitante().getId());
		Solicitante usuario = (Solicitante) solicitanteOptional.get();
		
//		Optional<Usuario> CoordenadorOptional = usuarioService.encontrarPorId(demanda.getEvent().getCoordenador().getId());
//		Coordenador coordenador = (Coordenador) CoordenadorOptional.get();
		
		demanda.setEvent(event);
		demanda.setSolicitante(usuario);
		
		event.setDataCadastro(LocalDateTime.now());
		event.setStatus(StatusEnum.PENDENTE);
//		event.setCoordenador(coordenador);
		
		return repository.save(demanda);
	}

	public Demanda atualizar(Demanda demanda) {
		return null;
	}
	
	public List<Demanda> listar() {
		return this.repository.findAll();
	}

	public Optional<Demanda> encontrarPorId(Long id) {
		return this.repository.findById(id);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
}
