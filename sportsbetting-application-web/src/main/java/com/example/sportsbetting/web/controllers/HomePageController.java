package com.example.sportsbetting.web.controllers;

import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.repository.SportEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
public class HomePageController {

    @Autowired
    private Player player;

    @Autowired
    private SportsBettingService sportsBettingService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelMap model = new ModelMap();

        model.addAttribute("player",player);
        model.addAttribute("wagers",sportsBettingService.findAllWagers());

        return new ModelAndView("homePage",model);
    }

    @RequestMapping(value = {"/setPlayerData"}, method = RequestMethod.POST)
    public ModelAndView setPlayerData(String name,String birth,String accnumber,String currency,String balance) {

       this.player.setName(name);
      this.player.setAccountNumber(Integer.parseInt(accnumber));
      this.player.setBalance(new BigDecimal(balance));

      return homePage();
    }

    @RequestMapping(value = {"/deleteWager"}, method = RequestMethod.POST)
    public ModelAndView deleteWager(String id) {

        try {

            sportsBettingService.deleteWager(Integer.parseInt(id));


        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        return new ModelAndView("redirect:/");
    }

}
