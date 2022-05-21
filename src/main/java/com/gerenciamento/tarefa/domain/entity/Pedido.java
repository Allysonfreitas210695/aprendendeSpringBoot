package com.gerenciamento.tarefa.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pedido")
public class Pedido {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @Column(name = "data_pedido")
  private LocalDate dataPedido;
  
  @Column(name = "total", precision = 20, scale = 2)
  private BigDecimal total;

  @OneToMany(mappedBy = "pedido")
  private List<Item_Pedido> itens;

  public List<Item_Pedido> getItens() {
    return itens;
  }

  public void setItens(List<Item_Pedido> itens) {
    this.itens = itens;
  }
  
  public Cliente getCliente() {
    return cliente;
  }

  public LocalDate getDataPedido() {
    return dataPedido;
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

  public void setDataPedidd(LocalDate dataPedido) {
    this.dataPedido = dataPedido;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "{ id: " + id + ", total: " + total + " }";
  }
}
