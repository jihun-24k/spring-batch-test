package com.ll.exam.springbatchtest.app.order.repository;

import com.ll.exam.springbatchtest.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}