package com.imd.buscapatas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imd.buscapatas.entity.Usuario;
import com.imd.buscapatas.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "getallusuarios", method = RequestMethod.GET)
	public List<Usuario> getAllUsuarios(){
		return usuarioService.getAllUsuarios();
	}
	
	@RequestMapping(value = "addusuario", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}
	
	@RequestMapping(value = "updateusuario", method = RequestMethod.PUT)
	public String updateUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}
	
	@RequestMapping(value = "deleteusuario", method = RequestMethod.PUT)
	public String removeUsuario(@RequestBody Usuario usuario) {
		return usuarioService.removeUsuario(usuario);
	}
	
}
