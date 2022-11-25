package com.imd.buscapatas.controller;

import java.util.List;

import com.imd.buscapatas.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.imd.buscapatas.entity.Especie;
import com.imd.buscapatas.entity.Post;
import com.imd.buscapatas.entity.Usuario;
import com.imd.buscapatas.service.PostService;
import com.imd.buscapatas.service.UsuarioService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
	
	@Autowired
	PostService postService;

	@RequestMapping(value = "posts", method = RequestMethod.GET)
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}

	@RequestMapping(value = "posts/{id}", method = RequestMethod.GET)
	public Post getPostById(@PathVariable int id){
		return postService.getPostById(id);
	}

	@RequestMapping(value = "posts/usuario/{id}", method = RequestMethod.GET)
	public List<Post> getPostsByUsuario(@PathVariable int id){
		return postService.getPostsByUsuario(id);
	}

	@RequestMapping(value = "posts/perdidos", method = RequestMethod.GET)
	public List<Post> getPostsPerdidos(){
		return postService.getPostsPerdidos();
	}

	@RequestMapping(value = "posts/avistados", method = RequestMethod.GET)
	public List<Post> getPostsAvistados(){
		return postService.getPostsAvistados();
	}
	
	@RequestMapping(value = "posts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}
	
	@RequestMapping(value = "posts", method = RequestMethod.PUT)
	public String updatePost(@RequestBody Post post) {
		return postService.updatePost(post);
	}
	
	@RequestMapping(value = "posts/{id}", method = RequestMethod.DELETE)
	public String removePost(@PathVariable int id) {
		return postService.removePost(id);
	}

	@RequestMapping(value = "findbycores", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Post> findByCores(@RequestParam List<String> idcores){
		return (List<Post>) postService.findByCores(idcores);
	}

}
