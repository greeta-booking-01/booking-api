package com.manning.salonapp.ticket;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/* Ticket Controller */
@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{ticketId}")
    @Operation(summary = "VerifyTicketAPI")
    public Ticket verifyTicketAPI(@PathVariable Long ticketId) {
        return ticketService.findById(ticketId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Ticket ID", null));
    }
}
