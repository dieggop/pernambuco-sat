package com.br.carrilho.silva.pernambucosat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;

	@NotNull
	@Column(unique = true)
	private String nome;

    public Categoria() {

    }

	public Long getId() {
	return id;
	}

    public Categoria(@NotNull String nome) {
        this.nome = nome;
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
}
