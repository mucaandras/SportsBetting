package com.example.sportsbetting.web.controllers;

import com.example.sportsbetting.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

    @Autowired
    private Player player;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelMap model = new ModelMap();

        model.addAttribute("player",player);

        return new ModelAndView("homePage",model);
    }

    @RequestMapping(value = {"/setPlayerData"}, method = RequestMethod.POST)
    public ModelAndView setPlayerData(String name) {

       this.player.setName(name);

      return homePage();
    }

}
