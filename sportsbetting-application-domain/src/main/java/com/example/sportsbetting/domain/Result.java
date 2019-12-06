package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToMany
    private List<Outcome> outcomes;

    public Result(List<Outcome> outcomes)
    {
        this.setOutcomes(outcomes);
    }

    public List<Outcome> getOutcomes() {
        return new ArrayList<Outcome>(outcomes);
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
