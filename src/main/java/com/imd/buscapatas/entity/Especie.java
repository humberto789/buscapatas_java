package com.imd.buscapatas.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Especie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String descricaoespecie;
	@OneToMany(mappedBy = "especieAnimal")
	private List<Post> posts;

	@OneToMany(mappedBy = "especie")
	private List<Raca> racas;
	
	public Especie() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEspecie() {
		return descricaoespecie;
	}

	public void setEspecie(String especie) {
		this.descricaoespecie = especie;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	
}
