package com.example.sportsbetting.app.view;

import com.example.sportsbetting.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class View {

    private Scanner in = new Scanner(System.in);

    private Locale locale;


    @Autowired
    private MessageSource messageSource;

    public View(Locale locale)
    {
        this.locale = locale;
    }

    public Player readPlayerData(Player player)
    {
        System.out.println(messageSource.getMessage("view.askname",null,locale));

        player.setName(in.nextLine());

        System.out.println(messageSource.getMessage("view.askmoney",null,locale));

        player.setBalance(new BigDecimal(in.nextLine()));

        System.out.println(messageSource.getMessage("view.askcurrency",null,locale));

        String currency = in.nextLine();

        player.setCurrency(currency);

        return player;
    }

    public void printWelcomeMessage(Player player)
    {
        System.out.println(messageSource.getMessage("view.welcome",null,locale) + player.getName());
    }

    public void printBalance(Player player)
    {
       System.out.println(messageSource.getMessage("view.balance",null,locale) + player.getBalance() + " " + player.getCurrency());
    }

    public void printOutcomeOdds(List<SportEvent> sportEvents)
    {
        System.out.println(messageSource.getMessage("view.askbet",null,locale));
        int count = 1;
        for (SportEvent event : sportEvents)
        {
            for (Bet bet : event.getBets())
            {
                for (Outcome outcome : bet.getOutcomes())
                {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds())
                    {
                        System.out.println(count + ": " + event.toString() + bet.toString() + outcome.toString() + outcomeOdd.toString());
                        count++;
                    }
                }
            }
        }
    }

    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEvents)
    {
        String keyPressed = in.nextLine();

        if (keyPressed.equals("q"))
        {
            return null;
        }
        else
        {
            int outcomeOddId = Integer.parseInt(keyPressed);
            int outcomeOddCount = 1;

            for(SportEvent sportEvent : sportEvents)
            {
                for(Bet bet : sportEvent.getBets())
                {
                    for(Outcome outcome : bet.getOutcomes())
                    {
                        for(OutcomeOdd outcomeodd : outcome.getOutcomeOdds())
                        {
                            if(outcomeOddCount == outcomeOddId)
                            {
                                return outcomeodd;
                            }
                            else
                            {
                                outcomeOddCount++;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public BigDecimal readWagerAmount()
    {
        System.out.println(messageSource.getMessage("view.askamount",null,locale));

        return new BigDecimal(in.nextLine());
    }

    public void printWagerSaved(Wager wager)
    {
        System.out.println(wager.toString() + " saved!");
    }

    public void notEnoughBalance()
    {
        System.out.println(messageSource.getMessage("view.notenoughbalance",null,locale));
    }

    public void printResults(Player player,List<Wager> wagers)
    {
        System.out.println(messageSource.getMessage("view.results",null,locale));

        for(Wager wager : wagers)
        {
            System.out.println(wager +", win: " + wager.getWin());
        }

        printBalance(player);
    }
}
