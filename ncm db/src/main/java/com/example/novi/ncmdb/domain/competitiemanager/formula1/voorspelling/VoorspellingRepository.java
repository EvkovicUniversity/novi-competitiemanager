package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoorspellingRepository extends CrudRepository<Voorspelling, Long> {
}
