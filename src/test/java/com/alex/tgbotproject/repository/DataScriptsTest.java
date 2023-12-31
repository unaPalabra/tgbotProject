package com.alex.tgbotproject.repository;

import com.alex.tgbotproject.entity.Income;
import com.alex.tgbotproject.entity.Spend;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class DataScriptsTest {

    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private SpendRepository spendRepository;

    // ������� �����, ����� ������� ������ ����
    @BeforeEach
    public void beforeAll() {
        System.out.println(System.currentTimeMillis());
    }

    // ������� �����, ����� ���������� ������ ����
    @AfterEach
    public void afterEach() {
        System.out.println(System.currentTimeMillis());
    }

    @DisplayName("GET_INCOME_BY_ID_test")
    @Test
    public void testData_tableIncome() {

        Optional<Income> income = incomeRepository.findById(144L);
        assertTrue(income.isPresent());
        assertEquals(new BigDecimal("1500.00"), income.get().getIncome());
    }

    @DisplayName("GET_SPEND_BY_ID_test")
    @Test
    public void  testData_tableSpend(){
        Optional<Spend> spend = spendRepository.findById(501L);
        assertTrue(spend.isPresent());
        assertEquals(new BigDecimal("1200.00"),spend.get().getSpend());
    }
}
