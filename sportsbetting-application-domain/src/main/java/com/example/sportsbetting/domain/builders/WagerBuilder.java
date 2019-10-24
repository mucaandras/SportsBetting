package com.example.sportsbetting.domain.builders;

import com.example.sportsbetting.domain.Outcomeodd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Wager;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WagerBuilder
{
    private BigDecimal amount;

    private LocalDateTime timestampCreated;

    private boolean processed;

    private boolean win;

    private Outcomeodd outComeOdd;

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

    public Outcomeodd getOutComeOdd() {
        return outComeOdd;
    }

    public WagerBuilder setOutComeOdd(Outcomeodd outComeOdd) {
        this.outComeOdd = outComeOdd;
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
