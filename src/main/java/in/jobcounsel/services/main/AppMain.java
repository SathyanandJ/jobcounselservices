package in.jobcounsel.services.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "in.jobcounsel.services")
@EnableJpaRepositories(basePackages = {"in.jobcounsel.services"})
@EntityScan(basePackages = {"in.jobcounsel.services"})
public class AppMain {
	
	public static void main(String args[]) {
		SpringApplication.run(AppMain.class, args);
	}
}
