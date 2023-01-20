package io.mnia.userservice.api.v1.controllers;

import io.mnia.userservice.domain.entities.AppUser;
import io.mnia.userservice.domain.entities.DTO.AddRoleToUserDTO;
import io.mnia.userservice.domain.entities.Role;
import io.mnia.userservice.domain.entities.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<AppUser> getUsers(@RequestBody AppUser user) {
        return ResponseEntity.ok().body(userService.saveUser(user));
    }

    @PostMapping("/user")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/user")
    public ResponseEntity<?> addRoleToUser(@RequestBody AddRoleToUserDTO userRole) {
        userService.addRoleToUser(userRole.getUsername(), userRole.getRoleName());
        return ResponseEntity.ok().build();
    }
}
