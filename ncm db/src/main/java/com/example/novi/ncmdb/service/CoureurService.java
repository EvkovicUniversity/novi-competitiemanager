package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.Coureur;
import com.example.novi.ncmdb.repository.CoureurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoureurService {

    private CoureurRepository coureurRepository;

    public CoureurService(CoureurRepository coureurRepository){
        this.coureurRepository = coureurRepository;
    }

    public List<Coureur> findAll(){
        return coureurRepository.findAll();
    }
}
