package com.example.householddevices.application.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeviceBrandDto {

    private String code;
    private String description;
}
