package com.factory.SmartFinance.report;

import com.factory.SmartFinance.jwt.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report")
public class ReportController {
    private final JwtService jwtService;
    private final ReportService reportService;

    /**Типы отчётов:
     * <p>
     * 1. Отчёт о движении средств
     *      * Все транзакции
     *      * Сколько было на счету в начале и в конце периода
     *      * Сколько в среднем тратится и получается в день
     *      * Оборот денег
     * 2. Отчёт о остатке средств
     *      * Сколько денег осталось на счету
     *      * На сколько хватит этих денег при темпе трат
     *      * Сколько можно заработать если их вложить
     * 3. Отчёт о расходах
     *      * В каких категориях сколько было трат
     *      * Какие категории можно сократить
     * <p>
     *      */

    @GetMapping("/moneyFlow")
    public void orderMoneyFlowReport(
            HttpServletRequest request,
            @RequestParam(required = false) Long billId,
            @RequestParam(required = false) LocalDateTime periodStart,
            @RequestParam(required = false) LocalDateTime periodEnd
    ) {
        long userId = jwtService.extractId(jwtService.token(request).orElseThrow());
        if (periodStart == null || periodEnd == null) {
            periodEnd = LocalDateTime.now();
            periodStart = periodEnd.minusMonths(1);
        }

        reportService.orderMoneyFlowReport(userId, billId, periodStart, periodEnd);
    }

    @GetMapping("/moneyBalance")
    public void orderMoneyBalanceReport(
            HttpServletRequest request,
            @RequestParam(required = false) Long billId,
            @RequestParam(required = false) LocalDateTime periodStart,
            @RequestParam(required = false) LocalDateTime periodEnd
    ) {
        long userId = jwtService.extractId(jwtService.token(request).orElseThrow());
        if (periodStart == null || periodEnd == null) {
            periodEnd = LocalDateTime.now();
            periodStart = periodEnd.minusMonths(1);
        }

        reportService.orderMoneyBalanceReport(userId, billId, periodStart, periodEnd);
    }

    @GetMapping("/expenses")
    public void orderExpensesReport(
            HttpServletRequest request,
            @RequestParam(required = false) Long billId,
            @RequestParam(required = false) LocalDateTime periodStart,
            @RequestParam(required = false) LocalDateTime periodEnd
    ) {
        long userId = jwtService.extractId(jwtService.token(request).orElseThrow());
        if (periodStart == null || periodEnd == null) {
            periodEnd = LocalDateTime.now();
            periodStart = periodEnd.minusMonths(1);
        }

        reportService.orderExpensesReport(userId, billId, periodStart, periodEnd);
    }
}
