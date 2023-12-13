package com.manning.salonapp.slot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manning.salonapp.salonservice.SalonServiceDetail;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Slot {

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    Set<SalonServiceDetail> availableServices;

    String stylistName;

    LocalDateTime slotFor;

    LocalDateTime lockedAt;

    LocalDateTime confirmedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private SalonServiceDetail selectedService;
    private SlotStatus status;
}
