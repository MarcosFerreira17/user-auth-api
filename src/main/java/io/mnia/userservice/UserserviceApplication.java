package io.mnia.userservice;

import io.mnia.userservice.domain.entities.AppUser;
import io.mnia.userservice.domain.entities.Role;
import io.mnia.userservice.domain.entities.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "Marcos Ferreira", "marcosferreira", "mnia", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Mock da Silva", "mock", "mnia", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "UserTest", "tester", "mnia", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "John Doe", "doe", "mnia", new ArrayList<>()));

            userService.addRoleToUser("marcosferreira", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("mock", "ROLE_MANAGER");
            userService.addRoleToUser("tester", "ROLE_USER");
            userService.addRoleToUser("doe", "ROLE_ADMIN");
        };
    }
}
