package com.factory.SmartFinance.bank;

import com.factory.SmartFinance.bank.dto.TransactionDTO;
import com.factory.SmartFinance.transaction.Transaction;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@Tag(name = "BankController")
@RequestMapping("/banks/request")
public class BankController {

    /**
     * Test endpoint
     * @return set of transactions
     */
    @PostMapping("/transactions")
    public Set<Transaction> transactions() {
        Bank bank = new Bank() {
            @Override
            public long getBankId() {
                return 0;
            }

            @Override
            public UUID getBankSerial() {
                return null;
            }

            @Override
            public String getBankName() {
                return null;
            }

            @Override
            public BankAPI getBankAPI() {
                return new TransactionBankAPI() {
                    @Override
                    public TransactionDTO getTransaction() {
                        return null;
                    }

                    @Override
                    public Set<TransactionDTO> getTransactions() {
                        return Set.of(new TransactionDTO(500), new TransactionDTO(600));
                    }

                    @Override
                    public String getToken() {
                        return null;
                    }

                    @Override
                    public String getVersion() {
                        return null;
                    }
                };
            }
        };

        return ((TransactionBankAPI) bank.getBankAPI())
                .getTransactions().stream()
                .map(dto -> new Transaction(0, null, null, null, null, BigDecimal.valueOf(dto.amount())))
                .collect(Collectors.toSet());
    }
}
