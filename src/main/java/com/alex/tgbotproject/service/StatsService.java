package com.alex.tgbotproject.service;

import com.alex.tgbotproject.repository.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsRepository statsRepository;

    public int getCountOfIncomesThatGreater(BigDecimal amount){
        return statsRepository.getCountOfIncomesThatGreaterThan(amount);
    }
}
