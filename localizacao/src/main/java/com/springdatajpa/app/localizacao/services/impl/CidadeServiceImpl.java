package com.springdatajpa.app.localizacao.services.impl;

import com.springdatajpa.app.localizacao.domain.dtos.CidadeDTO;
import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import com.springdatajpa.app.localizacao.repositories.CidadeRepository;
import com.springdatajpa.app.localizacao.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarCidadePorNome(String nome) {
        return cidadeRepository.findByNome(nome);
    }

    public List<Cidade> buscarLikeInicio(Character letra) {
        return cidadeRepository.findByNomeStartingWith(letra);
    }

    public List<Cidade> buscarLikeFim(Character letra) {
        return cidadeRepository.findByNomeEndingWith(letra);
    }

    public List<Cidade> buscarCidadePorHabitantes(Long habitante) {
        return cidadeRepository.findByHabitantes(habitante);
    }

    public Cidade salvar(CidadeDTO cidadeDTO){
        cidadeDTO.setId(null);
        Cidade novaCidade = new Cidade(cidadeDTO);
        return cidadeRepository.save(novaCidade);
    }
}
