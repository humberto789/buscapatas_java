package com.imd.buscapatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.Raca;

@Repository
public interface RacaRepository extends JpaRepository<Raca, Integer>{
	
	public boolean existsById(int id);
	
	public boolean existsByRaca(String raca);
}
