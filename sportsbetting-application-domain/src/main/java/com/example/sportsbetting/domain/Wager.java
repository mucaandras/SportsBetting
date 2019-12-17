package com.example.sportsbetting.domain;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Wager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal amount;

    @Column(name = "timestampcreated")
    private LocalDateTime timestampCreated;

    private boolean processed;

    private boolean win;

    @OneToOne
    @JoinColumn(name = "outcomeoddid")
    private OutcomeOdd outcomeOdd;

    @OneToOne
    @JoinColumn(name = "playerid")
    private Player player;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Wager()
    {

    }

    public Wager(WagerBuilder wagerbuilder)
    {
        this.amount = wagerbuilder.getAmount();
        this.timestampCreated = wagerbuilder.getTimestampCreated();
        this.processed = wagerbuilder.isProcessed();
        this.win = wagerbuilder.win;
        this.outcomeOdd = wagerbuilder.getOutcomeOdd();
        this.player = wagerbuilder.getPlayer();
        this.currency = wagerbuilder.getCurrency();
    }

    public boolean getWin() {
        return this.win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public OutcomeOdd getOutcomeOdd() {
        return outcomeOdd;
    }

    @Override
    public String toString()
    {
        return "Wager '" + this.outcomeOdd.getOutcome().getBet().getDescription() + "=" + this.outcomeOdd.getValue() + "' of "
                + this.outcomeOdd.getOutcome().getBet().getSportEvent().getTitle() + " [odd: " + this.getOutcomeOdd().getValue() + " amount: "
                + this.getAmount() + "]";

    }

    public int getId() {
        return id;
    }

    public static  class WagerBuilder
    {
        private BigDecimal amount;

        private LocalDateTime timestampCreated;

        private boolean processed;

        private boolean win;

        private OutcomeOdd outcomeOdd;

        private Player player;

        private Currency currency;

        public WagerBuilder()
        {
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public WagerBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public LocalDateTime getTimestampCreated() {
            return timestampCreated;
        }

        public WagerBuilder setTimestampCreated(LocalDateTime timestampCreated) {
            this.timestampCreated = timestampCreated;
            return this;
        }

        public boolean isProcessed() {
            return processed;
        }

        public WagerBuilder setProcessed(boolean processed) {
            this.processed = processed;
            return this;
        }

        public boolean isWin() {
            return win;
        }

        public WagerBuilder setWin(boolean win) {
            this.win = win;
            return this;
        }

        public OutcomeOdd getOutcomeOdd() {
            return outcomeOdd;
        }

        public WagerBuilder setOutcomeOdd(OutcomeOdd outcomeOdd) {
            this.outcomeOdd = outcomeOdd;
            return this;
        }

        public Player getPlayer() {
            return player;
        }

        public WagerBuilder setPlayer(Player player) {
            this.player = player;
            return this;
        }

        public Currency getCurrency() {
            return currency;
        }

        public WagerBuilder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Wager getWager()
        {
            return new Wager(this);
        }
    }
}

