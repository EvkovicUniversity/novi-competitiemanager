package com.example.novi.ncmdb.repository.user;

import com.example.novi.ncmdb.model.user.ERole;
import com.example.novi.ncmdb.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

    @Override
    <S extends Role> S save(S entity);
}
