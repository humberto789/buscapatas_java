package com.imd.buscapatas.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imd.buscapatas.entity.Post;
import com.imd.buscapatas.service.PostService;
import com.imd.buscapatas.util.AzureConfig;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	AzureConfig azure;
	
	@Autowired
	PostService postService;

	@RequestMapping(value = "posts", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}

	@RequestMapping(value = "posts/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public Post getPostById(@PathVariable int id){
		return postService.getPostById(id);
	}

	@RequestMapping(value = "posts/usuario/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Post> getPostsByUsuario(@PathVariable int id){
		return postService.getPostsByUsuario(id);
	}

	@RequestMapping(value = "posts/perdidos", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Post> getPostsPerdidos(){
		return postService.getPostsPerdidos();
	}

	@RequestMapping(value = "posts/avistados", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<Post> getPostsAvistados(){
		return postService.getPostsAvistados();
	}
	
	@RequestMapping(value = "posts", method = RequestMethod.POST)
	public String addPost(@RequestParam("jsondata") String jsonData, @RequestParam(value = "file", required = false) MultipartFile arquivo) {
		
		try{

			Post post = objectMapper.readValue(jsonData, Post.class);
			
			String resultado = postService.addPost(post);
			
			if(arquivo != null) {
				post.setCaminhoImagem("post-foto-" + String.valueOf(post.getId()) + arquivo.getOriginalFilename());
				azure.enviarArquivo(arquivo, post.getCaminhoImagem());
			}else {
				post.setCaminhoImagem("post-foto-padrao.png");
			}
			
			postService.updateCaminhoImagemPost(post);
			
			return resultado;
		}catch(IOException e) {
			e.printStackTrace();
		}

		return "Houve algum erro";
	}
	
	@RequestMapping(value = "posts", method = RequestMethod.PUT)
	public String updatePost(@RequestParam("jsondata") String jsonData, @RequestParam(value = "file", required = false) MultipartFile arquivo) {
		try{

			Post post = objectMapper.readValue(jsonData, Post.class);
			
			if(arquivo != null) {
				post.setCaminhoImagem("post-foto-" + String.valueOf(post.getId()) + arquivo.getOriginalFilename());
				azure.enviarArquivo(arquivo, post.getCaminhoImagem());
			}else {
				post.setCaminhoImagem("post-foto-padrao.png");
			}
		
			return postService.updatePost(post);
		}catch(IOException e) {
			e.printStackTrace();
		}

		return "Houve algum erro";
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
