package br.unipar.demandas.api.controllers;

import java.util.List;
import java.util.Optional;

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

import br.unipar.demandas.domain.model.entities.Demanda;
import br.unipar.demandas.domain.service.DemandaService;

@RestController
@RequestMapping("/demandas")
public class DemandaController {

	@Autowired
	private DemandaService demandaService; 

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Demanda cadastrar(@RequestBody Demanda demanda) {
		
		return demandaService.salvar(demanda);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Demanda> buscarPorId(@PathVariable Long id){
		
		Optional<Demanda> demanda = demandaService.encontrarPorId(id);
		
		if (!demanda.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(demanda.get());
	}
	
	@GetMapping
	public List<Demanda> listar(){
	
		return this.demandaService.listar();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Demanda> atualizar(@PathVariable Long id, @RequestBody Demanda demanda){
		
		Optional<Demanda> demandaId = demandaService.encontrarPorId(id);
		if (!demandaId.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		demanda.setId(id);
		demanda = demandaService.atualizar(demanda);
		
		return ResponseEntity.ok(demanda);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Demanda> deletar(@PathVariable Long id){
		
		Optional<Demanda> demandaId = demandaService.encontrarPorId(id);
		
		if (!demandaId.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		demandaService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}
