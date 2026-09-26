package com.example.householddevices.application.dto;

import com.example.householddevices.domain.exception.InvalidStatusCodeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public enum DeviceStatus {

    ZLECENIE_EKSPERTYZY("ZEK"),
    EKSPERTYZA("EKS"),
    BRAK_ODPOWIEDZIALNOSCI("BOD"),
    AUKCJA("AUK"),
    NAPRAWA("NAP"),
    BRAK_ZGODY_KLIENTA_NA_NAPRAWE("BZK"),
    WYCOFANY("WYC"),
    SZKODA_CALKOWITA("SZC"),
    PRZENIESIONY_DO_INNEJ_SZKODY("PRZ");

    private final String code;

    public static DeviceStatus fromCode(String code) {
        if (code == null) {
            return null;
        }

        for (DeviceStatus status : DeviceStatus.values()) {
            if (status.code.equalsIgnoreCase(code)) {
                return status;
            }
        }

        throw new InvalidStatusCodeException(String.format("Invalid device status code: %s", code));
    }

}