package com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitieService {

    private final CompetitieRepository competitieRepository;

    public CompetitieService(CompetitieRepository competitieRepository) {
        this.competitieRepository = competitieRepository;
    }

    public List<Competitie> findAll() {
        return competitieRepository.findAll();
    }

    public Competitie findById(Long id) {
        return competitieRepository.findById(id).get();
    }

    public Competitie save(Competitie competitie) {
        return competitieRepository.save(competitie);
    }
}
