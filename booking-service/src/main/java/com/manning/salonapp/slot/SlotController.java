package com.manning.salonapp.slot;


import com.manning.salonapp.salonservice.SalonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/* Slot Controller */
@RestController
@RequestMapping("/api/slots")
@Tag(name = "Slot")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping("/retrieveAvailableSlots/{salonServiceId}/{formattedDate}")
    @Operation(summary = "RetrieveAvailableSlotsAPI")

    public List<Slot> retrieveAvailableSlotsAPI(@PathVariable Long salonServiceId,
                                                @Parameter(description = "Date in yyyy-MM-dd format", required = true) @Schema(defaultValue = "2020-11-21") @PathVariable String formattedDate) {
        return slotService.getSlotsForServiceOnDate(salonServiceId, formattedDate);
    }
}
