package com.br.systemusecar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String codigo;

	@NotNull
    @Column(unique = true)
	private String descricao;

	@NotNull
	private String observacoes;

	@NotNull
    private Long quantidadeMinima;

	@OneToMany(mappedBy = "produto")
	private List<EntradaProduto> entradaProdutos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public List<EntradaProduto> getEntradaProdutos() {
		return entradaProdutos;
	}

	public void setEntradaProdutos(List<EntradaProduto> entradaProdutos) {
		this.entradaProdutos = entradaProdutos;
	}

	public Long getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Long quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}
}
