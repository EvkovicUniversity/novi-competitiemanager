package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RaceuitslagRepository extends CrudRepository<Raceuitslag, String> {

    @Override
    List<Raceuitslag> findAll();

    @Override
    Optional<Raceuitslag> findById(String id);

}
