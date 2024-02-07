package com.example.ratings.models;

import com.example.ratings.enums.Payment_Method;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime payment_date;
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
    @Embedded
    private Money amount;

    private Payment_Method payment_method;
    @Embeddable
    public static class Money {
        private String currency;
        private double amount;
    }
}

