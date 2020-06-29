package br.unipar.demandas.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unipar.demandas.domain.model.Demanda;
import br.unipar.demandas.domain.repository.DemandaRepository;
import br.unipar.demandas.domain.service.DemandaService;

@RestController
@RequestMapping("/demandas")
public class DemandaController {

	@Autowired
	private DemandaService demandaService; 

	@Autowired
	private DemandaRepository demandaRepository; 
	
	@PostMapping
	public Demanda cadastrar(@RequestBody Demanda demanda) {
		return demandaService.salvar(demanda);
	}
	
	@GetMapping
	public List<Demanda> listar(){
		return this.demandaRepository.findAll();
	}
}
