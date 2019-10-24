package com.example.sportsbetting.domain.builders;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.FootballSportEvent;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.TennisSportEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SportEventBuilder
{
    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private List<Bet> bets;

    public SportEventBuilder()
    {
        bets = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public SportEventBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public SportEventBuilder setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public SportEventBuilder setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public SportEventBuilder  addBet(Bet newBet)
    {
        bets.add(newBet);
        return this;
    }

    public SportEvent getTennisSportEvent()
    {
        return new TennisSportEvent(this);
    }

    public SportEvent getFootballSportEvent()
    {
        return new FootballSportEvent(this);
    }
}
