package com.imd.buscapatas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imd.buscapatas.entity.Usuario;
import com.imd.buscapatas.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<Usuario> getAllUsuarios(){
		return usuarioService.getAllUsuarios();
	}

	@RequestMapping(value = "findbyemail", params = "email", method = RequestMethod.GET)
	@ResponseBody
	public List<Usuario> findByEmail(@RequestParam("email") String email){
		return (List<Usuario>) usuarioService.findByEmail(email);
	}

	@RequestMapping(value = "findbyemailandsenha", method = RequestMethod.GET)
	public List<Usuario> findByEmailAndSenha(@RequestBody Usuario usuario){
		return (List<Usuario>) usuarioService.findByEmailAndSenha(usuario);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.PUT)
	public String updateUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.DELETE)
	public String removeUsuario(@RequestBody Usuario usuario) {
		return usuarioService.removeUsuario(usuario);
	}
	
}
