package com.edutech.classroom.dto;

import com.edutech.classroom.entity.Role;
import lombok.Data;

@Data
public class RoleDTO {

    private Integer id;
    private String name;
    private String description;

    public static RoleDTO fromEntity(Role entity) {
        RoleDTO dto = new RoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public static Role toEntity(RoleDTO dto) {
        Role entity = new Role();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
