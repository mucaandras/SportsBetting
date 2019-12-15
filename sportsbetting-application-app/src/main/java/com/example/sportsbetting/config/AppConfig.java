package com.example.sportsbetting.config;

import com.example.sportsbetting.app.App;
import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.app.view.View;
import com.example.sportsbetting.domain.Data;
import com.example.sportsbetting.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;

@Configuration
@Import({MessageSourceConfig.class})
@PropertySource(value = { "classpath:config.properties"}, encoding = "UTF-8")
public class AppConfig {

    @Value("${default.language}")
    private Locale locale;

    @Autowired
    private MessageSource messageSource;

    @Bean
    public SportsBettingService sportsBettingService() {
        return new SportsBettingService();
    }

    @Bean
    public View view(){
        return new View(locale);
    }

    @Bean
    public App app()
    {
        return new App(sportsBettingService(),view());
    }

    @Bean(initMethod = "generateTestData")
    public Data data()
   {
       return new Data();
   }

    @Bean
    public Player.PlayerBuilder playerBuilder(){

        return new Player.PlayerBuilder();
    }





}
