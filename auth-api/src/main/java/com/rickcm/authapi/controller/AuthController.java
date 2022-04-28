package com.rickcm.authapi.controller;

import com.rickcm.authapi.data.vo.UserVO;
import com.rickcm.authapi.jwt.JwtService;
import com.rickcm.authapi.repository.UserRepository;
import com.rickcm.authapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final JwtService jwtService;
    private final UserService service;
    private final UserRepository userRepository;

    public AuthController(JwtService jwtService, UserService service, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.service = service;
        this.userRepository = userRepository;
    }

    @GetMapping("/teste")
    public String teste(){
        return "TESTE FAIL";
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserVO userVO){
        try {
            var username = userVO.getEmail();
            var password = userVO.getPassword();

            var user = userRepository.findByEmail(username);

            UserDetails usuarioAutenticado = service.authenticate(userVO);
            String token = jwtService.generateToken(usuarioAutenticado);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);

            return ResponseEntity.ok(model);

        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid username/password");
        }
    }
}
