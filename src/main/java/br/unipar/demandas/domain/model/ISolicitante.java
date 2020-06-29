package br.unipar.demandas.domain.model;

import java.util.List;

import javax.persistence.OneToMany;

public interface ISolicitante {

//	@OneToMany(mappedBy = "solicitante")
//	public List<Demanda> demandas = null;
	
	void cadastrar(Demanda demanda);
	void avaliar();
	
}
