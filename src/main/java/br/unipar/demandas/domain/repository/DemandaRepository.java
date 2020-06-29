package br.unipar.demandas.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipar.demandas.domain.model.Demanda;

@Repository
public interface DemandaRepository extends JpaRepository<Demanda, Long>{

}
