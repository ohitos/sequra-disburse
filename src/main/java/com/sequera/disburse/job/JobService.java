package com.sequera.disburse.job;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sequera.disburse.service.DisburseCalculationService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JobService {

    private final DisburseCalculationService disburseCalculationService;

    /**
     * Scheduled each first day of the week
     * 0 means Monday
     */
    @Scheduled(cron = "* * * * * 0")
    public void disburseCalculation() {
        disburseCalculationService.calculation();
    }
}
