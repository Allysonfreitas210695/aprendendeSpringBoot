package com.gerenciamento.tarefa;

import java.util.List;

import com.gerenciamento.tarefa.domain.entity.Cliente;
import com.gerenciamento.tarefa.repository.Clientes;
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
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			System.out.println("Salvando Cliente");
			clientes.save( new Cliente("Allyson"));
			clientes.save(new Cliente("Bruno"));

			System.out.println("Listando todos Clientes");
			List<Cliente> todosClientes = clientes.encontraPorNome("All");
			todosClientes.forEach(System.out::println);

			

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TarefaApplication.class, args);
	}

}
