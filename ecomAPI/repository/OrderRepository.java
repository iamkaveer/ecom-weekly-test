package com.ecomapi.ecomAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomapi.ecomAPI.model.Order;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from tbl_order where order_id =:id",nativeQuery = true)
    Order getOrderById(Integer id);
}
