package com.gerenciamento.tarefa.repository;

import com.gerenciamento.tarefa.domain.entity.Item_Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Itens_Pedido extends JpaRepository<Item_Pedido, Integer>{
  
}