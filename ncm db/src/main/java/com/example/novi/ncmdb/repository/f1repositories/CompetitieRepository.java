package com.example.novi.ncmdb.repository.f1repositories;

import com.example.novi.ncmdb.domain.Formula1.F1Competitie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompetitieRepository extends CrudRepository<F1Competitie, Long> {

    @Override
    List<F1Competitie> findAll();

    @Override
    Optional<F1Competitie> findById(Long aLong);

    @Override
    <S extends F1Competitie> S save(S entity);
}
