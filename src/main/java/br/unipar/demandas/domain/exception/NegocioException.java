package br.unipar.demandas.domain.exception;

public class NegocioException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NegocioException(String mensagen) {
		super(mensagen);
	}
	
}
