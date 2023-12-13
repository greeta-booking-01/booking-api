package com.manning.salonapp.payment;

import com.manning.salonapp.common.SalonException;
import com.manning.salonapp.config.SalonDetails;
import com.manning.salonapp.payment.models.Payment;
import com.manning.salonapp.payment.models.PaymentConfirmationResponse;
import com.manning.salonapp.payment.models.PaymentRequest;
import com.manning.salonapp.ticket.Ticket;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/* Payment Controller */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    PaymentService paymentService;
    SalonDetails salonDetails;

    public PaymentController(PaymentService paymentService, SalonDetails salonDetails) {
        this.paymentService = paymentService;
        this.salonDetails = salonDetails;
    }

    @PostMapping("/initiate")
    @Operation(summary = "InitiatePaymentAPI")
    public Payment initiatePayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            return paymentService.initiate(paymentRequest);
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (SalonException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @PutMapping("/confirm/{id}")
    @Operation(summary = "VerifyPaymentAndConfirmSlotAPI")
    public PaymentConfirmationResponse verifyPaymentAndConfirmSlotAPI(@PathVariable Long id) {
        try {
            Ticket ticket = paymentService.confirm(id);

            PaymentConfirmationResponse paymentConfirmationResponse = new PaymentConfirmationResponse();
            paymentConfirmationResponse.setSalonDetails(salonDetails.clone());
            paymentConfirmationResponse.setTicket(ticket);
            return paymentConfirmationResponse;
        } catch (SalonException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
