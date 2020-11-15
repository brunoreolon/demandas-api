package br.unipar.demandas.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unipar.demandas.api.model.DemandaAtualizarInput;
import br.unipar.demandas.api.model.DemandaInput;
import br.unipar.demandas.api.model.DemandaModel;
import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.service.DemandaService;
import br.unipar.demandas.domain.utils.MapperDemanda;

@RestController
@RequestMapping("/demandas")
public class DemandaController {

	@Autowired
	private DemandaService demandaService;

	private MapperDemanda mapper = new MapperDemanda();
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DemandaModel cadastrar(@Valid @RequestBody DemandaInput demandaInput) {
		return mapper.toModel(demandaService.salvar(demandaInput));
	}

	@GetMapping
	public List<DemandaModel> listar() {
		return mapper.toCollectionModel(demandaService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DemandaModel> buscarPorId(@PathVariable Long id) {

		Optional<Demanda> demanda = demandaService.buscarPorId(id);

		if (!demanda.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		DemandaModel demandaModel = mapper.toModel(demanda.get());
		return ResponseEntity.ok(demandaModel);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DemandaModel> atualizar(@Valid @PathVariable Long id,
			@RequestBody DemandaAtualizarInput demandaInput) {
		
		Optional<Demanda> demandaId = demandaService.buscarPorId(id);

		if (!demandaId.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		demandaInput.setId(id);		
		Demanda demanda = demandaService.atualizar(demandaInput);
		
		return ResponseEntity.ok(mapper.toModel(demanda));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Demanda> deletar(@PathVariable Long id) {

		Optional<Demanda> demandaId = demandaService.buscarPorId(id);

		if (!demandaId.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		demandaService.excluir(id);

		return ResponseEntity.noContent().build();
	}
}
