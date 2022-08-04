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
public class Disburse {

    private int mechantId;
    private BigDecimal amount;
    private LocalDateTime completedAt;
}
