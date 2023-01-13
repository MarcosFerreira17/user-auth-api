package io.gearrays.userservice.services;

import io.gearrays.userservice.domain.entities.AppUser;
import io.gearrays.userservice.domain.entities.Role;
import io.gearrays.userservice.repositories.RoleRepository;
import io.gearrays.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public AppUser saveUser(AppUser user) {
        log.info("saving new user to database, id: {}", user.getId());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role to database, name: {}", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("find user by username: {}", username);
        var user = userRepository.findByUsername(username);
        log.info("find role by name: {}", roleName);
        var role = roleRepository.findByName(roleName);
        log.info("Adding role {} to user {}", roleName, username);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUser(String username) {
        log.info("find user by username: {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("find all users");
        return userRepository.findAll();
    }
}
