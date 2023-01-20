package io.mnia.userservice.domain.entities.repositories;

import io.mnia.userservice.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
