package com.imd.buscapatas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.NotificacaoAvistamento;

@Repository
public interface NotificacaoAvistamentoRepository extends JpaRepository<NotificacaoAvistamento, Integer>{

public boolean existsById(int id);
	
	public List<NotificacaoAvistamento> findByUsuarioId(int usuarioId);

	public List<NotificacaoAvistamento> findByPostId(int postId);
}
