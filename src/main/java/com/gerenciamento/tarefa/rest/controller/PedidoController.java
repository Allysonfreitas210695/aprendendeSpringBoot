package com.gerenciamento.tarefa.rest.controller;

import com.gerenciamento.tarefa.domain.entity.Pedido;
import com.gerenciamento.tarefa.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidoController {
  
  @Autowired
  private PedidoService pedidos;


}
