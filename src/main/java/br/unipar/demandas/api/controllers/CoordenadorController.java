package br.unipar.demandas.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unipar.demandas.api.model.DemandaModel;
import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.service.CoordenadorService;
import br.unipar.demandas.domain.service.DemandaService;
import br.unipar.demandas.domain.utils.MapperDemanda;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {
	
	@Autowired
	private CoordenadorService coordenadorService;
	
	@Autowired
	private DemandaService demandaService;
	
	private MapperDemanda mapper = new MapperDemanda();
	
	@GetMapping()
	public List<DemandaModel> listarDemandasPendentes(){
		return mapper.toCollectionModel(coordenadorService.bucarPorStatus());
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@PatchMapping("/{id}/status")
	public ResponseEntity<DemandaModel> avaliarDemanda(@PathVariable Long id, @RequestBody Demanda demanda) {
		
		Optional<Demanda> demandaId = demandaService.buscarPorId(id);
		
		if (!demandaId.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		demanda.setId(demandaId.get().getId());
		
		return ResponseEntity.ok(mapper.toModel(coordenadorService.avaliarDemanda(demanda)));
	}
}
