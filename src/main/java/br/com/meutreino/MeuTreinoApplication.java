package br.com.meutreino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MeuTreinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuTreinoApplication.class, args);
	}

}
