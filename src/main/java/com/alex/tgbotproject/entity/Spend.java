package com.alex.tgbotproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SPEND")
@Data
public class Spend {

    LocalDate date = LocalDate.now();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "SPEND")
    private BigDecimal spend;

    @Column(name = "DATE", insertable = false, updatable = false)
    private String currentDate;
}
