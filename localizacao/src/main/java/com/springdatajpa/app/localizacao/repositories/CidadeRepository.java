package com.springdatajpa.app.localizacao.repositories;

import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByNome(String nome);
    List<Cidade> findByHabitantes(Long habitantes);
    List<Cidade> findByNomeStartingWith(Character character);
    List<Cidade> findByNomeEndingWith(Character character);
}
