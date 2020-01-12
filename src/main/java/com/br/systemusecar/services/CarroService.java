package com.br.systemusecar.services;

import com.br.systemusecar.model.Carro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarroService {
	
	Page<Carro> pesquisaTodosCarros(Pageable Pageable);
	Carro salvaCarro(Carro carro);
	Optional<Carro> recuperarCarro(Long id);
	void apagarCarro(Long codigo);        
    Page<Carro> pesquisarCarro(Carro codigo, Pageable pageable);
    
}
