package com.br.carrilho.silva.pernambucosat.model;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Fornecedor {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	@NotEmpty 
	private String nomeFornecedor;
	
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
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
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
        return "Fornecedor{" +
                "nomeFornecedor=" + nomeFornecedor +
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
