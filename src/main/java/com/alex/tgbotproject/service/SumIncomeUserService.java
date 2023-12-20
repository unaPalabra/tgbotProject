package com.alex.tgbotproject.service;

import com.alex.tgbotproject.repository.StatsIncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SumIncomeUserService {
    private final StatsIncomeRepository statsIncomeRepository;

    public long getSumIncomeUser (Long chatId){
        return statsIncomeRepository.getAllSumIncomeUser(chatId);
    }
}
