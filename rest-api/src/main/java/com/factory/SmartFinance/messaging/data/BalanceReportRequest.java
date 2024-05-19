package com.factory.SmartFinance.messaging.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceReportRequest {
    public long userId;
    public Long billId; //may be null
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
}
