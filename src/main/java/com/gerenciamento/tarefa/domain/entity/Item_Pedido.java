package com.gerenciamento.tarefa.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item_pedido")
public class Item_Pedido {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name="produto_id")
  private Produto produto;

  @ManyToOne
  @JoinColumn(name="pedido_id")
  private Pedido pedido;

  @Column(name="qtd")
  private Integer qtd;
}
