package com.sportsbetting;

import com.sportsbetting.domain.Player;
import com.sportsbetting.domain.Wager;
import com.sportsbetting.domain.builders.WagerBuilder;
import com.sportsbetting.service.SportsBettingService;
import com.sportsbetting.view.View;

import java.sql.Timestamp;

public class App {

    private SportsBettingService service;

    private View view;

    public App(SportsBettingService service, View view) {

        this.service = service;
        this.view = view;
    }

    public static void main(String[] args)
    {
        App app = new App(new SportsBettingService(), new View());
        app.play();
    }

    private void play()
    {
        createPlayer();
        service.createTestData();
        doBetting();
        calculateResults();
        printResults();
    }

    private void createPlayer()
    {
        service.savePlayer(view.readPlayerData());
        view.printWelcomeMessage(service.FindPlayer());
        view.printBalance(service.FindPlayer());
    }

    private void doBetting()
    {
        while(service.FindPlayer().getBalance().intValue() > 0) {
            view.printOutcomeOdds(service.findAllSportEvents());

            WagerBuilder wagerbuilder = new WagerBuilder()
                    .setOutComeOdd(view.selectOutcomeOdd(service.findAllSportEvents()))
                    .setPlayer(service.FindPlayer())
                    .setCurrency(service.FindPlayer().getCurrency());


            if (wagerbuilder.getOutComeOdd() == null)
            {
                break;
            }
            else
            {
                wagerbuilder.setAmount(view.readWagerAmount());
            }

            Wager wager = wagerbuilder.getWager();

            service.saveWager(wager);

            view.printWagerSaved(wager);

            view.printBalance(service.FindPlayer());
            /* kiegészíteni */

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
