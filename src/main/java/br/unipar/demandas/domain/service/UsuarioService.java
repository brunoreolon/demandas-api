package br.unipar.demandas.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}

	public Usuario atualizar(Usuario usuario) {
		return repository.save(usuario);
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
