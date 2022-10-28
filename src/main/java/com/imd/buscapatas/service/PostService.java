package com.imd.buscapatas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imd.buscapatas.entity.Post;
import com.imd.buscapatas.entity.Usuario;
import com.imd.buscapatas.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;

	public List<Post> findByCores(List<String> coresAnimal){
		List<Integer> listacores = new ArrayList<>();

		for(String s : coresAnimal) listacores.add(Integer.valueOf(s));

		try {
			List<Post> listaPosts = postRepository.findDistinctByCoresAnimalIdIn(listacores);
			return listaPosts;

		}catch(Exception e) {
			throw e;
		}
	}


	public List<Post> getAllPosts(){

		try {
			List<Post> listaPosts = postRepository.findAll();

			return listaPosts;
		}catch(Exception e) {
			throw e;
		}
	}

	public String addPost(Post post) {
		try {	
			
			postRepository.save(post);
			
			return "Post salvo com sucesso.";
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String removePost(Post post) {
		try {	
			if(postRepository.existsById(post.getId())) {
				postRepository.delete(post);
				return "Post removida com sucesso.";
			}else {
				return "Esse post não existe";
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String updatePost(Post post) {
		try {
			if(postRepository.existsById(post.getId())) {
				postRepository.save(post);
				return "Post atualizado com sucesso.";
			}else {
				return "Esse post não existe";
			}
		} catch (Exception e){
			throw e;
		}
	}
}
