package com.ch07.repository.shop;

import com.ch07.entity.shop.OrderItem;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
