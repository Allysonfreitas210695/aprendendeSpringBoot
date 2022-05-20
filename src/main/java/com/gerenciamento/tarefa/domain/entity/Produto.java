package com.gerenciamento.tarefa.domain.entity;

import java.math.BigDecimal;

public class Produto {
  
  private Integer id;
  private String descricao;
  private BigDecimal preco_unitario;

  public Integer getId() {
    return id;
  }

  public String getDescricao() {
    return descricao;
  }

  public BigDecimal getPreco_unitario() {
    return preco_unitario;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setPreco_unitario(BigDecimal preco_unitario) {
    this.preco_unitario = preco_unitario;
  }
}
