package com.edutech.classroom.service;

import com.edutech.classroom.Repository.RoleRepository;
import com.edutech.classroom.Repository.UserRepository;
import com.edutech.classroom.dto.UserDTO;
import com.edutech.classroom.entity.Role;
import com.edutech.classroom.entity.User ;
import com.edutech.classroom.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<UserDTO> findAll(){
        return userRepository.findAll().stream().map(UserDTO::fromEntity).toList();
    }

    public UserDTO findById(Integer id){
        return UserDTO.fromEntity(userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
    }

    public UserDTO create(UserDTO dto) {
        Role role = roleRepository.findById(dto.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));

        User user = UserDTO.toEntity(dto);
        user.setRole(role);
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());

        return UserDTO.fromEntity(userRepository.save(user));
    }

    public UserDTO update(Integer id, UserDTO dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Role role = roleRepository.findById(dto.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPasswordHash(dto.getPasswordHash());
        existing.setIsActive(dto.getIsActive());
        existing.setRole(role);
        existing.setUpdatedAt(Instant.now());

        return UserDTO.fromEntity(userRepository.save(existing));
    }

    public void delete(Integer id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Categoría no encontrada")));
    }
}