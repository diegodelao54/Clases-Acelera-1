package com.enyoi.orders.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "client_id")
    private String clientId;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
}
