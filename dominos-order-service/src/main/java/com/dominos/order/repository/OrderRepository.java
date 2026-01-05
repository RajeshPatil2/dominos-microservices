package com.dominos.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dominos.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
