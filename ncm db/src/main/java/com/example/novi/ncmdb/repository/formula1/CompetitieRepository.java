package com.example.novi.ncmdb.repository.formula1;

import com.example.novi.ncmdb.model.formula1.Competitie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitieRepository extends CrudRepository<Competitie, Long> {

    @Override
    List<Competitie> findAll();

    @Override
    Optional<Competitie> findById(Long id);

    @Override
    <S extends Competitie> S save(S entity);

}
