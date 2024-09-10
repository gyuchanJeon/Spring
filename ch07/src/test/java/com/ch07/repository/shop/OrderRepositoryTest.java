package com.ch07.repository.shop;

import com.ch07.entity.shop.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Test
    public void selectOrders(){
        List<Order> orders = orderRepository.selectOrders();
        System.out.println(orders);
    }

    @Test
    public void selectOrder() {
    }


}
