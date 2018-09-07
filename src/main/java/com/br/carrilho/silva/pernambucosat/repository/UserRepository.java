package com.br.carrilho.silva.pernambucosat.repository;

import com.br.carrilho.silva.pernambucosat.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
