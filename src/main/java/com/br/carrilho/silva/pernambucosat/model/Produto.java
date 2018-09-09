package com.br.carrilho.silva.pernambucosat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	private String codigo;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Date   dataEntrada; 
	
	@NotNull
	private Date   dataSaida; 
	
	@NotNull
	private String tipoEntrada;
	
	@NotNull
	private String numeroNfCompra;
	
	@NotNull
	private Long precoCusto; 
	
	@NotNull
	private Long precoVenda; 

	@NotNull
	private Long quantidade;
	
	@NotNull
	private Long quantidadeMinima; 
	
	@NotNull
	private String Lote;
	
	@NotNull
	private String observacoes; 
	
	 @Override
	    public String toString() {
	        return "Produto{" +
	                "id=" + id +
	                ", codigo='" + codigo + '\'' +
	                ", descricao='" + descricao + '\'' +
	                ", dataEntrada='" + dataEntrada + '\'' +
	                ", dataSaida='" + dataSaida + '\'' +
	                ", tipoEntrada='" + tipoEntrada + '\'' +
	                ", numeroNfCompra='" + numeroNfCompra + '\'' +
	                 ", precoCusto='" + precoCusto + '\'' +
	                ", precoVenda='" + precoVenda + '\'' +
	                ", quantidade='" + quantidade + '\'' +
	                 ", quantidadeMinima='" + quantidadeMinima + '\'' +
	                ", Lote='" + Lote + '\'' +
	                ", admin=" + observacoes +
	                '}';
	    }
	
	
}
