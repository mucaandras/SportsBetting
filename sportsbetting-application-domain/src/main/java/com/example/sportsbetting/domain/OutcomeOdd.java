package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class OutcomeOdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal value;

    @Column(name = "validfrom")
    private LocalDateTime validFrom;

    @Column(name = "validuntil")
    private LocalDateTime validUntil;

    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "outcomeid")
    private Outcome outcome;

    public BigDecimal getValue() {
        return value;
    }

    public OutcomeOdd(){

    }

    public OutcomeOdd(OutcomeOddBuilder outcomeOddBuilder)
    {
        this.value = outcomeOddBuilder.getValue();
        this.validFrom = outcomeOddBuilder.getValidFrom();
        this.validUntil = outcomeOddBuilder.getValidUntil();
        this.currency = outcomeOddBuilder.getCurrency();
        this.outcome = outcomeOddBuilder.getOutcome();
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome)
    {
        this.outcome = outcome;
    }

    public String toString()
    {
        return " Actual odd: " + this.value + ", Valid between: " + this.validFrom.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +  " and " + this.validUntil.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static  class OutcomeOddBuilder
    {
        private BigDecimal value;

        private LocalDateTime validFrom;

        private LocalDateTime validUntil;

        private Currency currency;

        private Outcome outcome;

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

        public Outcome getOutcome() {
            return outcome;
        }

        public OutcomeOddBuilder setOutcome(Outcome outcome) {
            this.outcome = outcome;
            return this;
        }

        public OutcomeOdd getOutcomeodd()
        {
            return new OutcomeOdd(this);
        }
    }

}
