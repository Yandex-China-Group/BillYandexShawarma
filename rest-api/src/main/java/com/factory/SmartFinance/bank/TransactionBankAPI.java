package com.factory.SmartFinance.bank;

import com.factory.SmartFinance.bank.dto.TransactionDTO;

import java.util.Set;

public interface TransactionBankAPI extends BankAPI {
    TransactionDTO getTransaction();
    Set<TransactionDTO> getTransactions();
}
