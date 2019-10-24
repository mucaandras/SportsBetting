package com.example.sportsbetting.app.service;

import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.domain.builders.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SportsBettingService {

    private Player player;

    private List<SportEvent> sportEvents;

    private List<Wager> wagers;

    public SportsBettingService()
    {
        sportEvents = new ArrayList<>();
        wagers = new ArrayList<>();
    }

    public void createTestData()
    {
        SportEventBuilder sportEventBuilder = new SportEventBuilder()
                .setTitle("Arsenal vs Chelsea")
                .setStartDate(LocalDateTime.of(2020, Month.JANUARY,01,12,00,00))
                .setEndDate(LocalDateTime.of(2020,Month.JANUARY,01,15,00,00));

        BetBuilder betBuilder = new BetBuilder()
                .setSportEvent(sportEventBuilder.getFootballSportEvent())
                .setDescription("player Oliver Giroud")
                .setBetType(BetType.PLAYERS_SCORE);

        BetBuilder betBuilder2 = new BetBuilder()
                .setSportEvent(sportEventBuilder.getFootballSportEvent())
                .setDescription("number of scored goals")
                .setBetType(BetType.GOALS);

        BetBuilder betBuilder3 = new BetBuilder()
                .setSportEvent(sportEventBuilder.getFootballSportEvent())
                .setDescription("winner")
                .setBetType(BetType.WINNERS);

        OutcomeBuilder outcomeBuilder = new OutcomeBuilder()
                .setDescription("1")
                .setBet(betBuilder.getBet());

        OutcomeBuilder outcomeBuilder2 = new OutcomeBuilder()
                .setDescription("3")
                .setBet(betBuilder2.getBet());

        OutcomeBuilder outcomeBuilder3 = new OutcomeBuilder()
                .setDescription("Arsenal")
                .setBet(betBuilder2.getBet());

        OutcomeBuilder outcomeBuilder4 = new OutcomeBuilder()
                .setDescription("Chelsea")
                .setBet(betBuilder2.getBet());

        OutcomeOddBuilder outcomeOddBuilder = new OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(1))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .setCurrency(this.player.getCurrency())
                .setOutCome(outcomeBuilder.getOutcome());

        OutcomeOddBuilder outcomeOddBuilder2 = new OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .setCurrency(this.player.getCurrency())
                .setOutCome(outcomeBuilder2.getOutcome());

        OutcomeOddBuilder outcomeOddBuilder3 = new OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(2))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .setCurrency(this.player.getCurrency())
                .setOutCome(outcomeBuilder3.getOutcome());

        OutcomeOddBuilder outcomeOddBuilder4 = new OutcomeOddBuilder()
                .setValue(BigDecimal.valueOf(3))
                .setValidFrom(LocalDateTime.of(2000,01,01,12,00,00))
                .setValidUntil(LocalDateTime.of(2020,01,01,12,00,00))
                .setCurrency(this.player.getCurrency())
                .setOutCome(outcomeBuilder4.getOutcome());

         sportEvents.add(sportEventBuilder
                 .addBet(betBuilder.addOutcome(outcomeBuilder.addOutComeOdd(outcomeOddBuilder.getOutcomeodd()).getOutcome()).getBet())
                 .addBet(betBuilder2.addOutcome(outcomeBuilder2.addOutComeOdd(outcomeOddBuilder2.getOutcomeodd()).getOutcome()).getBet())
                 .addBet(betBuilder3
                         .addOutcome(outcomeBuilder3.addOutComeOdd(outcomeOddBuilder3.getOutcomeodd()).getOutcome())
                         .addOutcome(outcomeBuilder4.addOutComeOdd(outcomeOddBuilder4.getOutcomeodd()).getOutcome())
                         .getBet())
                 .getFootballSportEvent());

    }

    public void savePlayer(Player player)
    {
        this.player = player;
    }

    public Player FindPlayer()
    {
        return this.player;
    }

    public List<SportEvent> findAllSportEvents()
    {
        return sportEvents;
    }

    public void saveWager(Wager wager)
    {
        wagers.add((wager));
        player.setBalance(player.getBalance().subtract(wager.getAmount()));
    }

    public List<Wager> findAllWagers()
    {
        return this.wagers;
    }

    public void calculateResults()
    {
        Random r = new Random();

        for (Wager wager : wagers)
        {
            if(r.nextBoolean())
            {
                wager.setWin(true);
                player.setBalance(player.getBalance().add(wager.getAmount().multiply(wager.getOutComeOdd().getValue())));
            }
            else
            {
                wager.setWin(false);
            }
        }
    }
}
