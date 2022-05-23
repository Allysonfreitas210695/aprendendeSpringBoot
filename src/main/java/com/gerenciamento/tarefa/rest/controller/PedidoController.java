package com.gerenciamento.tarefa.rest.controller;

import com.gerenciamento.tarefa.repository.Pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidoController {
  
  @Autowired
  private Pedidos pedidos;

  
}
