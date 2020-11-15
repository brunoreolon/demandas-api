package br.unipar.demandas.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.api.model.DemandaAtualizarInput;
import br.unipar.demandas.api.model.DemandaInput;
import br.unipar.demandas.domain.exception.NegocioException;
import br.unipar.demandas.domain.model.entities.Coordenador;
import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.model.entities.Solicitante;
import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.model.enums.StatusEnum;
import br.unipar.demandas.domain.repository.DemandaRepository;
import br.unipar.demandas.domain.utils.MapperDemanda;

@Service
public class DemandaService {

	@Autowired
	private DemandaRepository demandaRepository;

	@Autowired
	private UsuarioService usuarioService;

	private MapperDemanda mapper = new MapperDemanda();

	public Demanda salvar(DemandaInput demandaInput) {

		Demanda demanda = mapper.toEntity(demandaInput);

		Usuario solicitante = usuarioService.encontrarPorId(demandaInput.getSolicitanteId().getId())
				.orElseThrow(() -> new NegocioException("Usuário não encontrado"));

		Coordenador coordenador = (Coordenador) usuarioService.encontrarPorId(demandaInput.getCoordenadorId().getId())
				.orElseThrow(() -> new NegocioException("Coordenador não encontrado"));

		demanda.setSolicitante((Solicitante) solicitante);
		demanda.setCoordenador(coordenador);
		demanda.setDataCadastro(OffsetDateTime.now());
		demanda.setStatus(StatusEnum.PENDENTE);

		return demandaRepository.save(demanda);
	}

	public Demanda atualizar(DemandaAtualizarInput demandaInput) {

		Optional<Demanda> d = buscarPorId(demandaInput.getId());

		Demanda demanda = mapper.toEntityAtualizar(demandaInput);
		demanda.setSolicitante(d.get().getSolicitante());
		demanda.setCoordenador(d.get().getCoordenador());
		demanda.setDataCadastro(d.get().getDataCadastro());
		demanda.setStatus(d.get().getStatus());

		return demandaRepository.save(demanda);
	}

	public List<Demanda> listar() {
		return this.demandaRepository.findAll();
	}

	public List<Demanda> listarDemandasPendente(String status) {
		return this.demandaRepository.findByStatus(status);
	}

	public Optional<Demanda> buscarPorId(Long id) {
		return this.demandaRepository.findById(id);
	}

	public void excluir(Long id) {
		demandaRepository.deleteById(id);
	}
}
