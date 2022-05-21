package com.gerenciamento.tarefa.repository;

import java.util.List;

import com.gerenciamento.tarefa.domain.entity.Cliente;
import com.gerenciamento.tarefa.domain.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
  
  List<Pedido> findByCliente(Cliente cliente);
}
