package com.gerenciamento.tarefa.repository;

import java.util.List;

import com.gerenciamento.tarefa.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Clientes extends JpaRepository<Cliente, Integer>{

  List<Cliente> findByNomeLike(String nome);

  @Query(value = "select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
  List<Cliente> encontraPorNome(@Param("nome") String nome);

  boolean existsByNome(String nome);

  @Query("select c from Cliente c left join fetch c.pedidos where c.id = :id")
  Cliente findClienteFetchPedido(@Param("id") Integer id);
}
