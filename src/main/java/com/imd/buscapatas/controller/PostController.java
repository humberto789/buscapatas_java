package com.imd.buscapatas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imd.buscapatas.entity.Post;
import com.imd.buscapatas.service.PostService;
import com.imd.buscapatas.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
	
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "post", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addPost(@RequestBody Post post) {
		
		
		return postService.addPost(post);
	}

}
