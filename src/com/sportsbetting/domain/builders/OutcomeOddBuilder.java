package com.sportsbetting.domain.builders;

import com.sportsbetting.domain.Currency;
import com.sportsbetting.domain.Outcome;
import com.sportsbetting.domain.Outcomeodd;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOddBuilder
{
    private BigDecimal value;

    private LocalDateTime validFrom;

    private LocalDateTime validUntil;

    private Currency currency;

    private Outcome outCome;

    public OutcomeOddBuilder()
    {

    }

    public BigDecimal getValue() {
        return value;
    }

    public OutcomeOddBuilder setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public OutcomeOddBuilder setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public OutcomeOddBuilder setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public OutcomeOddBuilder setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Outcome getOutCome() {
        return outCome;
    }

    public OutcomeOddBuilder setOutCome(Outcome outCome) {
        this.outCome = outCome;
        return this;
    }

    public Outcomeodd getOutcomeodd()
    {
        return new Outcomeodd(this);
    }
}
