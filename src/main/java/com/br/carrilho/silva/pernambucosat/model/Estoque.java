package com.br.carrilho.silva.pernambucosat.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Estoque {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    private Produto produto;

    private Long quantidade;

    private Long quantidadeMinima;

    private Double valor;
	
}
