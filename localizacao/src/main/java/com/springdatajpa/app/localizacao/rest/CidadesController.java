package com.springdatajpa.app.localizacao.rest;

import com.springdatajpa.app.localizacao.domain.dtos.CidadeDTO;
import com.springdatajpa.app.localizacao.domain.entity.Cidade;
import com.springdatajpa.app.localizacao.services.impl.CidadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/localizacao")
public class CidadesController {

    @Autowired
    private CidadeServiceImpl cidadeService;

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<CidadeDTO>> buscarCidadePeloNome(@PathVariable String nome){
        List<Cidade> listaCidadesEntidade = cidadeService.buscarCidadePorNome(nome);
        List<CidadeDTO> listaCidadesDTOs = listaCidadesEntidade.stream()
                .map(cidades -> new CidadeDTO(cidades)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaCidadesDTOs);
    }

    @GetMapping("/inicio/{letra}")
    public ResponseEntity<List<CidadeDTO>> buscarCidadePelaPrimeiraLetra(@PathVariable Character letra){
        List<Cidade> listaCidadesEntidade = cidadeService.buscarLikeInicio(letra);
        List<CidadeDTO> listaCidadesDTOs = listaCidadesEntidade.stream()
                .map(cidades -> new CidadeDTO(cidades)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaCidadesDTOs);
    }

    @GetMapping("/fim/{letra}")
    public ResponseEntity<List<CidadeDTO>> buscarCidadePelaUltimaLetra(@PathVariable Character letra){
        List<Cidade> listaCidadesEntidade = cidadeService.buscarLikeFim(letra);
        List<CidadeDTO> listaCidadesDTOs = listaCidadesEntidade.stream()
                .map(cidades -> new CidadeDTO(cidades)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaCidadesDTOs);
    }

    @GetMapping("/habitante/{quantidade}")
    public ResponseEntity<List<CidadeDTO>> buscarCidadePorHabitante(@PathVariable Long quantidade){
        List<Cidade> listaCidadesEntidade = cidadeService.buscarCidadePorHabitantes(quantidade);
        List<CidadeDTO> listaCidadesDTOs = listaCidadesEntidade.stream()
                .map(cidades -> new CidadeDTO(cidades)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaCidadesDTOs);
    }

    @PostMapping
    public ResponseEntity<CidadeDTO> salvarCidade(@RequestBody CidadeDTO cidadeDTO){
        Cidade novaCidade = cidadeService.salvar(cidadeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaCidade.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
