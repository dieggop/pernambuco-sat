package com.br.carrilho.silva.pernambucosat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cidade {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	@NotEmpty
	private String ciadde; 
	
	@NotEmpty
	private String bairro;
	
	@NotEmpty
	private String uf;
	
	@NotEmpty
	private String logradouro;
	
	@NotEmpty
	@JsonIgnore
	private String cep;
	
	@NotEmpty
		private String municipio;
	
	
	public String getCiadde() {
		return ciadde;
	}
	public void setCiadde(String ciadde) {
		this.ciadde = ciadde;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	
	 @Override
	    public String toString() {
	        return "Cidade{" +
	                "ciadde=" + ciadde +
	                ", bairro='" + bairro + '\'' +
	                ", uf='" + uf + '\'' +
	                ", logradouro='" + logradouro + '\'' +
	                ", cep='" + cep + '\'' +
	                ", municipio=" + municipio +
	                '}';
	    }
	
	 
}
