package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutComeOdd {

    private BigDecimal value;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    private Currency currency;

    private OutCome outCome;

    public OutComeOdd(BigDecimal value, LocalDateTime validFrom, LocalDateTime validUntil, Currency currency, OutCome outCome)
    {
        this.value = value;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.currency = currency;
        this.outCome = outCome;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public OutCome getOutCome() {
        return outCome;
    }

    public void setOutCome(OutCome outCome) {
        this.outCome = outCome;
    }
}
