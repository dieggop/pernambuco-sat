package com.br.carrilho.silva.pernambucosat.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.br.carrilho.silva.pernambucosat.model.Empresa;

public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Long> {
}

