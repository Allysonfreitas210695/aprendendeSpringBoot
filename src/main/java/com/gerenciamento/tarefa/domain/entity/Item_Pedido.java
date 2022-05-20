package com.gerenciamento.tarefa.domain.entity;

import java.io.ObjectInputStream.GetField;

public class Item_Pedido {
  private Integer id;
  private Produto produto;
  private Pedido pedido;
  private Integer qtd;

  public Integer getId() {
    return id;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public Produto getProduto() {
    return produto;
  }

  public Integer getQtd() {
    return qtd;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public void setQtd(Integer qtd) {
    this.qtd = qtd;
  }
}
