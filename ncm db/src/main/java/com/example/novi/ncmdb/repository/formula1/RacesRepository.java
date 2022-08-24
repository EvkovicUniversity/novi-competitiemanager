package com.example.novi.ncmdb.repository.formula1;

import com.example.novi.ncmdb.model.formula1.Races;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacesRepository extends CrudRepository<Races, Long> {

    @Override
    Iterable<Races> findAllById(Iterable<Long> longs);
}
