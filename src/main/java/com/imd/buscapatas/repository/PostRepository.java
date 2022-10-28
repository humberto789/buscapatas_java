package com.imd.buscapatas.repository;

import java.util.List;

import com.imd.buscapatas.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import com.imd.buscapatas.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	public boolean existsById(int id);
	
	public List<Post> findByUsuarioId(int usuarioId);

	public List<Post> findDistinctByCoresAnimalIdIn(List<Integer> coresAnimal);


}
