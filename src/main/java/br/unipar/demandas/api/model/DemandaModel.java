package br.unipar.demandas.api.model;

import java.time.OffsetDateTime;

import br.unipar.demandas.domain.model.enums.StatusEnum;

public class DemandaModel {

	private Long id;
	private String titulo;
	private String descricao;
	private SolicitanteModel solicitante;
	private OffsetDateTime dataCadastro;
	private OffsetDateTime dataPrazo;
	private CoordenadorModel coordenador;
	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

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

	public SolicitanteModel getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(SolicitanteModel solicitante) {
		this.solicitante = solicitante;
	}

	public OffsetDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(OffsetDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public OffsetDateTime getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(OffsetDateTime dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

	public CoordenadorModel getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(CoordenadorModel coordenador) {
		this.coordenador = coordenador;
	}

}
