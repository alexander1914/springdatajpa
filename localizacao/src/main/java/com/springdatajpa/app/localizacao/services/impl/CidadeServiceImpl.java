package com.springdatajpa.app.localizacao.services.impl;

import com.springdatajpa.app.localizacao.domain.dtos.CidadeDTO;
import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import com.springdatajpa.app.localizacao.repositories.CidadeRepository;
import com.springdatajpa.app.localizacao.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarCidadePorNome(String nome) {
        return cidadeRepository.findByNome(nome);
    }

    public List<Cidade> buscarNomeInicio(String nome) {
        return cidadeRepository.findByNomeStartingWith(nome);
    }

    public List<Cidade> buscarNomeFim(String nome) {
        return cidadeRepository.findByNomeEndingWith(nome);
    }

    public List<Cidade> buscarNomeLike(String nome){
        return cidadeRepository.findByNomeLike(nome);
    }

    public List<Cidade> buscarCidadePorHabitantes(Long habitante) {
        return cidadeRepository.findByHabitantes(habitante);
    }

    public Cidade salvar(CidadeDTO cidadeDTO){
        cidadeDTO.setId(null);
        Cidade novaCidade = new Cidade(cidadeDTO);
        return cidadeRepository.save(novaCidade);
    }

    public List<Cidade> buscarOsMenoresHabitantes(Long habitantes){
        return cidadeRepository.findByHabitantesLessThan(habitantes);
    }

    public List<Cidade> buscarOsMaioresHabitantes(Long habitantes){
        return cidadeRepository.findByHabitantesGreaterThan(habitantes);
    }

    public List<Cidade> buscarOsMenoresIgualHabitantes(Long habitantes){
        return cidadeRepository.findByHabitantesLessThanEqual(habitantes);
    }

    public List<Cidade> buscarOsMenoresIgualHabitantesNome(Long habitantes, String nome) {
        return cidadeRepository.findByHabitantesLessThanEqualAndNome(habitantes, nome);
    }

    public List<Cidade> filtroDinamico(Cidade cidade){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase();
        Example<Cidade> example = Example.of(cidade, matcher);
        return cidadeRepository.findAll(example);
    }

    //TODO: Ao implementar o service com a Spec o findAll não tinha com o parametro com Spec

    public List<Cidade> buscarCidadePorNomeQueryNative(String nome){
        return cidadeRepository.findByNomeSqlNativo(nome);
    }
}
