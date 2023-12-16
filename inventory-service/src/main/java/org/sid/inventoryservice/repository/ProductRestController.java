package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductRestController {
        private ProductRepository productRepository;
        public ProductRestController(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }
        @GetMapping("/products")
        public List<Product> ProductList(){
            return productRepository.findAll();
        }
        @GetMapping("/products/{id}")
        public Product customerById(@PathVariable Long id){
            return productRepository.findById(id).get();
        }
    }

