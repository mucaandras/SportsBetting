package com.example.sportsbetting.app;

import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.config.AppConfig;
import com.example.sportsbetting.config.JpaConfig;
import com.example.sportsbetting.domain.Data;
import com.example.sportsbetting.repository.SportEventRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpring {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class, JpaConfig.class)) {

            App app = appContext.getBean(App.class);

            SportEventRepository sportEventRepository = appContext.getBean(SportEventRepository.class);

            sportEventRepository.saveAll(appContext.getBean(Data.class).getSportEvents());

            app.play();

        }
    }
}
