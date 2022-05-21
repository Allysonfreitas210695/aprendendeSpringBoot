package com.gerenciamento.tarefa;

import com.gerenciamento.tarefa.domain.entity.Cliente;
import com.gerenciamento.tarefa.repository.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TarefaApplication {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
		return args -> {
			clientes.save(new Cliente("allyson"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TarefaApplication.class, args);
	}
}
