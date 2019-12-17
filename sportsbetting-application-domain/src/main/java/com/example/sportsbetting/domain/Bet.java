package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "eventid")
    private SportEvent sportEvent;

    private String description;

    @Enumerated(EnumType.STRING)
    private BetType betType;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "bet", cascade = CascadeType.ALL)
    private List<Outcome> outcomes;

    public Bet(){

    }

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
        return new ArrayList<Outcome>(outcomes);
    }

    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }

    @Override
    public String toString()
    {
        return "Bet: " + description;
    }

    public static  class BetBuilder
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
            return new ArrayList<Outcome>(outcomes);
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
}
