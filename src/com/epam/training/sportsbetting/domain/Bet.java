package com.epam.training.sportsbetting.domain;

import java.util.List;

public class Bet {

    private SportEvent sportEvent;

    private String description;

    private BetType betType;

    private List<OutCome> outComes;

    public Bet(SportEvent sportEvent, String description, BetType betType, List<OutCome> outComes)
    {
        this.sportEvent = sportEvent;
        this.description = description;
        this.betType = betType;
        this.outComes = outComes;
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

    public List<OutCome> getOutComes() {
        return outComes;
    }

    public void setOutComes(List<OutCome> outComes) {
        this.outComes = outComes;
    }
}
