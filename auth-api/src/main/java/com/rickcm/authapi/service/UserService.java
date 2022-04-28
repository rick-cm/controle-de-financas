package com.rickcm.authapi.service;

import com.rickcm.authapi.data.vo.UserVO;
import com.rickcm.authapi.entity.User;
import com.rickcm.authapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public UserDetails authenticate(UserVO user){
        UserDetails userFromDatabase = loadUserByUsername(user.getEmail());
        boolean samePassword = userFromDatabase.getPassword().equals(User.encript(user.getPassword()));
        if(samePassword){
            return userFromDatabase;
        }
        throw new BadCredentialsException("Senha invalida");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login nao encontrado na base de dados."));
        return user;
    }
}
