package com.imd.buscapatas.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;
import org.hibernate.annotations.Type;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Enumerated(EnumType.STRING)
	private TipoPost tipoPost;

	@Type(type="text")
	private String outrasInformacoes;

	@Type(type="text")
	private String orientacoesGerais;

	@Column(nullable = true)
	private int recompensa;

	@Column(nullable = true, columnDefinition = "bool default null")
	private boolean larTemporario;

	private double latitude;
	private double longitude;
	private String nomeAnimal;
	private boolean coleira;

	private LocalDateTime dataHora = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

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
		
	public Post() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoPost getTipoPost() { return tipoPost; }

	public void setTipoPost(TipoPost tipoPost) {
		this.tipoPost = tipoPost;
	}

	public String getOutrasInformacoes() { return outrasInformacoes; }

	public void setOutrasInformacoes(String outrasInformacoes) {
		this.outrasInformacoes = outrasInformacoes;
	}

	public String getOrientacoesGerais() {
		return orientacoesGerais;
	}

	public void setOrientacoesGerais(String orientacoesGerais) {
		this.orientacoesGerais = orientacoesGerais;
	}

	public int getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(int recompensa) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
}
