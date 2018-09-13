package com.br.carrilho.silva.pernambucosat.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.br.carrilho.silva.pernambucosat.model.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {
} 