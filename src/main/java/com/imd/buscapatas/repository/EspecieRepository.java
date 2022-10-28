package com.imd.buscapatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer>{

	public boolean existsById(int id);
	
	public boolean existsByNome(String nome);
	
	Especie findByNome(String nome);
}
