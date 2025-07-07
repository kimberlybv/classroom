package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import com.edutech.classroom.entity.User;
import lombok.Data;
import java.time.Instant;

@Data
public class UserDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private Role role;
    private Boolean isActive = false;
    private Instant createdAt;
    private Instant updatedAt;

    public static UserDTO fromEntity(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPasswordHash(entity.getPasswordHash());
        dto.setRole(entity.getRole());
        dto.setIsActive(entity.getIsActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPasswordHash(dto.getPasswordHash());
        entity.setRole(dto.getRole());
        entity.setIsActive(dto.getIsActive());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
}
