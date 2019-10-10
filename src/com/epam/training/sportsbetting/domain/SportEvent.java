package com.epam.training.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.List;

public class SportEvent {

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private List<Bet> bets;

    private Result result;

    public SportEvent(String title,LocalDateTime startDate, LocalDateTime endDate, List<Bet> bets, Result result)
    {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bets = bets;
        this.result = result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }


}
