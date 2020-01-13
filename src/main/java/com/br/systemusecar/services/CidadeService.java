package com.br.systemusecar.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.br.systemusecar.model.Cidade;
import java.util.Optional;

public interface CidadeService {

	void apagarCidade(Long id);
	Cidade salvaCidade(Cidade ciadade);
	Optional<Cidade> recuperarCidade(Long ciadade);
    Page<Cidade> pesquisarCidade(String cidade);
    Page<Cidade> pesquisaTodasCidades(Pageable pageable);
	
}
