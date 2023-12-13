package com.manning.salonapp.payment.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long slotId;
    private Long selectedSalonServiceDetailId;

    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Size(min = 10)
    private String phoneNumber;
}
