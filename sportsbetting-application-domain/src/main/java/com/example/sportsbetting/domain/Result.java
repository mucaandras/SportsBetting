package com.example.sportsbetting.domain;

import java.util.List;

public class Result {

    private List<Outcome> outcomes;

    public Result(List<Outcome> outcomes)
    {
        this.setOutcomes(outcomes);
    }

    public List<Outcome> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
