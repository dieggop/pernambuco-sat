package com.br.carrilho.silva.pernambucosat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Empresa {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	@NotEmpty 
	private String nomeEmpresa;
	
	@NotEmpty
	private String endereco;
	
	@NotEmpty
	private String cnpj;
	
	@NotEmpty
	private String inscricaoEstadual;
	
	@NotEmpty
	private String cep;
	
	@NotEmpty
	private String numero;
	
	@NotEmpty
	private String bairro;
	
	@NotEmpty
	private String cidade;
	
	@NotEmpty
	private String uf;
	
	@NotEmpty
	private String foneContato;
	
	@NotEmpty
	private String email;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getContato() {
		return foneContato;
	}
	public void setContato(String contato) {
		this.foneContato = contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public String toString() {
        return "Empresa{" +
                "nomeEmpresa=" + nomeEmpresa +
                ", endereco='" + endereco + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", foneContato='" + foneContato + '\'' +
                ", email=" + email +
                '}';
    }
}
