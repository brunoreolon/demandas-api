package br.unipar.demandas.domain.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

import br.unipar.demandas.api.model.UsuarioInput;
import br.unipar.demandas.api.model.UsuarioModel;
import br.unipar.demandas.domain.model.entities.Aluno;
import br.unipar.demandas.domain.model.entities.Coordenador;
import br.unipar.demandas.domain.model.entities.Professor;
import br.unipar.demandas.domain.model.entities.Usuario;
import br.unipar.demandas.domain.model.entities.UsuarioExterno;

public class MapperUsuario {

	private ModelMapper mapper;
	
	public MapperUsuario() {
		this.mapper = new ModelMapper();
	}
	
	public UsuarioModel toModel(Usuario usuario) {
		return mapper.map(usuario, UsuarioModel.class);
	}

	public Usuario toEntity(UsuarioInput usuarioInput) {
		
		TypeMap<UsuarioInput, Usuario> typeMap = mapper.getTypeMap(UsuarioInput.class, Usuario.class);

		if (typeMap == null) {
			mapper.addMappings(new PropertyMap<UsuarioInput, Usuario>() {
				@Override
				protected void configure() {
//					skip(destination.getSolicitante());
				}
			});
		}

		return mapper.map(usuarioInput, Usuario.class);
	}

	public List<UsuarioModel> toCollectionModel(List<Usuario> usuarios) {

		List<UsuarioModel> usuarioModel = new ArrayList<UsuarioModel>();

		for (Usuario usuario : usuarios) {
			usuarioModel.add(toModel(usuario));
		}

		return usuarioModel;
	}
	
	public Usuario mapEntity(UsuarioInput entity) {
        
        mapper.createTypeMap(Aluno.class, Usuario.class)
        .setConverter(mappingContext -> mapper.map(mappingContext.getSource(), Usuario.class));

        mapper.createTypeMap(Professor.class, Usuario.class)
        .setConverter(mappingContext -> mapper.map(mappingContext.getSource(), Usuario.class));

        mapper.createTypeMap(UsuarioExterno.class, Usuario.class)
        .setConverter(mappingContext -> mapper.map(mappingContext.getSource(), Usuario.class));
        
        mapper.createTypeMap(Coordenador.class, Usuario.class)
        .setConverter(mappingContext -> mapper.map(mappingContext.getSource(), Usuario.class));
        
        
//        TypeMap<UsuarioInput, Usuario> typeMap = mapper.createTypeMap(UsuarioInput.class, UsuarioInput.class)
//        		.addMapping(UsuarioInput::getFirstName, UsuarioInput::setName);
//
//        	typeMap.include(UsuarioInput.class, Usuario.class)
//        		.include(SrcB.class, DestB.class)
//        		.include(SrcC.class, DestC.class);
//
//        	
//        	
//        	TypeMap<BaseSrcA, BaseDestA> typeMap = modelMapper.createTypeMap(BaseSrcA.class, BaseDestA.class)
//        		.addMapping(BaseSrcA::getFirstName, BaseDestA::setName);
//        	TypeMap<BaseSrcB, BaseDestB> typeMap = modelMapper.createTypeMap(BaseSrcB.class, BaseDestB.class)
//        		.addMapping(BaseSrcB::getAgeString, BaseDestB::setAge);
//
//        	typeMap.includeBase(BaseSrcA.class, BaseDestA.class)
//        		.includeBase(BaseSrcB.class, BaseDestB.class);
        
        
        
        return mapper.map(entity, Usuario.class);
    }
}
