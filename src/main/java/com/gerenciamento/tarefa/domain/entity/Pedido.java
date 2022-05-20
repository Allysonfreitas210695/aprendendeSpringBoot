package com.gerenciamento.tarefa.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
  private Integer id;
  private Cliente cliente;
  private LocalDate dataPedidd;
  private BigDecimal total;


  public Cliente getCliente() {
    return cliente;
  }

  public LocalDate getDataPedidd() {
    return dataPedidd;
  }

  public Integer getId() {
    return id;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setDataPedidd(LocalDate dataPedidd) {
    this.dataPedidd = dataPedidd;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }
}
