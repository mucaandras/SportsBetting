package com.example.sportsbetting.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("footballsportevent")
public class FootballSportEvent extends  SportEvent
{
    public FootballSportEvent(SportEventBuilder sportEventBuilder)
    {
        super(sportEventBuilder);
    }

    public FootballSportEvent()
    {

    }
}
