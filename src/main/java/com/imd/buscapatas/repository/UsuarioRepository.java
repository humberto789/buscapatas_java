package com.imd.buscapatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.Usuario;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public boolean existsByEmailAndSenha(String email, String senha);
	public boolean existsByEmail(String email);

	public List<Usuario> findByEmail(String email);
	public List<Usuario> findTop1ByEmailAndSenha(String email, String senha);

	public boolean existsById(int id);
	
	@Modifying
	@Transactional
	@Query("UPDATE usuario SET nome = :nome, email = :email, senha = :senha, telefone = :telefone, caminho_imagem = :caminho WHERE id = :id")
	public int updateAtributes(int id, String nome, String email, String senha, String telefone, String caminho);
}
