package com.br.systemusecar.services.impl;

import com.br.systemusecar.Exceptions.ExceptionConflict;
import com.br.systemusecar.model.Carro;
import com.br.systemusecar.repository.CarroRepository;
import com.br.systemusecar.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
 * Classe responsável por implementar o serviço Carro
 */
@Service
public class CarroServiceImpl implements CarroService {


    @Autowired
    CarroRepository carroRepository;

    @Override
    public void apagarCarro(Long id) {

        carroRepository.deleteById(id);
    }

    @Override
    public Carro salvaCarro(Carro carro) {
        try {
            return carroRepository.save(carro);
        } catch (Exception e)
        {
            throw new ExceptionConflict("Carro já existe.");
        }
    }

    @Override
    public Optional<Carro> recuperarCarro(Long id) {
        return carroRepository.findById(id);
    }

    @Override
    public Page<Carro> pesquisarCarro(Carro id, Pageable pageable) {
        return carroRepository.findAll(id, pageable);
    }

    @Override
    public Page<Carro> pesquisaTodosCarros(Pageable pageable) {
        return carroRepository.findAll(pageable);
    }

}
