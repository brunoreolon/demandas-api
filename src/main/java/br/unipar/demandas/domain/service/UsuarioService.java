package br.unipar.demandas.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.model.entities.Aluno;
import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario salvar(Usuario usuario) {

		Aluno aluno = (Aluno) usuario;
		return repository.save(aluno);
	}

	public Usuario atualizar(Usuario usuario) {
		return null;
	}

	public List<Usuario> listar() {
		return this.repository.findAll();
	}

	public Optional<Usuario> encontrarPorId(Long id) {
		return this.repository.findById(id);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}

}
