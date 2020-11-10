package pl.widokipracownia.widokipracownia;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

@SpringBootApplication
public class WidokiPracowniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WidokiPracowniaApplication.class, args);
//		// Create the Flyway instance and point it to the database
//		Flyway flyway = Flyway.configure().dataSource(
//				"jdbc:mysql://localhost:3306/widoki_db",
//				"root",
//				"root")
//				.baselineOnMigrate(true)
//				.load();
//
//		// Start the migration
//		flyway.migrate();
	}

}
