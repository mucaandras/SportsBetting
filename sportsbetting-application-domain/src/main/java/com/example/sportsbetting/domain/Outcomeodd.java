package com.example.sportsbetting.domain;

import com.example.sportsbetting.domain.builders.OutcomeOddBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Outcomeodd {

    private BigDecimal value;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    private Currency currency;

    private Outcome outCome;

    public BigDecimal getValue() {
        return value;
    }

    public Outcomeodd(OutcomeOddBuilder outcomeOddBuilder)
    {
        this.value = outcomeOddBuilder.getValue();
        this.validFrom = outcomeOddBuilder.getValidFrom();
        this.validUntil = outcomeOddBuilder.getValidUntil();
        this.currency = outcomeOddBuilder.getCurrency();
        this.outCome = outcomeOddBuilder.getOutCome();
    }

    public Outcome getOutCome() {
        return outCome;
    }

    public String toString()
    {
        return " Actual odd: " + this.value + ", Valid between: " + this.validFrom.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +  " and " + this.validUntil.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }



}
