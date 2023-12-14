package org.sid.orderservice.web;

import org.sid.orderservice.Entities.Order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductItemRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, InventoryRestClientService inventoryRestClientService, CustomerRestClientService customerRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.inventoryRestClientService = inventoryRestClientService;
        this.customerRestClientService = customerRestClientService;
    }

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private InventoryRestClientService inventoryRestClientService;
    private CustomerRestClientService customerRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrderByID(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(productItem -> {
            Product product = inventoryRestClientService.productById(productItem.getProductId());
            productItem.setProduct(product);
        });
        return order;
    }
}
