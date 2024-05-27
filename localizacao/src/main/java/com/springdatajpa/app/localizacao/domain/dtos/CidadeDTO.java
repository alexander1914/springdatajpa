package com.springdatajpa.app.localizacao.domain.dtos;

import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import lombok.Data;

@Data
public class CidadeDTO {
    private Long id;
    private String nome;
    private Long habitantes;

    public CidadeDTO() {
        super();
    }

    public CidadeDTO(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
        this.habitantes = cidade.getHabitantes();
    }
}
