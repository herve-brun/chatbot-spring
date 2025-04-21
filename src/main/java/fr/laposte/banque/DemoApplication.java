package fr.laposte.banque;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

// This annotation indicates that the class is a Spring Boot application and should be automatically configured.
@SpringBootApplication
@EnableAdminServer
public class DemoApplication {

    // The main method is where the Spring Boot application starts.
	public static void main(String[] args) {
        // SpringApplication.run() is used to start the Spring Boot application with the specified arguments.
		SpringApplication.run(DemoApplication.class, args);
	}

}
