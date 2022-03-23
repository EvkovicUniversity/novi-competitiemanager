package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceuitslagService {

    private final RaceuitslagRepository raceuitslagRepository;

    public RaceuitslagService(RaceuitslagRepository raceuitslagRepository) {
        this.raceuitslagRepository = raceuitslagRepository;
    }

    public List<Raceuitslag> findAll() {
        return raceuitslagRepository.findAll();
    }

    public Raceuitslag findById(Long id) {
        return raceuitslagRepository.findById(id).get();
    }

}
