package com.br.systemusecar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.br.systemusecar.model.Pais;
	
public interface PaisRepository extends PagingAndSortingRepository<Pais, Long> {
} 
