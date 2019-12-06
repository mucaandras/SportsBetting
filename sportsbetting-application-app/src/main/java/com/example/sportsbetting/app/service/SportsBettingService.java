package com.example.sportsbetting.app.service;

import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.repository.Resultrepository;
import com.example.sportsbetting.repository.SportEventRepository;
import com.example.sportsbetting.repository.WagerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class SportsBettingService {

    @Autowired
    private Data data;

    @Autowired
    WagerRepository wagerRepository;

    @Autowired
    Resultrepository resultRepository;



    public void savePlayer(Player player)
    {
        data.setPlayer(player);

    }

    public Player FindPlayer()
    {
       return data.getPlayer();
    }

    public List<SportEvent> findAllSportEvents()
    {
        return data.getSportEvents();
    }

    public void saveWager(Wager wager)
    {
        data.addWager(wager);
        data.getPlayer().setBalance(data.getPlayer().getBalance().subtract(wager.getAmount()));

    }

    public List<Wager> findAllWagers()
    {
        return (List<Wager>)wagerRepository.findAll();
    }

    public Data getData()
    {
        return this.data;
    }

    public void calculateResults()
    {
        Random r = new Random();

        for (Wager wager : data.getWagers())
        {
            if(r.nextBoolean())
            {
                wager.setWin(true);
                data.getPlayer().setBalance(data.getPlayer().getBalance().add(wager.getAmount().multiply(wager.getOutcomeOdd().getValue())));
            }
            else
            {
                wager.setWin(false);
            }
        }
    }
}
