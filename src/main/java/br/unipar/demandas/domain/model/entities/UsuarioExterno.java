package br.unipar.demandas.domain.model.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class UsuarioExterno extends Solicitante{

	@NotNull
	private Integer codigo;
	
	public UsuarioExterno() {
		super();
	}
	
	public UsuarioExterno(Long id) {
		super(id);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
