package com.sportsbetting.view;

import com.sportsbetting.domain.*;
import com.sportsbetting.domain.builders.PlayerBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner in = new Scanner(System.in);

    public Player readPlayerData()
    {
        PlayerBuilder playerBuilder = new PlayerBuilder();

        System.out.println("What is your name?");

        playerBuilder.setName(in.nextLine());

        System.out.println("How much money do you have (more than 0)?");

        playerBuilder.setBalance(new BigDecimal(in.nextLine()));

        System.out.println("What is your currency? (HUF, EUR or USD)");

        String currency = in.nextLine();

        if (currency.equals("EUR"))
        {
            playerBuilder.setCurrency(Currency.EUR);
        }
        else if  (currency.equals("USD"))
        {
            playerBuilder.setCurrency(Currency.USD);
        }
        else
        {
            playerBuilder.setCurrency(Currency.HUF);
        }

        return playerBuilder.getPlayer();
    }

    public void printWelcomeMessage(Player player)
    {
        System.out.println("Welcome " + player.getName());

    }

    public void printBalance(Player player)
    {
        System.out.println("Your balance is " + player.getBalance() + " " + player.getCurrency());
    }

    public void printOutcomeOdds(List<SportEvent> sportEvents)
    {
        System.out.println("What are you want to bet on? (choose a number or press q for quit)");
        for (SportEvent item : sportEvents)
        {
            System.out.println(item);
        }
    }

    public Outcomeodd selectOutcomeOdd(List<SportEvent> sportEvents)
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
                        for(Outcomeodd outcomeodd : outcome.getOutcomeodds())
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
        System.out.println("What amount do you wish to bet on it?");

        return new BigDecimal(in.nextLine());
    }

    public void printWagerSaved(Wager wager)
    {
        System.out.println(wager + " saved!");
    }

    public void printResults(Player player,List<Wager> wagers)
    {
        System.out.println("Results:");

        for(Wager wager : wagers)
        {
            System.out.println(wager +", win: " + wager.getWin());
        }

        printBalance(player);
    }
}
