package com.example.sportsbetting.domain.builders;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.BetType;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.SportEvent;

import java.util.ArrayList;
import java.util.List;

public class BetBuilder
{
    private SportEvent sportEvent;

    private String description;

    private BetType betType;

    private List<Outcome> outcomes;

    public BetBuilder()
    {
        outcomes = new ArrayList<>();
    }

    public SportEvent getSportEvent() {
        return sportEvent;
    }

    public BetBuilder setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BetBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public BetType getBetType() {
        return betType;
    }

    public BetBuilder setBetType(BetType betType) {
        this.betType = betType;
        return this;
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public BetBuilder addOutcome(Outcome outcome)
    {
        outcomes.add(outcome);
        return this;
    }

    public Bet getBet()
    {
        return new Bet(this);
    }
}
