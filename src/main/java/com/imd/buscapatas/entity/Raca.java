package com.imd.buscapatas.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
public class Raca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	public String nome;

	@ManyToOne
	@JoinColumn(name = "especie_id", referencedColumnName = "id")
	public Especie especie;

	public Raca() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String raca) {
		this.nome = raca;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
}
