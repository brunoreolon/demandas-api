package br.unipar.demandas.api.model;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DemandaAtualizarInput {

	@NotNull
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private OffsetDateTime dataPrazo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public OffsetDateTime getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(OffsetDateTime dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

}
