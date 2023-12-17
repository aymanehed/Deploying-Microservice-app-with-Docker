package org.sid.orderservice;

import org.sid.orderservice.Entities.Order;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductItemRepository;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.atomic.AtomicReference;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderRepository orderRepository,
							ProductItemRepository productItemRepository,

							InventoryRestClientService inventoryRestClientService) {
		Long id=0L;
		return args -> {
			for (int i = 0; i<20; i++){
			inventoryRestClientService.allProducts().forEach(p->{

					Order order = Order.builder()
							.id(id + 1)
							.productId(p.getId())
							.product(p)
							.build();
					orderRepository.save(order);
			});	}


		};
	}

}
