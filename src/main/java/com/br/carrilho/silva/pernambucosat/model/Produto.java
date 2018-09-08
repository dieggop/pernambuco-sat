package com.br.carrilho.silva.pernambucosat.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produto {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty 
	private String codigo;
	
	@NotEmpty 
	private String descricao;
	
	@NotEmpty 
	private Date   dataEntrada; 
	
	@NotEmpty 
	private Date   dataSaida; 
	
	@NotEmpty 
	private String tipoEntrada;
	
	@NotEmpty 
	private String numeroNfCompra;
	
	@NotEmpty 
	private Long precoCusto; 
	
	@NotEmpty 
	private Long precoVenda; 

	@NotEmpty 
	private Long quantidade;
	
	@NotEmpty 
	private Long quantidadeMinima; 
	
	@NotEmpty 
	private String Lote;
	
	@NotEmpty 
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
