package com.factory.SmartFinance.bank;

import java.util.UUID;

public interface Bank {
    long getBankId();
    UUID getBankSerial();
    String getBankName();
    BankAPI getBankAPI();
}
