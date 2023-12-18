package com.alex.tgbotproject.controllers;

import com.alex.tgbotproject.dto.ValuteCursOnDate;
import com.alex.tgbotproject.service.CentralRussianBankService;
import com.alex.tgbotproject.service.StatsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatsService statsService;

    @GetMapping("/getCurrencies")
    @ApiOperation(value = "Получение курса всех валют на текущий день")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getCurrency/{code}")
    @ApiOperation(value = "Получение курса определенной валюты на текущий день")
    public ValuteCursOnDate getCourseForCurrency(@PathVariable String code) throws Exception {
        return centralRussianBankService.getCourseForCurrency(code);
    }

    @GetMapping("/getStats")
    @ApiOperation(value = "Получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutIncomesThatGreater(@RequestParam(value = "amount") BigDecimal amount) {
        return statsService.getCountOfIncomesThatGreater(amount);
    }
}
