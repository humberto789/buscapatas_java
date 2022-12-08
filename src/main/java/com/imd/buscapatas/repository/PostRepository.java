package com.imd.buscapatas.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.imd.buscapatas.entity.TipoPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.imd.buscapatas.entity.Post;
import com.imd.buscapatas.entity.Sexo;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	public boolean existsById(int id);
	
	public List<Post> findByUsuarioIdOrderByTipoPostDescDataHoraDesc(int usuarioId);

	public Post findById(int id);

	List<Post> deleteById(int id);

	public List<Post> findDistinctByCoresAnimalIdIn(List<Integer> coresAnimal);

	public List<Post> findByTipoPost(TipoPost tipoPost);
	
	@Modifying
	@Transactional
	@Query("UPDATE post SET caminho_imagem = :caminho WHERE id = :id")
	public int updateCaminhoImagem(int id, String caminho);

}
