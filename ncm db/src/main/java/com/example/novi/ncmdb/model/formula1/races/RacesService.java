package com.example.novi.ncmdb.model.formula1.races;

import org.springframework.stereotype.Service;

@Service
public class RacesService {

    private final RacesRepository racesRepository;

    public RacesService(RacesRepository racesRepository) {
        this.racesRepository = racesRepository;
    }

    public Races save(Races races) {
        return racesRepository.save(races);
    }

    public Races findById(Long id) {
        return racesRepository.findById(id).get();
    }

    public Iterable<Races> findAll() {
        return racesRepository.findAll();
    }



}
