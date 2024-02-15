package com.review.tfg.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.review.tfg.config.DatosIniciales;
import com.review.tfg.dto.auth.request.LoginRequest;
import com.review.tfg.dto.auth.request.SignUpRequest;
import com.review.tfg.dto.auth.response.TokenDTO;
import com.review.tfg.entity.Role;
import com.review.tfg.entity.Usuario;
import com.review.tfg.repository.UsuarioRepository;
import com.review.tfg.service.AuthenticationService;
import com.review.tfg.service.JwtService;

import lombok.Builder;

@Builder
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
    private UsuarioRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    
    public AuthenticationServiceImpl(UsuarioRepository userRepository,
							         JwtService jwtService) {
	this.userRepo = userRepository;
	this.passwordEncoder = new BCryptPasswordEncoder(10);
	this.jwtService = jwtService;
	}

	@Override
	public TokenDTO signup(SignUpRequest request) throws IllegalArgumentException{

		if(!validSignUpRequest(request)) {
			return null; //TODO Devolver mensaje de error
		}

		Usuario usuario = new Usuario();
		usuario.setImagenPerfil(request.getImagenPerfil());
		usuario.setNick(request.getNick());
		usuario.setEmail(request.getEmail());
		usuario.setTelefono(request.getTelefono());
		usuario.setPassword(passwordEncoder.encode(request.getPassword()));
		usuario.setFechaCreacion(new Date());
		usuario.getRoles().add(Role.ROLE_USER);
		userRepo.save(usuario);
		logger.info("## USUARIO CREADO ##");

		logger.info("## INTENTANDO GENERAR TOKEN ##");
        String jwt = jwtService.generateToken(usuario);
		logger.info("## TOKEN GENERADO ##");
        return TokenDTO.builder().token(jwt).build();
	}

	@Override
	public TokenDTO signin(LoginRequest request) {

        Usuario user = userRepo.findByEmail(request.getEmail());
        if(user == null || passwordEncoder.matches(user.getPassword(), request.getPassword())) {
        	throw new IllegalArgumentException("Email o contraseña incorrectos");
        }
        
        String jwt = jwtService.generateToken(user);
        return TokenDTO.builder().token(jwt).build();
	}
	
	private Boolean validSignUpRequest(SignUpRequest request) {
		
		//Comprobamos si el email esta en uso
		if(userRepo.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("El email ya está en uso");
		}
		
		//Comprobamos si el nick esta en uso
		if(userRepo.existsByNick(request.getNick())) {
			throw new IllegalArgumentException("El nombre de usuario ya está en uso");
		}
		
		return true;
	}

}
