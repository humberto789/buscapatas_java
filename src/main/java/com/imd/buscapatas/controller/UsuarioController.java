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
	
	@RequestMapping(value = "users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Usuario> getAllUsuarios(){
		return usuarioService.getAllUsuarios();
	}

	@RequestMapping(value = "findbyemail", params = "email", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Usuario> findByEmail(@RequestParam("email") String email){
		return (List<Usuario>) usuarioService.findByEmail(email);
	}

	@RequestMapping(value = "usuarioautorizado", params = {"email","senha"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Usuario> findByEmailAndSenha(@RequestParam String email, @RequestParam String senha){
		return (List<Usuario>) usuarioService.findByEmailAndSenha(email, senha);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.PUT)
	public String updateUsuario(@RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(usuario);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.DELETE)
	public String removeUsuario(@RequestBody Usuario usuario) {
		return usuarioService.removeUsuario(usuario);
	}
	
}
