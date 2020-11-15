package br.unipar.demandas.domain.model.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Aluno extends Solicitante {

	@NotNull
	private Integer ra;
	
	@NotBlank
	private String universidade;
	
	public Aluno() {
		super();
	}
	
	public Aluno(Long id) {
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
