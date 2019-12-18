package com.example.sportsbetting.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<SportEvent> sportEvents;

    public Data()
    {
        this.sportEvents = new ArrayList<>();
    }

    public void generateTestData()
    {
        OutcomeOdd outcomeOdd1 = new OutcomeOdd.OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(1))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .getOutcomeodd();

        OutcomeOdd outcomeOdd2 = new OutcomeOdd.OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .getOutcomeodd();

        OutcomeOdd outcomeOdd3 = new OutcomeOdd.OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(2))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .getOutcomeodd();

        OutcomeOdd outcomeOdd4 = new OutcomeOdd.OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .getOutcomeodd();

        Outcome outcome1 = new Outcome.OutcomeBuilder()
            .setDescription("1")
            .addOutcomeOdd(outcomeOdd1)
            .getOutcome();

        Outcome outcome2 = new Outcome.OutcomeBuilder()
                .setDescription("3")
                .addOutcomeOdd(outcomeOdd2)
                .getOutcome();

        Outcome outcome3 = new Outcome.OutcomeBuilder()
                .setDescription("Arsenal")
                .addOutcomeOdd(outcomeOdd3)
                .getOutcome();

        Outcome outcome4 = new Outcome.OutcomeBuilder()
                .setDescription("Chelsea")
                .addOutcomeOdd(outcomeOdd4)
                .getOutcome();

        Bet bet1 = new Bet.BetBuilder()
                .setDescription("player Oliver Giroud score")
                .setBetType(BetType.PLAYERS_SCORE)
                .addOutcome(outcome1)
                .getBet();

        Bet bet2 = new Bet.BetBuilder()
                .setDescription("number of scored goals")
                .setBetType(BetType.NUMBER_OF_SETS)
                .addOutcome(outcome2)
                .getBet();

        Bet bet3 = new Bet.BetBuilder()
                .setDescription("winner")
                .setBetType(BetType.WINNERS)
                .addOutcome(outcome3)
                .addOutcome(outcome4)
                .getBet();

        SportEvent footballSportEvent = new SportEvent.SportEventBuilder()
                .setTitle("Arsenal vs Chelsea")
                .setStartDate(LocalDateTime.of(2020, Month.JANUARY,01,12,00,00))
                .setEndDate(LocalDateTime.of(2020, Month.JANUARY,01,15,00,00))
                .addBet(bet1)
                .addBet(bet2)
                .addBet(bet3)
                .getFootballSportEvent();


        outcomeOdd1.setOutcome(outcome1);
        outcomeOdd2.setOutcome(outcome2);
        outcomeOdd3.setOutcome(outcome3);
        outcomeOdd4.setOutcome(outcome4);

        outcome1.setBet(bet1);
        outcome2.setBet(bet2);
        outcome3.setBet(bet3);
        outcome4.setBet(bet3);

        bet1.setSportEvent(footballSportEvent);
        bet2.setSportEvent(footballSportEvent);
        bet3.setSportEvent(footballSportEvent);


        sportEvents.add(footballSportEvent);


    }

    public List<SportEvent> getSportEvents() {
        return new ArrayList<SportEvent>(sportEvents);
    }

    public void setSportEvents(List<SportEvent> sportEvents) {
        this.sportEvents = sportEvents;
    }

}
