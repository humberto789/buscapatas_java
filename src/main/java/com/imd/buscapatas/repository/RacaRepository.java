package com.imd.buscapatas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer>{
	
	public boolean existsById(int id);
	
	public boolean existsByNome(String raca);
	
	public List<Raca> findTop1ByNome(String raca);

	public List<Raca> findByEspecieId(int especie_id);

}
