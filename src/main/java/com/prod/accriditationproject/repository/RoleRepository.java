package com.prod.accriditationproject.repository;

import com.prod.accriditationproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> getRoleByRoleName(String name);

    boolean existsByRoleName(String name);
}
