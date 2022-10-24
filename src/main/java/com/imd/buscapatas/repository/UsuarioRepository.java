package com.imd.buscapatas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imd.buscapatas.entity.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public boolean existsByEmailAndSenha(String email, String senha);
	public boolean existsByEmail(String email);

	public List<Usuario> findByEmail(String email);
	public Usuario findTop1ByEmailAndSenha(String email, String senha);

	public boolean existsById(int id);
	
	
}
