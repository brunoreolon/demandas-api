package br.unipar.demandas.api.model;

import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DemandaInput {

	@NotBlank
	private String titulo;

	@NotBlank
	private String descricao;

	@Valid
	@NotNull
	private SolicitanteIdInput solicitanteId;

	@NotNull
	private OffsetDateTime dataPrazo;

	@Valid
	@NotNull
	private CoordenadorIdInput coordenadorId;

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

	public SolicitanteIdInput getSolicitanteId() {
		return solicitanteId;
	}

	public void setSolicitanteId(SolicitanteIdInput solicitanteId) {
		this.solicitanteId = solicitanteId;
	}

	public CoordenadorIdInput getCoordenadorId() {
		return coordenadorId;
	}

	public void setCoordenadorId(CoordenadorIdInput coordenadorId) {
		this.coordenadorId = coordenadorId;
	}

}
