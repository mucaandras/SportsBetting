package com.example.sportsbetting.web.controllers;

import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
public class HomeController {

    @Autowired
    private SportsBettingService service;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelMap model = new ModelMap();

        model.addAttribute("player", service.FindPlayer());
        model.addAttribute("wagers", service.findAllWagers());
        model.addAttribute("currencies", Currency.values());

        return new ModelAndView("home",model);
    }

    @RequestMapping(value = {"/setPlayerData"}, method = RequestMethod.POST)
    public ModelAndView setPlayerData(String name,String birth,String accnumber,String currency,String balance) {

        Player player = service.FindPlayer();
        player.setName(name);
        player.setBirth(birth);
        player.setAccountNumber(Integer.parseInt(accnumber));
        player.setCurrency(currency);
        player.setBalance(new BigDecimal(balance));

        service.savePlayer(player);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = {"/deleteWager"}, method = RequestMethod.POST)
    public ModelAndView deleteWager(String id) {

        try { service.deleteWager(Integer.parseInt(id)); }

        catch (Exception e) { System.out.println(e.getMessage()); }

        return new ModelAndView("redirect:/");
    }
}
