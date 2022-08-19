package com.example.novi.ncmdb.model.formula1.coureur;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoureurRepository extends CrudRepository<Coureur, Long> {

    @Override
    List<Coureur> findAll();

    @Override
    Optional<Coureur> findById(Long id);

    @Override
    <S extends Coureur> List<S> saveAll(Iterable<S> entities);
}