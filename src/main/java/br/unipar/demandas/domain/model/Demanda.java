package br.unipar.demandas.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Demanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;
	private String descricao;
	
//	@Temporal(TemporalType.DATE)
//	private Date data;
	
	@Temporal(TemporalType.DATE)
	private Date dataPrazo;
	
//	@Enumerated(EnumType.STRING)
//	private StatusEnum status;
	
//	@ManyToAny(metaColumn = @Column)
//	private ISolicitante solicitante;

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

//	public Date getData() {
//		return data;
//	}
//
//	public void setData(Date data) {
//		this.data = data;
//	}

	public Date getDataPrazo() {
		return dataPrazo;
	}

	public void setDataPrazo(Date dataPrazo) {
		this.dataPrazo = dataPrazo;
	}

//	public StatusEnum getStatus() {
//		return status;
//	}
//
//	public void setStatus(StatusEnum status) {
//		this.status = status;
//	}

//	public ISolicitante getSolicitante() {
//		return solicitante;
//	}
//
//	public void setSolicitante(ISolicitante solicitante) {
//		this.solicitante = solicitante;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demanda other = (Demanda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
