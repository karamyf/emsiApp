package ma.emsi.customerservice;

import ma.emsi.customerservice.entities.Customer;
import ma.emsi.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("karam").email("karam@gmail.com").build(),
					Customer.builder().name("youssef").email("youssef@gmail.com").build(),
					Customer.builder().name("karam youssef").email("youssef.karam@gmail.com").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
