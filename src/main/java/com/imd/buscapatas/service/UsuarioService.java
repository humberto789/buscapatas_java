package com.imd.buscapatas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Usuario;
import com.imd.buscapatas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAllUsuarios(){

		try {
			List<Usuario> listaUsuarios = usuarioRepository.findAll();
			
			return listaUsuarios;	
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addUsuario(Usuario usuario) {
		try {
			if (!usuarioRepository.existsByEmail(usuario.getEmail())) {
				usuarioRepository.save(usuario);
				return "Usuário salvo com sucesso.";
			}else {
				return "Já existe usuário cadastrado com esse e-mail.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Usuario> findByEmail(String email) {

		try {
			List<Usuario> usuario = usuarioRepository.findByEmail(email);
			return usuario;
		} catch (Exception e) {
			throw e;
		}

	}

	public Usuario findByEmailAndSenha(Usuario usuario) {

		try {
			Usuario user = usuarioRepository.findTop1ByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
			return user;
		} catch (Exception e) {
			throw e;
		}

	}
	
	public String removeUsuario(Usuario usuario) {
		try {
			if (usuarioRepository.existsByEmailAndSenha(usuario.getEmail(), usuario.getSenha())) {
				usuarioRepository.delete(usuario);
				return "Usuario removido com sucesso.";
			}else {
				return "Esse usuario não existe.";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String updateUsuario(Usuario usuario) {
		try {
			if(usuarioRepository.existsById(usuario.getId())) {
				usuarioRepository.save(usuario);
				return "Usuario atualizado com sucesso.";
			}else {
				return "Esse usuario não existe.";
			}
		} catch (Exception e){
			throw e;
		}
	}
}
