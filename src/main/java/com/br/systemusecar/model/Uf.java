package com.br.systemusecar.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity	
public class Uf {

	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotNull
	 private String nome;
	 
	 @OneToMany(mappedBy="uf")
	 private List<Cidade> cidades;

	 @ManyToOne
	 private Pais pais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	@Override
	public String toString() {
		return "Uf [id=" + id + ", nome=" + nome + ", cidades=" + cidades + "]";
	}
	
}
