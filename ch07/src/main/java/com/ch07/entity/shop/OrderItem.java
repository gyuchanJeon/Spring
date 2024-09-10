package com.ch07.entity.shop;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString(exclude = "order")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "shop_orderitem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int count;
}