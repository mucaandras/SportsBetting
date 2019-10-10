package com.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {

    private BigDecimal amount;

    private LocalDateTime timestampCreated;

    private boolean processed;

    private boolean win;

    private OutComeOdd outComeOdd;

    private Player player;

    private Currency currency;

    public Wager(BigDecimal amount, LocalDateTime timestampCreated,boolean win, OutComeOdd outComeOdd,Player player,Currency courrency)
    {
        this.setAmount(amount);
        this.setTimestampCreated(timestampCreated);
        this.setWin(win);
        this.setOutComeOdd(outComeOdd);
        this.setPlayer(player);
        this.setCurrency(courrency);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestampCreated() {
        return timestampCreated;
    }

    public void setTimestampCreated(LocalDateTime timestampCreated) {
        this.timestampCreated = timestampCreated;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public OutComeOdd getOutComeOdd() {
        return outComeOdd;
    }

    public void setOutComeOdd(OutComeOdd outComeOdd) {
        this.outComeOdd = outComeOdd;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
