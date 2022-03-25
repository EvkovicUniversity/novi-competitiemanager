package com.example.novi.ncmdb.domain.competitiemanager.gebruikers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long> {

    @Override
    <S extends Gebruiker> S save(S entity);
}