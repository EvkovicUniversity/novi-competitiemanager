package com.example.novi.ncmdb.model.authentication.repository;

import com.example.novi.ncmdb.model.authentication.models.ERole;
import com.example.novi.ncmdb.model.authentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

    @Override
    <S extends Role> S save(S entity);
}
