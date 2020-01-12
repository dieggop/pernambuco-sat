package com.br.systemusecar.repository;

import com.br.systemusecar.model.Carro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarroRepository extends PagingAndSortingRepository<Carro, Long> {

	Page<Carro> findAll(Carro id, Pageable pageable);
	 
}
