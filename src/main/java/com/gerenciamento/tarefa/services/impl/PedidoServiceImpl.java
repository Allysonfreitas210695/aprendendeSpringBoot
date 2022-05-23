package com.gerenciamento.tarefa.services.impl;

import com.gerenciamento.tarefa.repository.Pedidos;
import com.gerenciamento.tarefa.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService{

  @Autowired
  private Pedidos pedidos;
}
