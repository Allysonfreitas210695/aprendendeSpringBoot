package com.gerenciamento.tarefa.repository;

import com.gerenciamento.tarefa.domain.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
  
}
