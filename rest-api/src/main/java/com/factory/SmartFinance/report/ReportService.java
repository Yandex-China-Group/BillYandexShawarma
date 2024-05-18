package com.factory.SmartFinance.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReportService {

    public void orderReport(
            ReportType reportType,
            long userId,
            Long billId,
            LocalDateTime periodStart,
            LocalDateTime periodEnd
    ) {
        Report report = new Report(userId, billId, periodStart, periodEnd);
        //посылать report в RabbitMQ с использованием
    }
}
