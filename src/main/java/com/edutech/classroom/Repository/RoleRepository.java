package com.edutech.classroom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edutech.classroom.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
}