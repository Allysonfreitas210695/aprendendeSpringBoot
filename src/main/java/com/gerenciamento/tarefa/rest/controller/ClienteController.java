package com.gerenciamento.tarefa.rest.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Optional;

import com.gerenciamento.tarefa.domain.entity.Cliente;
import com.gerenciamento.tarefa.repository.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api")
public class ClienteController {

  @Autowired
  private Clientes clientes;

  @GetMapping("/clientes/{id}")
  @ResponseBody
  public ResponseEntity getClienteById(@PathVariable Integer id) {
    Optional<Cliente> cliente= clientes.findById(id);

    if(cliente.isPresent()){
      return ResponseEntity.ok(cliente.get());
    }

    return ResponseEntity.notFound().build();
  }
}
