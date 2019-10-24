package com.example.sportsbetting.domain;

import com.example.sportsbetting.domain.builders.BetBuilder;

import java.util.List;

public class Bet {

    private SportEvent sportEvent;

    private String description;

    private BetType betType;

    private List<Outcome> outcomes;

    public Bet(BetBuilder betBuilder)
    {
        this.sportEvent = betBuilder.getSportEvent();
        this.description = betBuilder.getDescription();
        this.betType = betBuilder.getBetType();
        this.outcomes = betBuilder.getOutcomes();
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    @Override
    public String toString()
    {
        return "Bet: " + description;
    }
}
