package br.unipar.demandas.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.unipar.demandas.domain.model.entities.Demanda;

@Repository
public interface DemandaRepository extends JpaRepository<Demanda, Long>{
	
	@Query("from Demanda where status like concat(?1, '%')")
	List<Demanda> findByStatus(String status);
}
