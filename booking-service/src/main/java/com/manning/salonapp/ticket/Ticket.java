package com.manning.salonapp.ticket;

import com.manning.salonapp.payment.models.Payment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket {
    TicketStatus ticketStatus = TicketStatus.BOOKED;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Payment payment;
}
