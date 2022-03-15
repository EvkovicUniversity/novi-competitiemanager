package com.example.novi.ncmdb.domain.competitiemanager.competitie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitieService {

    private final CompetitieRepository competitieRepository;

    public CompetitieService(CompetitieRepository competitieRepository){
        this.competitieRepository = competitieRepository;
    }

    public List<Competitie> findAll(){
        return competitieRepository.findAll();
    }

    public Optional<Competitie> findById(Long id){
        return competitieRepository.findById(id);
    }

    public void addCompetitie(Competitie competitie){
        competitieRepository.save(competitie);
    }
}
