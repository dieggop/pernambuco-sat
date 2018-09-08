package com.br.carrilho.silva.pernambucosat.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity	
public class Categoria {
	
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;

		@NotEmpty
	    @Column(unique = true)
	    private String categoria;

	    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
		
		 @Override
		    public String toString() {
		        return "Categoria{" +
		                "id=" + id +
		                ", categoria=" + categoria	 +
		                '}';
		    }

}
