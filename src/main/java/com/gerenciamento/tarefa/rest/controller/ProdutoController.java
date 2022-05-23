package com.gerenciamento.tarefa.rest.controller;

import java.util.List;

import com.gerenciamento.tarefa.domain.entity.Produto;
import com.gerenciamento.tarefa.repository.Produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ProdutoController {
  
  @Autowired
  private Produtos produtos;

  @GetMapping("/produtos/{id}")
  public Produto getProdutoById(@PathVariable Integer id) {
    return produtos
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not found"));
  }

  @PostMapping("/produtos")
  @ResponseStatus(HttpStatus.CREATED)
  public Produto save(@RequestBody Produto produto){
    return produtos.save(produto);
  }

  @DeleteMapping("/produtos/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    produtos.findById(id)
            .map( produto -> { 
              produtos.delete(produto);
              return produto;
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not found"));
  }

  @PutMapping("/produtos/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(
      @PathVariable Integer id,
      @RequestBody Produto produto) {

    produtos
        .findById(id)
        .map(produtoExistente -> {
          produto.setId(produtoExistente.getId());
          produtos.save(produto);

          return ResponseEntity.noContent().build();
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not found"));
  }

  @GetMapping("/produtos")
  public List<Produto> find(Produto filtro) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

    Example example = Example.of(filtro, matcher);
    return produtos.findAll(example);
  }

}
