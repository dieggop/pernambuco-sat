package com.br.carrilho.silva.pernambucosat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public  class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    @JsonIgnore
    private String password;

    @NotNull
    private String name;

    @NotNull
    private boolean admin;

    @ManyToMany
    private List<Regras> regras;

    private String email;
    
    private Long numeroTelefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Regras> getRegras() {
		return regras;
	}

	public void setRegras(List<Regras> regras) {
		this.regras = regras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Long numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", admin="
				+ admin + ", regras=" + regras + ", email=" + email + ", numeroTelefone=" + numeroTelefone + "]";
	}
    

}
