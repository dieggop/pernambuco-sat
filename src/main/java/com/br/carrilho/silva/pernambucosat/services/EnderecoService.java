package com.br.carrilho.silva.pernambucosat.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.br.carrilho.silva.pernambucosat.model.Endereco;

public interface EnderecoService {

	void apagarEndereco(Long id);
	Endereco salvaEndereco(Endereco endereco);
	Optional<Endereco> recuperarEndereco(Long endereco);
    Page<Endereco> pesquisarEndereco(String endereco);
    Page<Endereco> pesquisaTodosEnderecos(Pageable pageable);
	
}
