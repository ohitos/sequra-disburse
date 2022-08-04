package com.sequera.disburse.service;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.sequera.disburse.data.Order;
import com.sequera.disburse.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public void insert(Order entity) {
        if (Objects.nonNull(entity)) {
            repository.insert(entity);
        }
    }

    public List<Order> get(String merchantId) {
        List<Order> result;
        if (StringUtils.isNotEmpty(merchantId)) {
            result = repository.get(merchantId);
        } else {
            result = repository.getAll();
        }
        return result;
    }
}
