package com.example.novi.ncmdb.repository;

import com.example.novi.ncmdb.domain.Coureur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoureurRepository extends CrudRepository<Coureur, Long> {

    @Override
    List<Coureur> findAll();

    @Override
    Optional<Coureur> findById(Long aLong);
}