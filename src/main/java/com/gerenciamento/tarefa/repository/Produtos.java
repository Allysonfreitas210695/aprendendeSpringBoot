package com.gerenciamento.tarefa.repository;

import com.gerenciamento.tarefa.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer>{
  
}
