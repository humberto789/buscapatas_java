package com.imd.buscapatas.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.NotificacaoAvistamento;

@Repository
public interface NotificacaoAvistamentoRepository extends JpaRepository<NotificacaoAvistamento, Integer>{

public boolean existsById(int id);
	
	public List<NotificacaoAvistamento> findByUsuarioId(int usuarioId);

	public List<NotificacaoAvistamento> findByPostId(int postId);
	
	@Modifying
	@Transactional
	@Query("UPDATE notificacao_avistamento SET caminho_imagem = :caminho WHERE id = :id")
	public int updateCaminhoImagem(int id, String caminho);
}
