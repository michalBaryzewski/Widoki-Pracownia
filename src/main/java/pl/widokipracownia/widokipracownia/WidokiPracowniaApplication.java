package pl.widokipracownia.widokipracownia;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WidokiPracowniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WidokiPracowniaApplication.class, args);

	}
}
