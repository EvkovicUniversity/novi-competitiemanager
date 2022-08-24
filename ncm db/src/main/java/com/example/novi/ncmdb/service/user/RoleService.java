package com.example.novi.ncmdb.service.user;

import com.example.novi.ncmdb.model.user.Role;
import com.example.novi.ncmdb.repository.user.RoleRepository;
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
