package br.unipar.demandas.domain.model.entities;

import javax.persistence.Entity;

@Entity
public class UsuarioExterno extends Solicitante{

	private Integer codigo;
	
	public UsuarioExterno() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
