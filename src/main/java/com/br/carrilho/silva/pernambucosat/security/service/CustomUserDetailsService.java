package com.br.carrilho.silva.pernambucosat.security.service;

import com.br.carrilho.silva.pernambucosat.model.Usuario;
import com.br.carrilho.silva.pernambucosat.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        Usuario usuario = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));


        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListsUer = AuthorityUtils.createAuthorityList("ROLE_USER");

        System.out.println(usuario.toString());
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.isAdmin() ? authorityListAdmin : authorityListsUer);

    }
}
