package com.gerenciamento.tarefa.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.gerenciamento.tarefa.domain.entity.Cliente;

import org.h2.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Clientes {

  private String SELECT_ALL = "select * from cliente";
  private static String UPDATED = "update cliente set nome = ? where id = ?";
  private static String DELETE = "delete from cliente where id = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private EntityManager entityManager;
  
  @Transactional
  public Cliente salva(Cliente cliente) {
    entityManager.persist(cliente);
    return cliente;
  }

  @Transactional
  public Cliente atualizarCliente(Cliente cliente){
    entityManager.merge(cliente);

    return cliente;
  }

  @Transactional
  public void deleteCliente(Cliente cliente){
    if(!entityManager.contains(cliente)){
      cliente = entityManager.merge(cliente);
    }
    entityManager.remove(cliente);
  }

  @Transactional
  public void deleteCliente(Integer id){
    Cliente cliente = entityManager.find(Cliente.class, id);
    deleteCliente(cliente);
  }

  @Transactional(readOnly = true)
  public List<Cliente> buscarPorNome(String nome){
    String jpql = " select c from Cliente c where c.nome like :nome";
    TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
    query.setParameter("nome", "%" + nome + "%");
    return query.getResultList();
  }


  @Transactional(readOnly = true)
  public List<Cliente> obterTodos(){
    return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
  }
}
