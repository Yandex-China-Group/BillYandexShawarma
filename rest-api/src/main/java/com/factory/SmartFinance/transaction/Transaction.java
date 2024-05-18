package com.factory.SmartFinance.transaction;

import com.factory.SmartFinance.bill.Bill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Bill bill;
    @ManyToOne
    private TransactionType transactionType;
    @ManyToOne
    private PaymentCategory paymentCategory;
    private LocalDateTime createdAt;
    private BigDecimal amount;
}
