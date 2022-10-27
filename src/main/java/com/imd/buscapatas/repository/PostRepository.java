package com.imd.buscapatas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imd.buscapatas.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	public boolean existsById(int id);
	
	public List<Post> findByUsuarioId(int usuarioId);
}
