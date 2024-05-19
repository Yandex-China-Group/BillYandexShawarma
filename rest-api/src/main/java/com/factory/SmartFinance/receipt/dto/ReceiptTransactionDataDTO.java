package com.factory.SmartFinance.receipt.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ReceiptTransactionDataDTO {
    private String transactionTitle;
    private LocalDateTime time;
    private BigDecimal amount;
    private Long billId;
}
