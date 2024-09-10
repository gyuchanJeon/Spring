package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.QOrder;
import com.ch07.repository.shop.custom.OrderRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QOrder qOrder = QOrder.order;

    @Override
    public List<Order> selectOrders(){
        return queryFactory
                .select(qOrder)
                .from(qOrder)
                .fetch();
    }

    @Override
    public Order selectOrder(int orderId){
        return queryFactory
                .selectFrom(qOrder)
                .where(qOrder.orderId.eq(orderId))
                .fetchOne();
    }


}
