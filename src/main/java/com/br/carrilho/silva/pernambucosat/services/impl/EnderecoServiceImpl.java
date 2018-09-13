package com.br.carrilho.silva.pernambucosat.services.impl;


import com.br.carrilho.silva.pernambucosat.Exceptions.ExceptionConflict;
import com.br.carrilho.silva.pernambucosat.model.Endereco;
import com.br.carrilho.silva.pernambucosat.repository.EnderecoRepository;
import com.br.carrilho.silva.pernambucosat.services.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import java.util.Optional;


@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public void apagarEndereco(Long id) {
		enderecoRepository.deleteById(id);
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	@Override
	public Endereco salvaEndereco(Endereco endereco) {

		if (StringUtils.isEmpty(endereco.getEndereco())) {
			throw new ExceptionConflict("O Endereco é obrigatório!");
		}

		try {
			return enderecoRepository.save(endereco);
		} catch (Exception e)
		{
			throw new ExceptionConflict("endereco já existe.");
		}

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Endereco> recuperarEndereco(Long endereco) {
		return enderecoRepository.findById(endereco);
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Endereco> pesquisarEndereco(String endereco) {
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Page<Endereco> pesquisaTodosEnderecos(Pageable pageable) {
		return enderecoRepository.findAll(pageable);
	}
}

