package io.mnia.userservice.domain.DTO;

import lombok.Data;

@Data
public class AddRoleToUserDTO {
    private String username;
    private String roleName;
}
