package org.sid.orderservice.model;

import jakarta.persistence.Transient;
import lombok.Data;

@Data
public class Customer {
    @Transient
    private Long id;
    private String name;
    @Transient
    private String email;
}
