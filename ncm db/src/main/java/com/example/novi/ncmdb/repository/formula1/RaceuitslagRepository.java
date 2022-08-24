package com.example.novi.ncmdb.repository.formula1;

import com.example.novi.ncmdb.model.formula1.Raceuitslag;
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
