package com.factory.SmartFinance.bill;

import com.factory.SmartFinance.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User owner;
    private LocalDateTime createdAt;
    private String note;
}
