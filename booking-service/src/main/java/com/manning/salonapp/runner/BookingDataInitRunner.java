package com.manning.salonapp.runner;

import com.manning.salonapp.salonservice.SalonServiceDetailRepository;
import com.manning.salonapp.slot.SlotRepository;
import com.manning.salonapp.testdata.TestDbInitializationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookingDataInitRunner implements CommandLineRunner {

    private final SlotRepository slotRepository;

    private final SalonServiceDetailRepository salonServiceDetailRepository;

    @Override
    public void run(String... args) {
        log.info("Initializing data in Booking Service ...");
        TestDbInitializationService testDB = new TestDbInitializationService(salonServiceDetailRepository, slotRepository);
        testDB.initDb();
    }


}