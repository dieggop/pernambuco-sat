package com.br.carrilho.silva.pernambucosat.services;

import com.br.carrilho.silva.pernambucosat.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoriaService {

	void apagarCategoria(Long id);
    Categoria salvaCategoria(Categoria Categoria);
    Optional<Categoria> recuperarCategoria(Long categoria);
    Page<Categoria> pesquisarCategoria(String termo);
    Page<Categoria> pesquisaTodasCategorias(Pageable pageable);
    
}
