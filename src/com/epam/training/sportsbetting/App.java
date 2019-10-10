package com.epam.training.sportsbetting;

import com.epam.training.sportsbetting.service.SportsBettingService;
import com.epam.training.sportsbetting.view.View;

public class App {

    private SportsBettingService service;

    private View view;

    public App(SportsBettingService service, View view) {

        this.service = service;
        this.view = view;
    }

    public static void main(String[] args) {

        App app = new App(new SportsBettingService(), new View());
        app.play();
    }

    private void play()
    {
        createPlayer();
        doBetting();
        calculateResults();
        printResults();
    }

    private void createPlayer(){

    }

    private void doBetting(){

    }

    private void calculateResults(){

    }

    private void printResults(){

    }
}
