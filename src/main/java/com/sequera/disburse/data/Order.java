package com.sequera.disburse.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Order {

    private String id;
    private int mechantId;
    private int shopperId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
}
