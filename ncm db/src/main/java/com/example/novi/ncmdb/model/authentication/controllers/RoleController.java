package com.example.novi.ncmdb.model.authentication.controllers;

import com.example.novi.ncmdb.model.authentication.models.ERole;
import com.example.novi.ncmdb.model.authentication.models.Role;
import com.example.novi.ncmdb.model.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @CrossOrigin
    @PutMapping(path = "api/roles")
    public ResponseEntity<String> addRole(ERole eRole) {

        try {
            Role role = new Role();
            role.setName(eRole);

            roleService.saveRole(role);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
