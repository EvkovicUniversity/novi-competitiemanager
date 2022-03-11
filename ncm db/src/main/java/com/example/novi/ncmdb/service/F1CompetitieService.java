package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.Formula1.F1Competitie;
import com.example.novi.ncmdb.repository.f1repositories.CompetitieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class F1CompetitieService {

    private final CompetitieRepository competitieRepository;

    public F1CompetitieService(CompetitieRepository competitieRepository){
        this.competitieRepository = competitieRepository;
    }

    public List<F1Competitie> findAll(){
        return competitieRepository.findAll();
    }

    public Optional<F1Competitie> findById(Long id){
        return competitieRepository.findById(id);
    }

    public void addF1Competitie(F1Competitie f1Competitie) {
        competitieRepository.save(f1Competitie);
    }
}
