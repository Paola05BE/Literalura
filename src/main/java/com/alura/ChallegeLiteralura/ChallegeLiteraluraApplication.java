package com.alura.ChallegeLiteralura;

import com.alura.ChallegeLiteralura.principal.Principal;
import com.alura.ChallegeLiteralura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallegeLiteraluraApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(ChallegeLiteraluraApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();

	}
}
