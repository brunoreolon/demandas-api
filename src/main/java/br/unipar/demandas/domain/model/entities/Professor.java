package br.unipar.demandas.domain.model.entities;

import javax.persistence.Entity;

@Entity
public class Professor extends Solicitante {

	private Integer ra;
	private String universidade;
	
	public Professor() {
		super();
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
