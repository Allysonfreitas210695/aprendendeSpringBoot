package com.gerenciamento.tarefa.rest.controller;

import java.util.Optional;
import com.gerenciamento.tarefa.domain.entity.Cliente;
import com.gerenciamento.tarefa.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/cliente")
  @ResponseBody
  public ResponseEntity save(@RequestBody Cliente cliente){
    Cliente clienteSalvo = clientes.save(cliente);

    return ResponseEntity.ok(clienteSalvo);
  }

  @DeleteMapping("/cliente/{id}")
  @ResponseBody
  public ResponseEntity delete(@PathVariable Integer id){
    Optional<Cliente> clienteDeleta = clientes.findById(id);

    if(clienteDeleta.isPresent()){
      clientes.delete(clienteDeleta.get());
      return ResponseEntity.noContent().build();
    }

    return ResponseEntity.noContent().build();
  }


}
