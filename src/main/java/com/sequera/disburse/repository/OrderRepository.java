package com.sequera.disburse.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sequera.disburse.data.Order;

@Repository
public interface OrderRepository {

    void insert(Order entity);
    void put(Order entity);
    List<Order> get(String merchantId);
    List<Order> getAll();

    List<Order> getAllNotCompleted();
}
