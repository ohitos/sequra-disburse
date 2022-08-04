package com.sequera.disburse.utils;

import java.math.BigDecimal;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

    public static final BigDecimal SMALL_AMOUNT_FEE = BigDecimal.valueOf(50);
    public static final BigDecimal BIG_AMOUNT_FEE = BigDecimal.valueOf(300);

    public static final BigDecimal SMALL_FEE_PERCENTAGE = BigDecimal.ONE;
    public static final BigDecimal MEDIUM_FEE_PERCENTAGE = BigDecimal.valueOf(0.95);
    public static final BigDecimal BIG_FEE_PERCENTAGE = BigDecimal.valueOf(0.85);
}
