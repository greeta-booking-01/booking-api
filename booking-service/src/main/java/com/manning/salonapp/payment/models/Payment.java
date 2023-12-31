package com.manning.salonapp.payment.models;

import com.manning.salonapp.salonservice.SalonServiceDetail;
import com.manning.salonapp.slot.Slot;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private SalonServiceDetail selectedService;

    @ManyToOne(fetch = FetchType.EAGER)
    private Slot slot;

    private Long amount;
    private LocalDateTime created;
    private LocalDateTime updated;
    private PaymentStatus status;
    private String clientSecret;
    private String intentId;
    private String firstName;
    private String email;
    private String lastName;
    private String phoneNumber;

    public String getName() {
        return firstName + " " + lastName;
    }

    public long getAsCents() {
        return amount * 100;
    }
}
