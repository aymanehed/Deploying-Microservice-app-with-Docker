package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			Random random = new Random();
			productRepository.saveAll(List.of(
					 Product.builder()
							 .name("Ord HP 879")
							 .price(1200+Math.random()*10000)
							 .quantity(1+random.nextInt(200)).build(),
					 Product.builder().name("Imprimante Epson").price(1500).quantity(150).build(),
					 Product.builder().name("Smartphone Samsung").price(2600).quantity(50).build()
			));
			productRepository.findAll().forEach(System.out::println);
		};
	}
}
