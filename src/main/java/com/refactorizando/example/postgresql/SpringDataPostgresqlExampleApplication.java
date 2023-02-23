package com.refactorizando.example.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringDataPostgresqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataPostgresqlExampleApplication.class, args);
	}

}
