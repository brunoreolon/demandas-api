package br.unipar.demandas.domain.model;

import javax.persistence.Entity;

@Entity
public class UsuarioExterno extends Usuario implements ISolicitante{

	private Integer codigo;
	
	@Override
	public void cadastrar(Demanda demanda) {
		
	}

	@Override
	public void avaliar() {
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
