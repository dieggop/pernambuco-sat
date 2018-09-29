package com.br.carrilho.silva.pernambucosat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.br.carrilho.silva.pernambucosat.model.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {
    Page<Produto> findByDescricaoContainingIgnoreCase(Produto codigo, Pageable pageable);
} 