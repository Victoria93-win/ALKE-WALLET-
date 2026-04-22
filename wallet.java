package com.alkewallet.model;

import com.alkewallet.service.CurrencyConverter;

public class Wallet {

    private double balance;
    private String currency;

    public Wallet(String currency) {
        this.balance = 0;
        this.currency = currency;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Monto inválido");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void convertBalance(CurrencyConverter converter, String newCurrency) {
        balance = converter.convert(balance, currency, newCurrency);
        currency = newCurrency;
    }
}