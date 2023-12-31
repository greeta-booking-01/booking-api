package com.manning.salonapp.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* Ticket Repository */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
