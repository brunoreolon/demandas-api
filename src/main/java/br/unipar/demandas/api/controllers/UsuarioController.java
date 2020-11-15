package br.unipar.demandas.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import br.unipar.demandas.api.model.UsuarioModel;
import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.service.UsuarioService;
import br.unipar.demandas.domain.utils.MapperUsuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService; 

	private MapperUsuario mapper = new MapperUsuario();
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel cadastrar(@Valid @RequestBody Usuario usuario) {
		return mapper.toModel(usuarioService.salvar(usuario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id){
		
		Optional<Usuario> usuario = usuarioService.encontrarPorId(id);
		
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		UsuarioModel usuarioModel = mapper.toModel(usuario.get());
		return ResponseEntity.ok(usuarioModel);
	}
	
	@GetMapping
	public List<UsuarioModel> listar(){
		return mapper.toCollectionModel(usuarioService.listar());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioModel> atualizar(@Valid @PathVariable Long id, @RequestBody Usuario usuario){
		
		Optional<Usuario> usuarioId = usuarioService.encontrarPorId(id);
		
		if (!usuarioId.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuario.setId(id);
		usuario = usuarioService.atualizar(usuario);
		
		return ResponseEntity.ok(mapper.toModel(usuario));
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
