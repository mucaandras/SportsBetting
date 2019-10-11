package com.sportsbetting.domain;

import com.sportsbetting.domain.builders.WagerBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wager {

    private BigDecimal amount;

    private LocalDateTime timestampCreated;

    private boolean processed;

    private boolean win;

    private Outcomeodd outComeOdd;

    private Player player;

    private Currency currency;

    public Wager(WagerBuilder wagerbuilder)
    {
        this.amount = wagerbuilder.getAmount();
        this.timestampCreated = wagerbuilder.getTimestampCreated();
        this.processed = wagerbuilder.isProcessed();
        this.setWin(wagerbuilder.isWin());
        this.outComeOdd = wagerbuilder.getOutComeOdd();
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

    public Outcomeodd getOutComeOdd() {
        return outComeOdd;
    }


    @Override
    public String toString()
    {
        return "Wager '" + this.outComeOdd.getOutCome().getBet().getDescription() + "=" + this.outComeOdd.getValue() + "' of "
                + this.outComeOdd.getOutCome().getBet().getSportEvent().getTitle() + " [odd: " + this.getOutComeOdd().getValue() + " amount: "
                + this.getAmount() + "]";
    }

}
