package com.sportsbetting.domain;

import com.sportsbetting.domain.builders.OutcomeBuilder;

import java.util.List;

public class Outcome {

    private String description;

    private Bet bet;

    private List<Outcomeodd> outcomeodds;

    public Outcome(OutcomeBuilder outcomebuilder)
    {
        this.description = outcomebuilder.getDescription();
        this.bet = outcomebuilder.getBet();
        this.outcomeodds = outcomebuilder.getOutcomeodds();
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

    public List<Outcomeodd> getOutcomeodds() {
        return outcomeodds;
    }

    public void setOutcomeodds(List<Outcomeodd> outcomeodds) {
        this.outcomeodds = outcomeodds;
    }

    public String toString()
    {
        return ", Outcome: " + this.description;
    }
}
