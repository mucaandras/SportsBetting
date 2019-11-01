package com.example.sportsbetting.config;

import com.example.sportsbetting.app.App;
import com.example.sportsbetting.app.service.SportsBettingService;
import com.example.sportsbetting.app.view.View;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Inject;
import java.util.Locale;

@Configuration
@Import({MessageSourceConfig.class})
@PropertySource(value = { "classpath:config.properties"}, encoding = "UTF-8")
public class AppConfig {

    @Value("${default.language}")
    private Locale locale;

    @Inject
    private MessageSource messageSource;

    @Bean
    public SportsBettingService sportsBettingService() {
        return new SportsBettingService();
    }

    @Bean
    public View view() {
        return new View(
                getAskNameMessage(),
                getAskMoney(),
                getAskCurrency(),
                getWelcome(),
                getBalance(),
                getAskBet(),
                getAskAmount(),
                getResults()
        );
    }

    @Bean
    public App app()
    {
        return new App(sportsBettingService(),view());
    }

    public String getAskNameMessage()
    {
        return messageSource.getMessage("view.askname",null,locale);
    }

    public String getAskMoney()
    {
        return messageSource.getMessage("view.askmoney",null,locale);
    }

    public String getAskCurrency()
    {
        return messageSource.getMessage("view.askcurrency",null,locale);
    }

    public String getWelcome()
    {
        return messageSource.getMessage("view.welcome",null,locale);
    }

    public String getBalance()
    {
        return messageSource.getMessage("view.balance",null,locale);
    }

    public String getAskBet()
    {
        return messageSource.getMessage("view.askbet",null,locale);
    }

    public String getAskAmount()
    {
        return messageSource.getMessage("view.askamount",null,locale);
    }

    public String getResults()
    {
        return messageSource.getMessage("view.results",null,locale);
    }





}
