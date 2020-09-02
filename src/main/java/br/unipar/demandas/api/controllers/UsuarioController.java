package br.unipar.demandas.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		
		return usuarioService.salvar(usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
		
		Optional<Usuario> usuario = usuarioService.encontrarPorId(id);
		
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario.get());
	}
	
	@GetMapping
	public List<Usuario> listar(){
	
		return this.usuarioService.listar();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
		
		Optional<Usuario> usuarioId = usuarioService.encontrarPorId(id);
		if (!usuarioId.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.setId(id);
		usuario = usuarioService.atualizar(usuario);
		
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletar(@PathVariable Long id){
		
		Optional<Usuario> usuarioId = usuarioService.encontrarPorId(id);
		
		if (!usuarioId.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}
