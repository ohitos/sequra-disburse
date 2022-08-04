package com.sequera.disburse.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    public void markAsCompleted(List<Order> orderList){
        LocalDateTime localDateTime = LocalDateTime.now();
        if(BooleanUtils.isFalse(CollectionUtils.isEmpty(orderList))) {
            for (final Order order : orderList) {
                order.setCompletedAt(localDateTime);
                repository.put(order);
            }
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

    public List<Order> getNotCompleted() {
        return repository.getAllNotCompleted();
    }
}
