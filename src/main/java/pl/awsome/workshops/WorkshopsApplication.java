package pl.awsome.workshops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WorkshopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopsApplication.class, args);
	}

}
