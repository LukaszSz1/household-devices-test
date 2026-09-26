package com.example.householddevices.application.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeviceCategoryDto {

    private String code;
    private String description;
}
