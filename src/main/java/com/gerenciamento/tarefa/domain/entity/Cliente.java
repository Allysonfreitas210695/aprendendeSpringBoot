package com.gerenciamento.tarefa.domain.entity;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(name = "nome", length = 100)
  private String nome;

  @Column(name = "cpf")
  private String cpf;

  @JsonIgnore
  @OneToMany(mappedBy = "cliente", fetch= FetchType.LAZY)
  private Set<Pedido> pedidos;

  public void setPedidos(Set<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  public Set<Pedido> getPedidos() {
    return pedidos;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Cliente(){

  }

  public Cliente(String nome){
    this.nome = nome;
  }

  public Cliente(Integer id, String nome){
    this.nome = nome;
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @Override
  public String toString() {
    return "Cliente{" +
            "ID=" + this.id +
            ", NOME=" + this.nome + '\'' +
            "}";
  }
}
