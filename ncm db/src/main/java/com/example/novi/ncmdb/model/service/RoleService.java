package com.example.novi.ncmdb.model.service;

import com.example.novi.ncmdb.model.authentication.models.Role;
import com.example.novi.ncmdb.model.authentication.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

}
