package com.factory.SmartFinance.entities.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment_categories")
public class PaymentCategory {
    @Id
    private String name;
}
