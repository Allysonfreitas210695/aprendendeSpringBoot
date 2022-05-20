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
			Cliente cliente = new Cliente();
			cliente.setNome("Allyson");
			clientes.salva(cliente);

			Cliente cliente2 = new Cliente();
			cliente2.setNome("Bruno");
			clientes.salva(cliente2);

			System.out.println("Listando todos Clientes");
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizado Clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " Atualizado");
				clientes.atualizarCliente(c);
			});

			System.out.println("Listando todos Clientes");
			todosClientes.forEach(System.out::println);

			System.out.println("Pegando Cliente");
			clientes.buscarPorNome("All").forEach(System.out::println);
			;

			System.out.println("Deletando Clientes");
			clientes.obterTodos().forEach(c -> {
				clientes.deleteCliente(c);
			});
			

			todosClientes = clientes.obterTodos();

			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum Cliente encontrado");
			} else {
				todosClientes.forEach(System.out::println);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TarefaApplication.class, args);
	}

}
