package com.gerenciamento.tarefa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.gerenciamento.tarefa.domain.entity.Cliente;
import com.gerenciamento.tarefa.domain.entity.Pedido;
import com.gerenciamento.tarefa.repository.Clientes;
import com.gerenciamento.tarefa.repository.Pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TarefaApplication {

	@GetMapping("/")
	public String helloWord() {
		return "Oi allyson";
	}

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos ) {
		return args -> {
			System.out.println("Salvando Cliente");
			// clientes.save( new Cliente("Allyson"));
			Cliente fulano = new Cliente("Allyson");
			clientes.save(fulano);

			Pedido p = new Pedido();
			p.setCliente(fulano);
		  p.setDataPedidd(LocalDate.now());
      p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

		  // Cliente cliente =	clientes.findClienteFetchPedido(fulano.getId());
			// System.out.println(cliente);
			// System.out.println(cliente.getPedidos());

		  pedidos.findByCliente(fulano).forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TarefaApplication.class, args);
	}

}
