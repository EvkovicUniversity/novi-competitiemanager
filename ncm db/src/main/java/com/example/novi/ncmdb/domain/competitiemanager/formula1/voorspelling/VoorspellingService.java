package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.springframework.stereotype.Service;

@Service
public class VoorspellingService {

    private final VoorspellingRepository voorspellingRepository;

    public VoorspellingService(VoorspellingRepository voorspellingRepository){
        this.voorspellingRepository = voorspellingRepository;
    }
}
