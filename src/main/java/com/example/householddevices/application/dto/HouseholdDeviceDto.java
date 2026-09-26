package com.example.householddevices.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.YearMonth;
import java.util.Map;

@Builder
@Getter
public class HouseholdDeviceDto {

    @Setter
    private Long id;
    private DeviceCategoryDto deviceCategory;
    private DeviceTypeDto deviceType;
    private DeviceBrandDto deviceBrand;
    private String deviceModel;
    private String deviceSerialNumber;
    private boolean builtIn;
    private boolean active;
    private DeviceStatus status;
    private String description;
    private YearMonth purchaseDate;
    private boolean purchasedNew;
    private String operator;
    private String claimNumber;
}
