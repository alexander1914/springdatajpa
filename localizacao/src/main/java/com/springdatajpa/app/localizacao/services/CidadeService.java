package com.springdatajpa.app.localizacao.services;

import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import java.util.List;

public interface CidadeService {
    List<Cidade> buscarCidadePorNome(String nome);
    List<Cidade> buscarCidadePorHabitantes(Long habitante);
    List<Cidade> buscarLikeInicio(Character character);
    List<Cidade> buscarLikeFim(Character letra);
}
