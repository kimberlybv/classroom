package com.edutech.classroom.service;

import com.edutech.classroom.Repository.RoleRepository;
import com.edutech.classroom.dto.RoleDTO;
import com.edutech.classroom.entity.Role;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor

public class RoleService {
    
    private final RoleRepository roleRepository;

    public List<RoleDTO> findAll(){
        return roleRepository.findAll().stream().map(RoleDTO::fromEntity).toList();
    }

    public RoleDTO findById(Integer id){
        return RoleDTO.fromEntity(roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrada")));
    }

    public RoleDTO create(RoleDTO dto) {
        Role entity = RoleDTO.toEntity(dto);
        return RoleDTO.fromEntity(roleRepository.save(entity));
    }

    public RoleDTO update(Integer id, RoleDTO dto) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());

        return RoleDTO.fromEntity(roleRepository.save(existing));
    }

    public void delete(Integer id) {
        roleRepository.delete(roleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Rol no encontrado")));
    }
    
}