package com.sequera.disburse.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String id;
    private int mechantId;
    private int shopperId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
}
