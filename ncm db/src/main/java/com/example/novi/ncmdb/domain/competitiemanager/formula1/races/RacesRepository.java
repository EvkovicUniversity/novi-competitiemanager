package com.example.novi.ncmdb.domain.competitiemanager.formula1.races;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacesRepository extends CrudRepository<Races, Long> {

    @Override
    Iterable<Races> findAllById(Iterable<Long> longs);
}
