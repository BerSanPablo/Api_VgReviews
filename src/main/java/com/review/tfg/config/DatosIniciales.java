package com.review.tfg.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.review.tfg.entity.Role;
import com.review.tfg.entity.Usuario;
import com.review.tfg.repository.UsuarioRepository;

@Profile("demo")
@Component
public class DatosIniciales implements CommandLineRunner {
	
	@Autowired
    private UsuarioRepository userRepo;
	

	private static final Logger logger = LoggerFactory.getLogger(DatosIniciales.class);

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("## Entrando al CommandLineRunner ##");

		//Si no encontramos el admin de test lo creamos
		if(userRepo.findByNick("admin") == null) {
			logger.info("## Creando admin ##");
			Usuario admin = new Usuario();
			admin.setNick("admin");
			admin.setEmail("admin@admin.com");
			admin.setPassword(new BCryptPasswordEncoder(10).encode("passwordadmin"));
			admin.getRoles().add(Role.ROLE_USER);
			admin.getRoles().add(Role.ROLE_ADMIN);
			userRepo.save(admin);
			logger.info("## Admin guardado ##");
		}
		
		logger.info("## Saliendo del CommandLineRunner ##");
	}
	
	
}
