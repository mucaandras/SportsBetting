package com.example.sportsbetting.app;

import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.app.view.View;

import java.math.BigDecimal;
import java.util.List;

public class App {

    private SportsBettingService service;

    private View view;

    public App(SportsBettingService service, View view) {

        this.service = service;
        this.view = view;
    }

    public void play()
    {
        createPlayer();
       // doBetting();
        calculateResults();
        printResults();
    }

    private void createPlayer()
    {
        service.savePlayer(view.readPlayerData());
        view.printWelcomeMessage(service.FindPlayer());
        view.printBalance(service.FindPlayer());
    }

    /*private void doBetting()
    {
        List<SportEvent> events = service.findAllSportEvents();
        while (service.getData().getPlayer().getBalance().compareTo(BigDecimal.ZERO)
                > 0){
            view.printOutcomeOdds(events);
            OutcomeOdd outcomeOdd = view.selectOutcomeOdd(events);
            BigDecimal amount = view.readWagerAmount();
            if (service.getData().getPlayer().getBalance().compareTo(amount) >= 0){
                Wager wager = new Wager.WagerBuilder()
                        .setAmount(amount)
                        .setOutcomeOdd(outcomeOdd)
                        .setPlayer(service.getData().getPlayer())
                        .setCurrency(service.getData().getPlayer().getCurrency())
                        .getWager();
                view.printWagerSaved(wager);
                service.saveWager(wager);
                view.printBalance(service.getData().getPlayer());
            }
        }
    } */

    private void calculateResults()
    {
        service.calculateResults();
    }

    private void printResults()
    {
        view.printResults(service.FindPlayer(),service.findAllWagers());
    }
}
