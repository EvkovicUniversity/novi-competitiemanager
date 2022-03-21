package com.example.novi.ncmdb.domain.authenticatie.gebruiker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long> {
}
