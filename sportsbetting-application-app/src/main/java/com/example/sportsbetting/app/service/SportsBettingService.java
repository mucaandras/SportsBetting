package com.example.sportsbetting.app.service;

import com.example.sportsbetting.domain.*;
import com.example.sportsbetting.repository.PlayerRepository;
import com.example.sportsbetting.repository.SportEventRepository;
import com.example.sportsbetting.repository.WagerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class SportsBettingService {


    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private SportEventRepository sportEventRepository;

    @Autowired
    private WagerRepository wagerRepository;

    @Autowired
    private Data data;

    public void SaveSportEvents()
    {
        sportEventRepository.saveAll(data.getSportEvents());
    }




    public void savePlayer(Player player)
    {
      playerRepository.save(player);
    }

    public Player FindPlayer()
    {
         return playerRepository.findById(0).get();
    }

    public List<SportEvent> findAllSportEvents()
    {
        return (List<SportEvent>) sportEventRepository.findAll();
    }

    public void saveWager(Wager wager)
    {
       wagerRepository.save(wager);
       FindPlayer().setBalance(FindPlayer().getBalance().subtract(wager.getAmount()));

    }

    public List<Wager> findAllWagers()
    {
        return (List<Wager>)wagerRepository.findAll();
    }


    public void calculateResults()
    {
        Random r = new Random();

        for (Wager wager : findAllWagers())
        {
            if(r.nextBoolean())
            {
                wager.setWin(true);
                FindPlayer().setBalance(FindPlayer().getBalance().add(wager.getAmount().multiply(wager.getOutcomeOdd().getValue())));
            }
            else
            {
                wager.setWin(false);
            }
        }
    }

    public OutcomeOdd findOutcomeOddById(int id)
    {
        for(SportEvent sportEvent : findAllSportEvents())
        {
            for(Bet bet : sportEvent.getBets())
            {
                for(Outcome outcome : bet.getOutcomes())
                {
                    for(OutcomeOdd outcomeodd : outcome.getOutcomeOdds())
                    {
                        if(outcomeodd.getId() == id)
                        {
                           return outcomeodd;
                        }

                    }
                }
            }
        }
        return null;
    }

    public void deleteWager(int id)
    {
        wagerRepository.deleteById(id);
    }
}
