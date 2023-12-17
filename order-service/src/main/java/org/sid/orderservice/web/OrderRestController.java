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

import java.util.List;

@RestController
public class OrderRestController {
    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, InventoryRestClientService inventoryRestClientService, CustomerRestClientService customerRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.inventoryRestClientService = inventoryRestClientService;

    }

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/orders")
    public List<Order> orderList() {
        List<Order> orderList = orderRepository.findAll();
        orderList.forEach(or -> {
            or.setProduct(inventoryRestClientService.productById(or.getProductId()));
            });
        return orderList;
    }
}