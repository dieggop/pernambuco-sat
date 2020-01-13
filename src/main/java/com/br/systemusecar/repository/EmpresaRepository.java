package com.br.systemusecar.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.br.systemusecar.model.Empresa;

public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Long> {
}

