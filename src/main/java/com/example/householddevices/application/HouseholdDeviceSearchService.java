package com.example.householddevices.application;

import com.example.householddevices.domain.HouseholdDevice;
import org.springframework.stereotype.Service;

@Service
public class HouseholdDeviceSearchService {


    public HouseholdDevice findById() {
        return new HouseholdDevice(1L, "TV", "172949");
    }
}
