package br.unipar.demandas.api.model;

import javax.validation.constraints.NotNull;

public class CoordenadorIdInput {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
