package com.alkewallet.app;

import com.alkewallet.model.Wallet;
import com.alkewallet.service.CurrencyConverter;
import com.alkewallet.service.CurrencyConverterImpl;

public class Main {

    public static void main(String[] args) {

        Wallet wallet = new Wallet("CLP");

        wallet.deposit(100000);
        System.out.println("Saldo: " + wallet.getBalance() + " " + wallet.getCurrency());

        wallet.withdraw(20000);
        System.out.println("Saldo después de retiro: " + wallet.getBalance());

        CurrencyConverter converter = new CurrencyConverterImpl();
        wallet.convertBalance(converter, "USD");

        System.out.println("Saldo convertido: " + wallet.getBalance() + " " + wallet.getCurrency());
    }
}