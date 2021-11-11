package io.juanqui.jwtsecurity;

import io.juanqui.jwtsecurity.domain.Role;
import io.juanqui.jwtsecurity.domain.SecurityUser;
import io.juanqui.jwtsecurity.service.SecurityUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtsecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(SecurityUserService userService) {
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveSecurityUser(new SecurityUser(null,"john travolta","john","1234",new ArrayList<>()));
			userService.saveSecurityUser(new SecurityUser(null,"will smith","will","1234",new ArrayList<>()));
			userService.saveSecurityUser(new SecurityUser(null,"jim carry","jim","1234",new ArrayList<>()));
			userService.saveSecurityUser(new SecurityUser(null,"arnold schwarezenegger","arnold","1234",new ArrayList<>()));

			userService.addRoleToUser("john","ROLE_USER");
			userService.addRoleToUser("will","ROLE_MANAGER");
			userService.addRoleToUser("jim","ROLE_ADMIN");
			userService.addRoleToUser("arnold","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold","ROLE_ADMIN");
			userService.addRoleToUser("arnold","ROLE_USER");


		};
	}

}
