package com.br.systemusecar.repository;

import com.br.systemusecar.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<Usuario, Long> {

	Object findByUsername(String username);

    
}
