package com.epam.training.sportsbetting.domain;

import java.util.List;

public class OutCome {

    private String description;

    private Bet bet;

    private List<OutComeOdd> outComeOdds;

    public OutCome(String description, Bet bet, List<OutComeOdd> outComeOdds)
    {
        this.description = description;
        this.bet = bet;
        this.outComeOdds = outComeOdds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public List<OutComeOdd> getOutComeOdds() {
        return outComeOdds;
    }

    public void setOutComeOdds(List<OutComeOdd> outComeOdds) {
        this.outComeOdds = outComeOdds;
    }
}
