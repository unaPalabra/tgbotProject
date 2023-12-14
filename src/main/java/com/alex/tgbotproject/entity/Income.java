package com.alex.tgbotproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "INCOMES")
@Data
public class Income {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "INCOME")
    private BigDecimal income;

    LocalDate date = LocalDate.now();
    @Column(name = "DATE", insertable = false, updatable = false)
    private String currentDate;
}
