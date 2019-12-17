package com.example.sportsbetting.web.controllers;

import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
public class EventController {

    @Autowired
    private SportsBettingService sportsBettingService;

    @RequestMapping(value = {"/events"}, method = RequestMethod.GET)
    public ModelAndView events() {
        ModelMap model = new ModelMap();

        model.addAttribute("sportevents",sportsBettingService.findAllSportEvents());

        return new ModelAndView("events",model);
    }

    @RequestMapping(value = {"/addWager"}, method = RequestMethod.POST)
    public ModelAndView addWager(String amount,String id) {

        try {

        sportsBettingService.saveWager(new Wager.WagerBuilder()
                .setOutcomeOdd(sportsBettingService.findOutcomeOddById(Integer.parseInt(id)))
                .setAmount(new BigDecimal(amount)).getWager());


        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        return new ModelAndView("redirect:/");
    }

}
