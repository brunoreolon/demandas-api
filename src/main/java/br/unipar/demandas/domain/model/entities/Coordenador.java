package br.unipar.demandas.domain.model.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Coordenador extends Usuario {

	@NotNull
	private Integer ra;
	
	@NotBlank
	private String universidade;

	public Coordenador() {
		super();
	}
	
	public Coordenador(Long id) {
		super(id);
	}
	
	public Integer getRa() {
		return ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
	}

	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

}
