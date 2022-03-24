package com.example.novi.ncmdb.domain.authenticatie.repository;

import com.example.novi.ncmdb.domain.authenticatie.models.ERole;
import com.example.novi.ncmdb.domain.authenticatie.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
