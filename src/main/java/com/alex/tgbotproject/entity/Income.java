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


    @Column(name = "DATE_ADD")
    private     LocalDate date_add = LocalDate.now();
}
