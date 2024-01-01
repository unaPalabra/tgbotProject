package com.alex.tgbotproject.controllers;

import com.alex.tgbotproject.service.StatsService;
import com.alex.tgbotproject.service.SumIncomeUserService;
import com.alex.tgbotproject.service.SumSpendUserService;
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
    private final SumSpendUserService sumSpendUserService;

    @GetMapping("/getStats")
    @ApiOperation(value = "Получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutIncomesThatGreater(@RequestParam(value = "amount") BigDecimal amount) {
        return statsService.getCountOfIncomesThatGreater(amount);
    }

    @GetMapping("/getSumIncome")
    @ApiOperation(value = "Получение суммы дохода определенного пользователя")
    public long getSumIncome (@RequestParam(value = "userId") Long userId){
        return sumIncomeUserService.getSumIncomeUser(userId);
    }

    @GetMapping("/getSumSpend")
    @ApiOperation(value = "Получение суммы расходов определенного пользователя")
    public long getSumSpend (@RequestParam(value = "userId") Long userId){
        return sumSpendUserService.getSumSpendUser(userId);
    }
}
