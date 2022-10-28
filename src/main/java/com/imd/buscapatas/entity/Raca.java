package com.imd.buscapatas.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Raca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@Column(unique=true)
	public String raca;

	@ManyToOne
	@JoinColumn(name = "especie_id", referencedColumnName = "id")
	public Especie especie;
	@OneToMany(mappedBy = "racaAnimal")
	private List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}


	
	public Raca() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
}
