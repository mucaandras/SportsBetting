package com.example.sportsbetting.app;

import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;
import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.app.view.View;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class App {

    @Autowired
    private SportsBettingService service;

    @Autowired
    private View view;


    public void play()
    {
        createPlayer();
        doBetting();
        calculateResults();
        printResults();
    }

    private void createPlayer()
    {
        service.savePlayer(view.readPlayerData(service.FindPlayer()));
        view.printWelcomeMessage(service.FindPlayer());
        view.printBalance(service.FindPlayer());
    }

    private void doBetting()
    {
        List<SportEvent> events = service.findAllSportEvents();
        while (service.FindPlayer().getBalance().compareTo(BigDecimal.ZERO) > 0){

            view.printOutcomeOdds(events);

            OutcomeOdd outcomeOdd = view.selectOutcomeOdd(events);
            if (outcomeOdd==null) break;
            BigDecimal amount = view.readWagerAmount();
            if (service.FindPlayer().getBalance().compareTo(amount) >= 0)
            {

                Wager wager = new Wager.WagerBuilder()
                        .setAmount(amount)
                        .setOutcomeOdd(outcomeOdd)
                        .setPlayer(service.FindPlayer())
                        .setCurrency(service.FindPlayer().getCurrency())
                        .getWager();

                view.printWagerSaved(wager);
                service.saveWager(wager);
                view.printBalance(service.FindPlayer());
            }
            else
            {
                view.notEnoughBalance();
                break;
            }
        }
    }

    private void calculateResults()
    {
        service.calculateResults();
    }

    private void printResults()
    {
        view.printResults(service.FindPlayer(),service.findAllWagers());
    }
}
