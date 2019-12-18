package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //all children goes in one entity
@DiscriminatorColumn(name = "sportevent_type") //children type
public class SportEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String title;

    @Column(name = "startdate")
    private  LocalDateTime startDate;

    @Column(name = "enddate")
    private  LocalDateTime endDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sportEvent", cascade = CascadeType.ALL)
    private List<Bet> bets;

    @OneToOne
    @JoinColumn(name = "resultid")
    private Result result;

    public SportEvent()
    {

    }

    public SportEvent(SportEventBuilder sportEventBuilder)
    {
        this.title = sportEventBuilder.getTitle();
        this.startDate = sportEventBuilder.getStartDate();
        this.endDate = sportEventBuilder.getEndDate();
        this.bets = sportEventBuilder.getBets();
    }



    public List<Bet> getBets() {
        return bets;
    }

    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String toString()
    {
        StringBuilder text = new StringBuilder();

        text.append(": Sport event: ").append(this.title).append(" (start: ").append(getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append(") ");

        return text.toString();

    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public static class SportEventBuilder
    {
        private String title;

        private LocalDateTime startDate;

        private LocalDateTime endDate;

        private List<Bet> bets;

        public SportEventBuilder()
        {
            bets = new ArrayList<>();
        }

        public String getTitle() {
            return title;
        }

        public SportEventBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public LocalDateTime getStartDate() {
            return startDate;
        }

        public SportEventBuilder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public LocalDateTime getEndDate() {
            return endDate;
        }

        public SportEventBuilder setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public List<Bet> getBets() {
            return new ArrayList<Bet>(bets);
        }

        public SportEventBuilder  addBet(Bet newBet)
        {
            bets.add(newBet);
            return this;
        }

        public SportEvent getTennisSportEvent()
        {
            return new TennisSportEvent(this);
        }

        public SportEvent getFootballSportEvent()
        {
            return new FootballSportEvent(this);
        }
    }


}
