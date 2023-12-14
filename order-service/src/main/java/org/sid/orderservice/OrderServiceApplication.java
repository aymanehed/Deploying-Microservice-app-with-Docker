package org.sid.orderservice;

import org.sid.orderservice.Entities.Order;
import org.sid.orderservice.Entities.ProductItem;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductItemRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderRepository orderRepository,
							ProductItemRepository productItemRepository,
							CustomerRestClientService customerRestClientService,
							InventoryRestClientService inventoryRestClientService) {
		return args -> {
			List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList(); // puisqu'on utilise page model on doit avoir le contenu
			List<Product> products = inventoryRestClientService.allProducts().getContent().stream().toList();


			Random random = new Random();
			Long customerId = 1L;
			Customer customer = customerRestClientService.customerById(customerId);
			for(int i = 0; i < 20; i++) {
				Order order = Order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random() > 0.5 ? OrderStatus.PENDING : OrderStatus.CREATED)
						.createdAt(new Date())
						.build();
				Order savedOrder = orderRepository.save(order);
				for (int j = 0; j < random.nextInt(3) + 1; j++) {
					if(Math.random()>0.70){
						ProductItem productItem = ProductItem.builder()
								.order(savedOrder)
								.price(products.get(j).getPrice())
								.quantity(1+random.nextInt(10))
								.discount(Math.random())
								.productId(products.get(j).getId())
								.build();
						productItemRepository.save(productItem);
					}
				}
			}
		};
	}


}
