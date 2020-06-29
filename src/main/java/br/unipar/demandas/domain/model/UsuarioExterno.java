package br.unipar.demandas.domain.model;

import javax.persistence.Entity;

import br.unipar.demandas.domain.model.Usuario;

//@Entity
public class UsuarioExterno extends Usuario implements ISolicitante{

	@Override
	public void cadastrar(Demanda demanda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avaliar() {
		// TODO Auto-generated method stub
		
	}

}
