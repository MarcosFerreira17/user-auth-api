package io.gearrays.userservice.domain.entities.DTO;

import lombok.Data;
@Data
public class AddRoleToUserDTO {
    private String username;
    private String roleName;
}
