package com.springdatajpa.app.localizacao.domain.entity;

import com.springdatajpa.app.localizacao.domain.dtos.CidadeDTO;
import jakarta.persistence.*;
import lombok.Data;

//TODO: @Table -> é utilizando quando no nome da entidade é diferente da class.

@Entity
@Table(name = "tb_cidade")
@Data
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Long id;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "qtd_habitantes")
    private Long habitantes;

    public Cidade() {
        super();
    }

    public Cidade(CidadeDTO cidadeDTO) {
        this.id = cidadeDTO.getId();
        this.nome = cidadeDTO.getNome();
        this.habitantes = cidadeDTO.getHabitantes();
    }
}
