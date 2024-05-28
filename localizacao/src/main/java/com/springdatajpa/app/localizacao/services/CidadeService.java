package com.springdatajpa.app.localizacao.services;

import com.springdatajpa.app.localizacao.domain.dtos.CidadeDTO;
import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import java.util.List;

public interface CidadeService {
    List<Cidade> buscarCidadePorNome(String nome);
    List<Cidade> buscarCidadePorHabitantes(Long habitante);
    List<Cidade> buscarNomeInicio(String nome);
    List<Cidade> buscarNomeFim(String nome);
    List<Cidade> buscarNomeLike(String nome);
    Cidade salvar(CidadeDTO cidadeDTO);
    List<Cidade> buscarOsMenoresHabitantes(Long habitantes);
    List<Cidade> buscarOsMaioresHabitantes(Long habitantes);
    List<Cidade> buscarOsMenoresIgualHabitantes(Long habitantes);
    List<Cidade> buscarOsMenoresIgualHabitantesNome(Long habitantes, String nome);
    List<Cidade> filtroDinamico(Cidade cidade);
    List<Cidade> buscarCidadePorNomeQueryNative(String nome);
}
