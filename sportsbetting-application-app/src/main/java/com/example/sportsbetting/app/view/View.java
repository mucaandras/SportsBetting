package com.example.sportsbetting.app.view;

import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.domain.builders.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner in = new Scanner(System.in);

    private String askname;

    private String  askmoney;
    private String  askcurrency;
    private String welcome;
    private String balance;
    private String askbet;
    private String askamount;
    private String result;

    public View(String askname,String askmoney, String askcurrency, String welcome, String balance, String askbet, String askamount, String result)
    {
        this.askname = askname;
        this.askmoney = askmoney;
        this.askcurrency = askcurrency;
        this.welcome = welcome;
        this.balance = balance;
        this.askbet = askbet;
        this.askamount = askamount;
        this.result = result;
    }

    public Player readPlayerData()
    {
        PlayerBuilder playerBuilder = new PlayerBuilder();

        System.out.println(askname);

        playerBuilder.setName(in.nextLine());

        System.out.println(askmoney);

        playerBuilder.setBalance(new BigDecimal(in.nextLine()));

        System.out.println(askcurrency);

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
        System.out.println(welcome + player.getName());

    }

    public void printBalance(Player player)
    {
        System.out.println(balance + player.getBalance() + " " + player.getCurrency());
    }

    public void printOutcomeOdds(List<SportEvent> sportEvents)
    {
        System.out.println(askbet);
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
        System.out.println(askamount);

        return new BigDecimal(in.nextLine());
    }

    public void printWagerSaved(Wager wager)
    {
        System.out.println(wager + " saved!");
    }

    public void printResults(Player player,List<Wager> wagers)
    {
        System.out.println(result);

        for(Wager wager : wagers)
        {
            System.out.println(wager +", win: " + wager.getWin());
        }

        printBalance(player);
    }
}
