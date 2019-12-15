package com.example.sportsbetting.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }




}