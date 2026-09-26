package com.example.householddevices.adapter.in.rest;

import com.example.householddevices.application.port.RegisterHouseholdDeviceUseCase;
import com.example.householddevices.application.dto.DeviceBrandDto;
import com.example.householddevices.application.dto.DeviceCategoryDto;
import com.example.householddevices.application.dto.DeviceStatus;
import com.example.householddevices.application.dto.DeviceTypeDto;
import com.example.householddevices.application.dto.HouseholdDeviceDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
@Slf4j
public class HouseholdDeviceController {

    private final RegisterHouseholdDeviceUseCase registerHouseholdDeviceUseCase;

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    private HouseholdDeviceResponse getHouseholdDevices(@PathVariable Long id) {
        log.info("Getting household devices for id {}", id);

        return null;
    }

    @PostMapping(path = "/register")
    private Long registerHouseholdDevice(@Valid @RequestBody HouseholdDeviceRequest householdDeviceRequest) {
        log.info("Registering household device {}", householdDeviceRequest);

        return 1L;
    }

    record HouseholdDeviceRequest(
            @NotBlank String deviceCategoryCode,
            @NotBlank String deviceTypeCode,
            @NotBlank String deviceBrandCode,
            @NotBlank String deviceModel,
            @NotBlank String deviceSerialNumber,
            @NotNull Boolean builtIn,
            @NotNull Boolean active,
            @NotBlank String status,
            String description,
            @PastOrPresent YearMonth purchaseDate,
            @NotNull Boolean purchasedNew,
            @NotBlank String operator,
            @NotBlank String claimNumber) {

        private HouseholdDeviceDto mapRequestToDto(HouseholdDeviceRequest request) {
            return HouseholdDeviceDto.builder()
                    .deviceCategory(mapCategory(request.deviceCategoryCode()))
                    .deviceType(mapType(request.deviceTypeCode()))
                    .deviceBrand(mapBrand(request.deviceBrandCode()))
                    .deviceModel(request.deviceModel())
                    .deviceSerialNumber(request.deviceSerialNumber())
                    .builtIn(request.builtIn())
                    .active(request.active())
                    .status(mapStatus(request.status()))
                    .description(request.description())
                    .purchaseDate(request.purchaseDate())
                    .purchasedNew(request.purchasedNew())
                    .operator(request.operator())
                    .claimNumber(request.claimNumber())
                    .build();
        }

        private static DeviceStatus mapStatus(String status) {
            return DeviceStatus.fromCode(status);
        }

        private static DeviceCategoryDto mapCategory(String code) {
            return DeviceCategoryDto.builder()
                    .code(code)
                    .build();
        }

        private static DeviceTypeDto mapType(String code) {
            return DeviceTypeDto.builder()
                    .code(code)
                    .build();
        }

        private static DeviceBrandDto mapBrand(String code) {
            return DeviceBrandDto.builder()
                    .code(code)
                    .build();
        }
    }

    record HouseholdDeviceResponse(
            Long id,
            DeviceCategory deviceCategory,
            DeviceType deviceType,
            DeviceBrand deviceBrand,
            String deviceModel,
            String deviceSerialNumber,
            boolean builtIn,
            boolean active,
            String status,
            String description,
            YearMonth purchaseDate,
            boolean purchasedNew,
            String operator,
            String claimNumber) {

        private static HouseholdDeviceResponse mapDtoToResponse(HouseholdDeviceDto dto) {
            return new HouseholdDeviceResponse(
                    dto.getId(),
                    DeviceCategory.fromDto(dto.getDeviceCategory()),
                    DeviceType.fromDto(dto.getDeviceType()),
                    DeviceBrand.fromDto(dto.getDeviceBrand()),
                    dto.getDeviceModel(),
                    dto.getDeviceSerialNumber(),
                    dto.isBuiltIn(),
                    dto.isActive(),
                    Optional.ofNullable(dto.getStatus()).map(DeviceStatus::getCode).orElse(null),
                    dto.getDescription(),
                    dto.getPurchaseDate(),
                    dto.isPurchasedNew(),
                    dto.getOperator(),
                    dto.getClaimNumber()
            );
        }

        private record DeviceCategory(String code, String title) {
            public static DeviceCategory fromDto(DeviceCategoryDto dto) {
                return new DeviceCategory(dto.getCode(), dto.getDescription());
            }
        }

        private record DeviceType(String code, String title) {
            public static DeviceType fromDto(DeviceTypeDto dto) {
                return new DeviceType(dto.getCode(), dto.getDescription());
            }
        }

        private record DeviceBrand(String code, String title) {
            public static DeviceBrand fromDto(DeviceBrandDto dto) {
                return new DeviceBrand(dto.getCode(), dto.getDescription());
            }
        }
    }
}





