package com.alex.tgbotproject.controllers;

import com.alex.tgbotproject.service.StatsService;
import com.alex.tgbotproject.service.SumIncomeUserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor

public class StatisticController {
    private final StatsService statsService;
    private final SumIncomeUserService sumIncomeUserService;

    @GetMapping("/getStats")
    @ApiOperation(value = "Получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutIncomesThatGreater(@RequestParam(value = "amount") BigDecimal amount) {
        return statsService.getCountOfIncomesThatGreater(amount);
    }

    @GetMapping("/getSumIncome")
    @ApiOperation(value = "Получение суммы дохода определенного пользователя")
    public long getSumtIncome (@RequestParam(value = "userId") BigDecimal userId){
        return sumIncomeUserService.getSumIncomeUser(userId);
    }
}
