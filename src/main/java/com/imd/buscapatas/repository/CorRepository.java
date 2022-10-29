package com.imd.buscapatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.Cor;

@Repository
public interface CorRepository extends JpaRepository<Cor, Integer>{

	public boolean existsById(int id);
	
	public boolean existsByNome(String cor);
	
}
