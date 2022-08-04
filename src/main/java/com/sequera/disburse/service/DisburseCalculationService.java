package com.sequera.disburse.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.sequera.disburse.data.Disburse;
import com.sequera.disburse.data.Order;
import com.sequera.disburse.utils.CalculationUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DisburseCalculationService {

    private final OrderService orderService;
    private final DisburseService disburseService;


    public void calculation() {

        List<Order> orderList = orderService.getNotCompleted();
        if (BooleanUtils.isFalse(CollectionUtils.isEmpty(orderList))) {
            Map<Integer, List<Order>> orderMap =
                    orderList.stream().filter(Objects::nonNull).filter(order -> Objects.isNull(order.getCompletedAt()))
                            .collect(Collectors.groupingBy(Order::getMechantId));

            BigDecimal disburseAmount;
            for (Map.Entry<Integer, List<Order>> entry : orderMap.entrySet()) {
                disburseAmount = CalculationUtils.getDisburse(entry.getValue());

                Disburse disburse = Disburse.builder().amount(disburseAmount).completedAt(LocalDateTime.now()).mechantId(entry.getKey()).build();

                disburseService.insert(disburse);
                orderService.markAsCompleted(entry.getValue());
            }
        }
    }
}
