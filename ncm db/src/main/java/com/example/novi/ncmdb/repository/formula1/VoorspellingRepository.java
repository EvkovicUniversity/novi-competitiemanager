package com.example.novi.ncmdb.repository.formula1;

import com.example.novi.ncmdb.model.formula1.Voorspelling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoorspellingRepository extends CrudRepository<Voorspelling, Long> {


}
