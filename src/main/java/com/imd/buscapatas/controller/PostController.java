package com.imd.buscapatas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.entity.Post;
import com.imd.buscapatas.entity.Usuario;
import com.imd.buscapatas.service.PostService;
import com.imd.buscapatas.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "post", method = RequestMethod.GET)
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@RequestMapping(value = "post", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addEspecie(@RequestBody Post post) {
		return postService.addPost(post);
	}
	
	@RequestMapping(value = "post", method = RequestMethod.PUT)
	public String updateUsuario(@RequestBody Post post) {
		return postService.updatePost(post);
	}
	
	@RequestMapping(value = "post", method = RequestMethod.DELETE)
	public String removeUsuario(@RequestBody Post post) {
		return postService.removePost(post);
	}

}
