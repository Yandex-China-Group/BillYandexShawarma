package com.factory.SmartFinance.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private long userId;
    private Long billId; //may be null
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
}
