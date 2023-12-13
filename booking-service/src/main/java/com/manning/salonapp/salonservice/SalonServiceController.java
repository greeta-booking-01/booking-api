package com.manning.salonapp.salonservice;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* Salon Service Controller */
@RestController
@RequestMapping("/api/services")
public class SalonServiceController {
    private final SalonService salonService;

    public SalonServiceController(SalonService salonservice) {
        this.salonService = salonservice;
    }

    @GetMapping("/retrieveAvailableSalonServices")
    @Operation(summary = "RetrieveAvailableSalonServicesAPI")
    public List<SalonServiceDetail> retrieveAvailableSalonServicesAPI() {
        return salonService.findAll();
    }
}
