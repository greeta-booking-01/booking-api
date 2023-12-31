package com.manning.salonapp.testdata;

import com.manning.salonapp.salonservice.SalonServiceDetail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockStylist {
    String name;
    List<SalonServiceDetail> services;
    List<Integer> slots;

    public Set<SalonServiceDetail> servicesAsSet() {
        return new HashSet<>(services);
    }
}
