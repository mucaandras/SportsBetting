package com.sportsbetting.domain;

import com.sportsbetting.domain.builders.SportEventBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SportEvent {

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private List<Bet> bets;

    private Result result;

    public SportEvent(SportEventBuilder sportEventBuilder)
    {
        this.title = sportEventBuilder.getTitle();
        this.startDate = sportEventBuilder.getStartDate();
        this.endDate = sportEventBuilder.getEndDate();
        this.bets = sportEventBuilder.getBets();
    }

    public List<Bet> getBets() {
        return bets;
    }

    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String toString()
    {
        String text = "";

        int counter = 1;

        for (Bet bet : bets)
        {
            for(Outcome outcome : bet.getOutcomes())
            {
                for(Outcomeodd outcomeodd : outcome.getOutcomeodds())
                {
                    text += counter++ + ": Sport event: " + this.title + " (start: " + startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ") "  + bet.toString()  + outcome.toString() + outcomeodd.toString() + System.lineSeparator();
                }
            }
        }

        return text;

    }
}
