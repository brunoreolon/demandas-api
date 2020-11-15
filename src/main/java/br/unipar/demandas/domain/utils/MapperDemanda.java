package br.unipar.demandas.domain.utils;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

import br.unipar.demandas.api.model.DemandaAtualizarInput;
import br.unipar.demandas.api.model.DemandaInput;
import br.unipar.demandas.api.model.DemandaModel;
import br.unipar.demandas.domain.model.entities.Demanda;

public class MapperDemanda {

	private ModelMapper mapper;
	
	public MapperDemanda() {
		this.mapper = new ModelMapper();
	}
	
	public DemandaModel toModel(Demanda demanda) {
		return mapper.map(demanda, DemandaModel.class);
	}

	public Demanda toEntity(DemandaInput demandaInput) {
		
		TypeMap<DemandaInput, Demanda> typeMap = mapper.getTypeMap(DemandaInput.class, Demanda.class);

		if (typeMap == null) {
			mapper.addMappings(new PropertyMap<DemandaInput, Demanda>() {
				@Override
				protected void configure() {
					skip(destination.getSolicitante());
					skip(destination.getId());
				}
			});
		}

		return mapper.map(demandaInput, Demanda.class);
	}

	public Demanda toEntityAtualizar(DemandaAtualizarInput demandaInput) {
		
		TypeMap<DemandaInput, Demanda> typeMap = mapper.getTypeMap(DemandaInput.class, Demanda.class);

		if (typeMap == null) { 
			mapper.addMappings(new PropertyMap<DemandaInput, Demanda>() {
				@Override
				protected void configure() {
					skip(destination.getSolicitante());
					skip(destination.getId());
				}
			});
		}

		return mapper.map(demandaInput, Demanda.class);
	}
	
	public List<DemandaModel> toCollectionModel(List<Demanda> demandas) {

		List<DemandaModel> demandasModel = new ArrayList<DemandaModel>();

		for (Demanda demanda : demandas) {
			demandasModel.add(toModel(demanda));
		}

		return demandasModel;
	}
}
