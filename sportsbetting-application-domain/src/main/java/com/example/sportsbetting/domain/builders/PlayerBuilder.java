package com.example.sportsbetting.domain.builders;

import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.Currency;
import java.math.BigDecimal;

public class PlayerBuilder
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

    public PlayerBuilder setBalance(BigDecimal balance) {
        this.balance = balance;
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
