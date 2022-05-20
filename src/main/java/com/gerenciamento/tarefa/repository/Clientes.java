package com.gerenciamento.tarefa.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.gerenciamento.tarefa.domain.entity.Cliente;

import org.h2.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Clientes {

  private static String INSERT = "insert into cliente (nome) values (?)";
  private String SELECT_ALL = "select * from cliente";
  private static String UPDATED = "update cliente set nome = ? where id = ?";
  private static String DELETE = "delete from cliente where id = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  public Cliente salva(Cliente cliente) {
    jdbcTemplate.update(INSERT, new Object[] { cliente.getNome() });
    return cliente;
  }

  public Cliente atualizarCliente(Cliente cliente){
    jdbcTemplate.update(UPDATED, new Object[] { cliente.getNome(), cliente.getId() });

    return cliente;
  }

  public void deleteCliente(Cliente cliente){
    deleteCliente(cliente.getId());
  }

  public void deleteCliente(Integer id){
    jdbcTemplate.update(DELETE, new Object[] { id });
  }

  public List<Cliente> buscarPorNome(String nome){
    return jdbcTemplate.query(
      SELECT_ALL.concat(" where nome like ?"),
      new Object[] { "%" + nome + "%"},
      obterClienteMapper());
  }

  private RowMapper<Cliente> obterClienteMapper(){
    return new RowMapper<Cliente>() {
      @Override
      public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
        Integer id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        return new Cliente(id, nome);
      }
    };
  }


  public List<Cliente> obterTodos(){
    return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
  }
}
