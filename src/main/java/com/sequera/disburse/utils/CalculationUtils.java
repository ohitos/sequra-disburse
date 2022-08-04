package com.sequera.disburse.utils;

import java.math.BigDecimal;
import java.util.List;

import com.sequera.disburse.data.Order;
import lombok.experimental.UtilityClass;

import static com.sequera.disburse.utils.Constants.BIG_AMOUNT_FEE;
import static com.sequera.disburse.utils.Constants.BIG_FEE_PERCENTAGE;
import static com.sequera.disburse.utils.Constants.MEDIUM_FEE_PERCENTAGE;
import static com.sequera.disburse.utils.Constants.SMALL_AMOUNT_FEE;
import static com.sequera.disburse.utils.Constants.SMALL_FEE_PERCENTAGE;

@UtilityClass
public class CalculationUtils {

    public static BigDecimal getDisburse(List<Order> orders) {
        BigDecimal disburse = BigDecimal.ZERO;
        for (final Order order : orders) {
            if (SMALL_AMOUNT_FEE.compareTo(order.getAmount()) > 0) {
                disburse = disburse.add(SMALL_FEE_PERCENTAGE);
            } else if (SMALL_AMOUNT_FEE.compareTo(order.getAmount()) < 1 && BIG_AMOUNT_FEE.compareTo(order.getAmount()) > -1) {
                disburse = disburse.add(MEDIUM_FEE_PERCENTAGE);
            } else if (BIG_AMOUNT_FEE.compareTo(order.getAmount()) < 0) {
                disburse = disburse.add(BIG_FEE_PERCENTAGE);
            }
        }
        return disburse;
    }
}
