package com.br.systemusecar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.br.systemusecar.model.Entrada;

public interface EntradaRepository extends PagingAndSortingRepository<Entrada, Long> {
}
