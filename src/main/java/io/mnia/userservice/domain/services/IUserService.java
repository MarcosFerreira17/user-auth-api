package io.mnia.userservice.domain.services;

import io.mnia.userservice.domain.entities.AppUser;
import io.mnia.userservice.domain.entities.Role;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String role);

    AppUser getUser(String username);

    List<AppUser> getUsers();
}
