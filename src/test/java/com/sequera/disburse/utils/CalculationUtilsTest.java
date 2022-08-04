package com.sequera.disburse.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sequera.disburse.data.Order;

import static com.sequera.disburse.utils.Constants.BIG_FEE_PERCENTAGE;
import static com.sequera.disburse.utils.Constants.MEDIUM_FEE_PERCENTAGE;
import static com.sequera.disburse.utils.Constants.SMALL_FEE_PERCENTAGE;
import static org.springframework.test.util.AssertionErrors.assertEquals;


public class CalculationUtilsTest {

    @Test
    public void calculate_disburse_when_amount_is_small() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().amount(BigDecimal.ZERO).build());

        BigDecimal result = CalculationUtils.getDisburse(orderList);

        assertEquals("Result should be equals", SMALL_FEE_PERCENTAGE, result);
    }

    @Test
    public void calculate_disburse_when_amount_is_medium_low() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().amount(BigDecimal.valueOf(50)).build());

        BigDecimal result = CalculationUtils.getDisburse(orderList);

        assertEquals("Result should be equals", MEDIUM_FEE_PERCENTAGE, result);
    }

    @Test
    public void calculate_disburse_when_amount_is_medium_high() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().amount(BigDecimal.valueOf(300)).build());

        BigDecimal result = CalculationUtils.getDisburse(orderList);

        assertEquals("Result should be equals", MEDIUM_FEE_PERCENTAGE, result);
    }

    @Test
    public void calculate_disburse_when_amount_is_big() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().amount(BigDecimal.valueOf(400)).build());

        BigDecimal result = CalculationUtils.getDisburse(orderList);

        assertEquals("Result should be equals", BIG_FEE_PERCENTAGE, result);
    }

    @Test
    public void calculate_disburse_when_amounts_has_all_types() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.builder().amount(BigDecimal.ZERO).build());
        orderList.add(Order.builder().amount(BigDecimal.valueOf(60)).build());
        orderList.add(Order.builder().amount(BigDecimal.valueOf(400)).build());

        BigDecimal result = CalculationUtils.getDisburse(orderList);

        assertEquals("Result should be equals", 0, result.compareTo(BigDecimal.valueOf(2.80)));
    }
}
