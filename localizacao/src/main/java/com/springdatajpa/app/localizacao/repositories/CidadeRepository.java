package com.springdatajpa.app.localizacao.repositories;

import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByNome(String nome);

    @Query(" select c from Cidade c where upper(c.nome) like upper(?1) ")
    List<Cidade> findByNomeLike(String nome);

    List<Cidade> findByHabitantes(Long habitantes);

    List<Cidade> findByNomeStartingWith(String nome);

    List<Cidade> findByNomeEndingWith(String nome);

    List<Cidade> findByHabitantesLessThan(Long habitantes);

    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    List<Cidade> findByHabitantesLessThanEqual(Long habitantes);

    List<Cidade> findByHabitantesLessThanEqualAndNome(Long habitantes, String nome);

    @Query(nativeQuery = true, value = "select * from tb_cidade as c where c.nome =:nome ")
    List<Cidade> findByNomeSqlNativo(@Param("nome") String nome);
}
