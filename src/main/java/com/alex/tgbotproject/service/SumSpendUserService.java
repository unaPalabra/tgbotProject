package com.alex.tgbotproject.service;

import com.alex.tgbotproject.repository.StatsSpendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SumSpendUserService {
    private final StatsSpendRepository statsSpendRepository;

    public long getSumSpendUser (Long chatId){
        return statsSpendRepository.getAllSumSpendUser(chatId);
    }
}
