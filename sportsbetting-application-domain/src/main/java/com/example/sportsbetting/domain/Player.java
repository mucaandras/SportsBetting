package com.example.sportsbetting.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Player extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private static int accountCount = 0;

    private String name;

    @Column(name = "accountnumber")
    private int accountNumber;

    private BigDecimal balance;

    private LocalDateTime birth;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Player(PlayerBuilder playerBuilder)
    {
        this.setAccountNumber(accountCount++);
        this.setName(playerBuilder.getName());
        this.setBalance(playerBuilder.getBalance());
        this.currency = playerBuilder.getCurrency();
    }

    public Player()
    {

    }

    public String getName() {
        return name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(birth, formatter);
        this.birth = ld.atStartOfDay();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getId() {
        return id;
    }

    public void setCurrency(String currency) {

        switch(currency) {
            case "HUF":
                this.currency = Currency.HUF;
                break;
            case "EUR":
                this.currency = Currency.EUR;
                break;
            default:
                this.currency = Currency.USD;
                break;
        }
    }

    public static class PlayerBuilder
    {
        private String name;


        private BigDecimal balance;

        private Currency currency;

        public PlayerBuilder()
        {
        }

        public String getName() {
            return name;
        }

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public PlayerBuilder setBalance(String balance) {
            this.balance = new BigDecimal(balance);
            return this;
        }

        public Currency getCurrency() {
            return currency;
        }

        public PlayerBuilder setCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public Player getPlayer()
        {
            return new Player(this);
        }
    }
}
