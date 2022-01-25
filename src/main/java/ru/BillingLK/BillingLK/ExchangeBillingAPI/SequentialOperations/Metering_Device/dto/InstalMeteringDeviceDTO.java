package ru.BillingLK.BillingLK.ExchangeBillingAPI.SequentialOperations.Metering_Device.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InstalMeteringDeviceDTO {
    private String meteringDeviceID;
    private String factoryNumber;
    private String channelTypeID;
    private String meteringDeviceTypeName;
    private boolean state;

    private List<DifferentiationsMeteringDeviceDTO> differentiationsMDDTOs = new ArrayList<>();
}
