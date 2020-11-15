package br.unipar.demandas.api.model;

import br.unipar.demandas.domain.model.enums.StatusEnum;

public class StatusInput {

	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	
	
}
