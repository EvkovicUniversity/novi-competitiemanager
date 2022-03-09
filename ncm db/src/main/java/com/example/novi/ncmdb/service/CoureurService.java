package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.Coureur;
import com.example.novi.ncmdb.repository.CoureurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoureurService {

    private final CoureurRepository coureurRepository;

    public CoureurService(CoureurRepository coureurRepository){
        this.coureurRepository = coureurRepository;
    }

    public List<Coureur> findAll(){
        return coureurRepository.findAll();
    }

    public Optional<Coureur> findById(Long id){
        return coureurRepository.findById(id);
    }

    public List<Coureur> findGeneratedF1MatchById(Long id){



        return null;
    }

//    private List<Coureur> generateF1Match(){
//        Math.random()
//
//        return null;
//    }

}
