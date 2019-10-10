package com.epam.training.sportsbetting.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Player extends User {

    private String name;

    private int accountNumber;

    private BigDecimal balance;

    private LocalDateTime birth;

    public Player(String email, String password,String name,int accountNumber,BigDecimal balance, LocalDateTime birth) {
        super(email, password);
        this.setName(name);
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
        this.setBirth(birth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }
}
