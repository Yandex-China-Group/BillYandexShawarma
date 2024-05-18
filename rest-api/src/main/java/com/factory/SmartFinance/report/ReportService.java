package com.factory.SmartFinance.report;

import com.factory.SmartFinance.messaging.data.BalanceReportRequest;
import com.factory.SmartFinance.messaging.data.ExpensesReportRequest;
import com.factory.SmartFinance.messaging.data.MoneyFlowReportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReportService {
    public void orderMoneyFlowReport(
            long userId,
            Long billId,
            LocalDateTime periodStart,
            LocalDateTime periodEnd
    ) {
        MoneyFlowReportRequest reportRequest = new MoneyFlowReportRequest(userId, billId, periodStart, periodEnd);
        //посылать report в RabbitMQ
    }

    public void orderMoneyBalanceReport(
            long userId,
            Long billId,
            LocalDateTime periodStart,
            LocalDateTime periodEnd
    ) {
        BalanceReportRequest reportRequest = new BalanceReportRequest(userId, billId, periodStart, periodEnd);
    }

    public void orderExpensesReport(
            long userId,
            Long billId,
            LocalDateTime periodStart,
            LocalDateTime periodEnd
    ) {
        ExpensesReportRequest reportRequest = new ExpensesReportRequest(userId, billId, periodStart, periodEnd);
    }
}
