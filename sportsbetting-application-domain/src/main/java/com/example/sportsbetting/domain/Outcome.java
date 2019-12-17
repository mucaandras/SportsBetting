package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String description;

    @ManyToOne
    private Bet bet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "outcome", cascade = CascadeType.ALL)
    private List<OutcomeOdd> outcomeOdds;

    public Outcome(){

    }

    public Outcome(OutcomeBuilder outcomebuilder)
    {
        this.description = outcomebuilder.getDescription();
        this.bet = outcomebuilder.getBet();
        this.outcomeOdds = outcomebuilder.getOutcomeOdds();
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

    public List<OutcomeOdd> getOutcomeOdds() {
        return new ArrayList<OutcomeOdd>(outcomeOdds);
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
    }

    public String toString()
    {
        return ", Outcome: " + this.description;
    }

    public static  class OutcomeBuilder
    {
        private String description;

        private Bet bet;

        private List<OutcomeOdd> outcomeOdds;

        public  OutcomeBuilder()
        {
            outcomeOdds = new ArrayList<>();
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

        public List<OutcomeOdd> getOutcomeOdds() {
            return new ArrayList<OutcomeOdd>(outcomeOdds);
        }

        public OutcomeBuilder addOutcomeOdd(OutcomeOdd outcomeodd) {
            outcomeOdds.add(outcomeodd);
            return this;
        }

        public Outcome getOutcome()
        {
            return new Outcome(this);
        }
    }
}
