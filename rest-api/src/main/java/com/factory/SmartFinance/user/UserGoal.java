package com.factory.SmartFinance.user;

import com.factory.SmartFinance.transaction.PaymentCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "goals")
public class UserGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private boolean active;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime endAt;
    private BigDecimal spendingLimit;
    @ManyToOne
    private PaymentCategory category;

    public Optional<PaymentCategory> getCategory() {
        return Optional.of(category);
    }
}
