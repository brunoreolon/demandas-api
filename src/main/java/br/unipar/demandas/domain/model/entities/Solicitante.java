package br.unipar.demandas.domain.model.entities;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ 
  @Type(value = Aluno.class, name = "aluno"), 
  @Type(value = Professor.class, name = "professor"), 
  @Type(value = UsuarioExterno.class, name = "usuarioExterno")
})
@Entity
public abstract class Solicitante extends Usuario{
	
//	@OneToMany(mappedBy = "solicitante")
//	private List<Demanda> demandas;
	
	public Solicitante() {
		super();
	}
	
//	public List<Demanda> getDemandas() {
//		return demandas;
//	}
//
//	public void setDemandas(List<Demanda> demandas) {
//		this.demandas = demandas;
//	}
	
}
