package com.imd.buscapatas.entity;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Enumerated(EnumType.ORDINAL)
	private TipoPost tipoPost;
	@Type(type="text")
	private String outrasInformacoes;
	@Type(type="text")
	private String orientacoesGerais;
	private double recompensa;
	private boolean larTemporario;
	private double latitude;
	private double longitude;
	private String nomeAnimal;

	@ManyToOne
	@JoinColumn(name = "especie_id", referencedColumnName = "id")
	private Especie especieAnimal;
	@ManyToOne
	@JoinColumn(name = "raca_id", referencedColumnName = "id")
	private Raca racaAnimal;
	@Enumerated(EnumType.STRING)
	private Sexo sexoAnimal;
	@ManyToMany
	@JoinTable(name="post_has_cor",
		joinColumns= {@JoinColumn(name="post_id")},
		inverseJoinColumns= {@JoinColumn(name="cor_id")}
	)
	private List<Cor> coresAnimal;
	private boolean coleira;
		
	public Post() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoPost getTipoPost() {
		return tipoPost;
	}

	public void setTipoPost(TipoPost tipoPost) {
		this.tipoPost = tipoPost;
	}

	public String getOutrasInformacoes() {
		return outrasInformacoes;
	}

	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public String getOrientacoesGerais() {
		return orientacoesGerais;
	}

	public void setOrientacoesGerais(String orientacoesGerais) {
		this.orientacoesGerais = orientacoesGerais;
	}

	public double getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(double recompensa) {
		this.recompensa = recompensa;
	}

	public boolean isLarTemporario() {
		return larTemporario;
	}

	public void setLarTemporario(boolean larTemporario) {
		this.larTemporario = larTemporario;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public Especie getEspecieAnimal() {
		return especieAnimal;
	}

	public void setEspecieAnimal(Especie especieAnimal) {
		this.especieAnimal = especieAnimal;
	}

	public Raca getRacaAnimal() {
		return racaAnimal;
	}

	public void setRacaAnimal(Raca racaAnimal) {
		this.racaAnimal = racaAnimal;
	}

	public Sexo getSexoAnimal() {
		return sexoAnimal;
	}

	public void setSexoAnimal(Sexo sexoAnimal) {
		this.sexoAnimal = sexoAnimal;
	}

	public List<Cor> getCoresAnimal() {
		return coresAnimal;
	}

	public void setCoresAnimal(List<Cor> coresAnimal) {
		this.coresAnimal = coresAnimal;
	}

	public boolean isColeira() {
		return coleira;
	}

	public void setColeira(boolean coleira) {
		this.coleira = coleira;
	}
	
}
