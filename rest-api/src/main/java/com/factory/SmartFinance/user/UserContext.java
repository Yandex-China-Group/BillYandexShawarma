package com.factory.SmartFinance.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_context")
public class UserContext {
    @Id
    private long userId;
    private BigDecimal budgetLimitMonth;
    private BigDecimal balanceLimitDay;
}
