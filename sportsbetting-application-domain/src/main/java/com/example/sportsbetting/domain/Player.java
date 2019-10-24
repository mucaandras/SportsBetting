package com.example.sportsbetting.domain;

import com.example.sportsbetting.domain.builders.PlayerBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Player extends User {

    private static int accountCount = 0;

    private String name;

    private int accountNumber;

    private BigDecimal balance;

    private LocalDateTime birth;

    private Currency currency;

    public Player(PlayerBuilder playerBuilder)
    {
        this.accountNumber = accountCount++;
        this.name = playerBuilder.getName();
        this.setBalance(playerBuilder.getBalance());
        this.currency = playerBuilder.getCurrency();
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
}
