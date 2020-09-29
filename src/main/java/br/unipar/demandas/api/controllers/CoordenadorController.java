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

import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.model.entities.Event;
import br.unipar.demandas.domain.service.CoordenadorService;
import br.unipar.demandas.domain.service.DemandaService;

@RestController
@RequestMapping("/coordenador")
public class CoordenadorController {
	
	@Autowired
	private CoordenadorService coordenadorService;
	
	
	@Autowired
	private DemandaService demandaService;
	
	@GetMapping()
	public List<Demanda> listarDemandasPendentes(){
		return coordenadorService.bucarPorStatus();
	}
	
//	@ResponseStatus(value = HttpStatus.NO_CONTENT)
//	@PatchMapping("/{id}/status")
//	public ResponseEntity<Demanda> avaliarDemanda(@PathVariable Long id, @RequestBody Event event) {
//		
//		Optional<Event> eventId = demandaService.buscarEventPorId(id);
//		
//		if (!eventId.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		
////		demanda.setId(demandaId.get().getId());
////		demanda = coordenadorService.avaliarDemanda(demanda);
//		
//		return ResponseEntity.ok(coordenadorService.avaliarDemanda(eventId.get()));
//	}
}
