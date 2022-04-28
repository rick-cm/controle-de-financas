package com.rickcm.authapi;

import com.rickcm.authapi.entity.User;
import com.rickcm.authapi.entity.UserPermission;
import com.rickcm.authapi.enums.UserAuthority;
import com.rickcm.authapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class AuthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
						   BCryptPasswordEncoder passwordEncoder){
		return args -> {
			initUsers(userRepository, passwordEncoder);
		};
	}

	private void initUsers(UserRepository userRepository,
						   BCryptPasswordEncoder passwordEncoder){
		Optional<User> find = userRepository.findByEmail("rick@teste.com");
		if(find.isEmpty()){
			User admin = new User("rick@teste.com",
					UUID.randomUUID().toString(),
					User.encript("1234"),
					Arrays.asList(new UserPermission(UserAuthority.ADMIN.toString())));
			userRepository.save(admin);
		}

		find = userRepository.findByEmail("gabs@teste.com");
		if(find.isEmpty()){
			User normal = new User("gabs@teste.com",
					UUID.randomUUID().toString(),
					User.encript("1234"),
					Arrays.asList(new UserPermission(UserAuthority.USER.toString())));
			userRepository.save(normal);
		}
	}
}
