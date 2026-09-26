package com.example.householddevices.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HouseholdDevice {

    private Long id;
    private String model;
    private String serialNumber;
}
