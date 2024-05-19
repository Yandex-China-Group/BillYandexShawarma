package com.factory.SmartFinance.receipt.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ReceiptDTO {
    private LocalDateTime time;
    private BigDecimal amount;
    // Фиксальный номер
    private String fn;
    private Integer i;
    // Фиксальный признак
    private String fp;
    private Integer n;
}
