package br.unipar.demandas.domain.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Usuario implements ISolicitante {

	private Integer ra;
	private String universidade;

	@Override
	public void cadastrar(Demanda demanda) {

	}

	@Override
	public void avaliar() {

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
