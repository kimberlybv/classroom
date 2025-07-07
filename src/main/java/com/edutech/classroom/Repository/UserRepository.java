package com.edutech.classroom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edutech.classroom.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}