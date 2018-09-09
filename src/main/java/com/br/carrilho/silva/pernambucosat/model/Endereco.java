package com.br.carrilho.silva.pernambucosat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String endereco;

	@NotNull
	private String cep;

	@NotNull
	private String numero;

	@NotNull
	private String bairro;

	@NotNull
	@ManyToOne
	private Cidade cidade;

	private String complemento;

	@NotNull
	@ManyToOne
	private Uf uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Endereco() {
	}

	public Endereco(@NotNull String endereco, @NotNull String cep, @NotNull String numero, @NotNull String bairro, @NotNull Cidade cidade, String complemento, @NotNull Uf uf) {
		this.endereco = endereco;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Endereco{" +
				"id=" + id +
				", endereco='" + endereco + '\'' +
				", cep='" + cep + '\'' +
				", numero='" + numero + '\'' +
				", bairro='" + bairro + '\'' +
				", cidade=" + cidade +
				", complemento='" + complemento + '\'' +
				", uf=" + uf +
				'}';
	}
}