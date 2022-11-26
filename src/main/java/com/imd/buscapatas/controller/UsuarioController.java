package com.imd.buscapatas.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imd.buscapatas.entity.Usuario;
import com.imd.buscapatas.service.UsuarioService;
import com.imd.buscapatas.util.S3Util;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	private static String caminhoImagens = "https://buscapatas.s3.sa-east-1.amazonaws.com/";

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@Autowired
	S3Util s3Util;

	@RequestMapping(value = "users", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
	public String addUsuario(@RequestParam("jsondata") String jsonData, @RequestParam("file") MultipartFile arquivo ) {

		try{

			Usuario usuario = objectMapper.readValue(jsonData, Usuario.class);

			if(!arquivo.isEmpty()) {
				usuario.setCaminhoImagem("usuario-foto-" + String.valueOf(usuario.getEmail()) + arquivo.getOriginalFilename());
				s3Util.saveFile(arquivo, usuario.getCaminhoImagem());
			}else {
				usuario.setCaminhoImagem("usuariofoto-padrao.png");
			}


			return usuarioService.addUsuario(usuario);
		}catch(IOException e) {
			e.printStackTrace();
		}


		return "Houve algum erro";

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
