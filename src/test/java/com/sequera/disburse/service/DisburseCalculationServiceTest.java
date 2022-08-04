package com.sequera.disburse.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sequera.disburse.data.Order;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DisburseCalculationServiceTest {

    @InjectMocks
    private DisburseCalculationService service;

    @Mock
    private OrderService orderService;
    @Mock
    private DisburseService disburseService;

    @Test
    public void calculate_when_there_is_no_orders(){

        when(orderService.getNotCompleted()).thenReturn(null);

        service.calculation();

        verify(orderService, times(1)).getNotCompleted();
        verify(disburseService, never()).insert(any());
        verify(orderService, never()).markAsCompleted(any());
    }

    @Test
    public void calculate_when_orders_are_already_completed(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().completedAt(LocalDateTime.now()).mechantId(123).amount(BigDecimal.ZERO).build());

        when(orderService.getNotCompleted()).thenReturn(orderList);

        service.calculation();

        verify(orderService, times(1)).getNotCompleted();
        verify(disburseService, never()).insert(any());
        verify(orderService, never()).markAsCompleted(any());
    }

    @Test
    public void calculate_when_orders_are_correct(){
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().mechantId(123).amount(BigDecimal.ZERO).build());

        when(orderService.getNotCompleted()).thenReturn(orderList);

        service.calculation();

        verify(orderService, times(1)).getNotCompleted();
        verify(disburseService, times(1)).insert(any());
        verify(orderService, times(1)).markAsCompleted(orderList);
    }
}
