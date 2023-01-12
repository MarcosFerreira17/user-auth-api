package io.gearrays.userservice.services;

import io.gearrays.userservice.domain.entities.AppUser;
import io.gearrays.userservice.domain.entities.Role;

import java.util.List;

public interface RoleService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String role);
    AppUser getUser(String username);
    List<AppUser>getUsers();
}
