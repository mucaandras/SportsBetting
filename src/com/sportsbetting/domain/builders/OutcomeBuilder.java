package com.sportsbetting.domain.builders;

import com.sportsbetting.domain.Bet;
import com.sportsbetting.domain.Outcome;
import com.sportsbetting.domain.Outcomeodd;

import java.util.ArrayList;
import java.util.List;

public class OutcomeBuilder
{
    private String description;

    private Bet bet;

    private List<Outcomeodd> outcomeodds;

    public  OutcomeBuilder()
    {
        outcomeodds = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public OutcomeBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Bet getBet() {
        return bet;
    }

    public OutcomeBuilder setBet(Bet bet) {
        this.bet = bet;
        return this;
    }

    public List<Outcomeodd> getOutcomeodds() {
        return outcomeodds;
    }

    public OutcomeBuilder addOutComeOdd(Outcomeodd outcomeodd) {
        outcomeodds.add(outcomeodd);
        return this;
    }

    public Outcome getOutcome()
    {
        return new Outcome(this);
    }
}
